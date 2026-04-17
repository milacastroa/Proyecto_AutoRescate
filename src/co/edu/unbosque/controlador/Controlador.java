package co.edu.unbosque.controlador;

import co.edu.unbosque.modelo.entidades.*;
import co.edu.unbosque.modelo.estructuras.*;
import co.edu.unbosque.vista.VistaPrincipal;

public class Controlador {

	private VistaPrincipal vista;

	// estructuras compartidas entre subcontroladores
	private ListaEnlazada listaUnidades;
	private ListaEnlazada listaTecnicos;
	private ListaEnlazada listaClientes;
	private ListaEnlazada listaSolicitudesAtendidas;
	private Cola colaSolicitudes;
	private ColaPrioridad colaCriticas;
	private Pila pilaKits;
	private Pila pilaOperaciones;

	private ControladorRegistro ctrlRegistro;
	private ControladorSolicitudes ctrlSolicitudes;
	private ControladorKits ctrlKits;
	private ControladorOperaciones ctrlOperaciones;

	public Controlador(VistaPrincipal vista) {
		this.vista = vista;

		listaUnidades = new ListaEnlazada();
		listaTecnicos = new ListaEnlazada();
		listaClientes = new ListaEnlazada();
		listaSolicitudesAtendidas = new ListaEnlazada();
		colaSolicitudes = new Cola();
		colaCriticas = new ColaPrioridad();
		pilaKits = new Pila();
		pilaOperaciones = new Pila();

		ctrlRegistro = new ControladorRegistro(vista,
				listaUnidades, listaTecnicos, listaClientes, pilaOperaciones);
		ctrlSolicitudes = new ControladorSolicitudes(vista,
				listaUnidades, listaTecnicos, listaClientes,
				listaSolicitudesAtendidas,
				colaSolicitudes, colaCriticas, pilaOperaciones);
		ctrlKits = new ControladorKits(vista, pilaKits, pilaOperaciones);
		ctrlOperaciones = new ControladorOperaciones(vista,
				pilaOperaciones, listaSolicitudesAtendidas);
	}

	public void registrarCliente(String nombre, TipoCliente tipo) {
		ctrlRegistro.registrarCliente(nombre, tipo);
	}

	public void registrarTecnico(String nombre, EspecialidadTecnico especialidad, String zona) {
		ctrlRegistro.registrarTecnico(nombre, especialidad, zona);
	}

	public void registrarUnidad(TipoUnidad tipo, String zona) {
		ctrlRegistro.registrarUnidad(tipo, zona);
	}

	public void crearSolicitud(String nombreCliente, TipoServicio tipoServicio,
			NivelCriticidad criticidad) {
		ctrlSolicitudes.crearSolicitud(nombreCliente, tipoServicio, criticidad);
	}

	public SolicitudServicio atenderSiguiente() {
		return ctrlSolicitudes.atenderSiguiente();
	}

	public void devolverKit(TipoServicio tipo) {
		ctrlKits.devolverKit(tipo);
	}

	public KitAtencion retirarKit() {
		return ctrlKits.retirarKit();
	}

	public void revertirOperacion() {
		ctrlOperaciones.revertirOperacion();
	}

	public void exportarCSV() {
		ctrlOperaciones.exportarCSV();
	}

	// conteos para el panel de resumen
	public int getConteoUnidadesDisponibles() {
		Object[] todas = listaUnidades.obtenerTodos();
		int c = 0;
		for (Object o : todas) {
			if (((UnidadServicio) o).isDisponible()) c++;
		}
		return c;
	}

	public int getConteoUnidadesOcupadas() {
		Object[] todas = listaUnidades.obtenerTodos();
		int c = 0;
		for (Object o : todas) {
			if (!((UnidadServicio) o).isDisponible()) c++;
		}
		return c;
	}

	public int getConteoSolicitudesPendientes() {
		return colaSolicitudes.getTamano() + colaCriticas.getTamano();
	}

	public int getConteoSolicitudesCriticas() {
		return colaCriticas.getTamano();
	}

	public int getConteoKitsRevision() {
		return pilaKits.getTamano();
	}

	public int getConteoTecnicosDisponibles() {
		Object[] todos = listaTecnicos.obtenerTodos();
		int c = 0;
		for (Object o : todos) {
			if (((Tecnico) o).isDisponible()) c++;
		}
		return c;
	}
}
