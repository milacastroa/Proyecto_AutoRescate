package co.edu.unbosque.controlador;

import co.edu.unbosque.modelo.entidades.*;
import co.edu.unbosque.modelo.estructuras.*;
import co.edu.unbosque.vista.VistaPrincipal;

public class ControladorSolicitudes {

	private VistaPrincipal vista;
	private ListaEnlazada listaUnidades;
	private ListaEnlazada listaTecnicos;
	private ListaEnlazada listaClientes;
	private ListaEnlazada listaSolicitudesAtendidas;
	private Cola colaSolicitudes;
	private ColaPrioridad colaCriticas;
	private Pila pilaOperaciones;

	public ControladorSolicitudes(VistaPrincipal vista, ListaEnlazada listaUnidades,
			ListaEnlazada listaTecnicos, ListaEnlazada listaClientes,
			ListaEnlazada listaSolicitudesAtendidas,
			Cola colaSolicitudes, ColaPrioridad colaCriticas, Pila pilaOperaciones) {
		this.vista = vista;
		this.listaUnidades = listaUnidades;
		this.listaTecnicos = listaTecnicos;
		this.listaClientes = listaClientes;
		this.listaSolicitudesAtendidas = listaSolicitudesAtendidas;
		this.colaSolicitudes = colaSolicitudes;
		this.colaCriticas = colaCriticas;
		this.pilaOperaciones = pilaOperaciones;
	}

	public void crearSolicitud(String nombreCliente, TipoServicio tipoServicio,
			NivelCriticidad criticidad) {
		Cliente cliente = (Cliente) listaClientes.buscar(nombreCliente);
		if (cliente == null) {
			vista.mostrarError("Cliente no encontrado: " + nombreCliente);
			return;
		}
		SolicitudServicio s = new SolicitudServicio(cliente, tipoServicio, criticidad);
		// criticas van a cola de prioridad, normales a cola FIFO
		if (criticidad == NivelCriticidad.CRITICO) {
			colaCriticas.encolar(s, s.getPrioridad());
		} else {
			colaSolicitudes.encolar(s);
		}
		pilaOperaciones.apilar(new Operacion(TipoOperacion.CAMBIO_ESTADO,
				"Solicitud creada: " + tipoServicio, "Sin solicitud"));
	}

	public SolicitudServicio atenderSiguiente() {
		SolicitudServicio s = null;
		// criticas primero
		if (!colaCriticas.estaVacia()) {
			s = (SolicitudServicio) colaCriticas.desencolar();
		} else if (!colaSolicitudes.estaVacia()) {
			s = (SolicitudServicio) colaSolicitudes.desencolar();
		} else {
			vista.mostrarError("No hay solicitudes pendientes.");
			return null;
		}

		UnidadServicio unidad = buscarUnidadDisponible();
		Tecnico tecnico = buscarTecnicoDisponible();

		if (unidad == null || tecnico == null) {
			vista.mostrarError("No hay recursos disponibles para atender la solicitud.");
			// regresa la solicitud a su cola original
			if (s.getCriticidad() == NivelCriticidad.CRITICO) {
				colaCriticas.encolar(s, s.getPrioridad());
			} else {
				colaSolicitudes.encolar(s);
			}
			return null;
		}

		s.asignarUnidad(unidad);
		s.asignarTecnico(tecnico);
		s.setEstado(EstadoSolicitud.ATENDIDA);
		// sale del conjunto de pendientes y pasa al historial del dia
		listaSolicitudesAtendidas.insertar(s);
		pilaOperaciones.apilar(new Operacion(TipoOperacion.ASIGNACION_UNIDAD,
				"Asignacion: " + s.getId(), s.toString()));
		return s;
	}

	// busca la primera unidad libre y no en mantenimiento
	private UnidadServicio buscarUnidadDisponible() {
		Object[] todas = listaUnidades.obtenerTodos();
		for (Object o : todas) {
			UnidadServicio u = (UnidadServicio) o;
			if (u.isDisponible() && u.getEstado() != EstadoUnidad.MANTENIMIENTO) return u;
		}
		return null;
	}

	private Tecnico buscarTecnicoDisponible() {
		Object[] todos = listaTecnicos.obtenerTodos();
		for (Object o : todos) {
			Tecnico t = (Tecnico) o;
			if (t.isDisponible()) return t;
		}
		return null;
	}
}
