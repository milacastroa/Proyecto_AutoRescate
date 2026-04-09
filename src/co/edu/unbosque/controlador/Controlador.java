package co.edu.unbosque.controlador;

import co.edu.unbosque.modelo.entidades.Cliente;
import co.edu.unbosque.modelo.entidades.EspecialidadTecnico;
import co.edu.unbosque.modelo.entidades.NivelCriticidad;
import co.edu.unbosque.modelo.entidades.Operacion;
import co.edu.unbosque.modelo.entidades.SolicitudServicio;
import co.edu.unbosque.modelo.entidades.Tecnico;
import co.edu.unbosque.modelo.entidades.TipoCliente;
import co.edu.unbosque.modelo.entidades.TipoOperacion;
import co.edu.unbosque.modelo.entidades.TipoServicio;
import co.edu.unbosque.modelo.entidades.TipoUnidad;
import co.edu.unbosque.modelo.entidades.UnidadServicio;
import co.edu.unbosque.modelo.estructuras.Cola;
import co.edu.unbosque.modelo.estructuras.ColaPrioridad;
import co.edu.unbosque.modelo.estructuras.ListaEnlazada;
import co.edu.unbosque.modelo.estructuras.Pila;

public class Controlador {
	//vista
	private VistaPrincipal vista;
	
	//listas
	private ListaEnlazada listaUnidades;
	private ListaEnlazada listaTecnicos;
	private ListaEnlazada listaClientes;
	
	//Colas
	private Cola colaSolicitudes; // para las solicitudes FIFO	
	private ColaPrioridad colaCritica;
	
	//Pilas
	private Pila pilaKits; // para solicitudes LIFO
	private Pila pilaOperaciones;
	
//Constructor
	public Controlador(VistaPrincipal vista) {
		this.vista=vista;
		this.listaUnidades= new ListaEnlazada();
		this.listaTecnicos= new ListaEnlazada();
		this.listaClientes= new ListaEnlazada();
		this.colaSolicitudes = new Cola();
		this.colaCritica= new ColaPrioridad();
		this.pilaKits= new Pila();
		this.pilaOperaciones= new Pila();
	}
	
//Metodos de registros
	public void registrarCliente(String nombre, TipoCliente tipo) {
		Cliente c = new Cliente(nombre, tipo);
		listaClientes.insertar(c);
		registrarOperacion(TipoOperacion.CAMBIO_ESTADO,"registro cliente: "+nombre,"Sin Cliente");
		actualizarVista();
	}
	
	public void registrarTecnico(String nombre, EspecialidadTecnico especialidad,String zona) {
		Tecnico t = new Tecnico(nombre,especialidad,zona);
		listaTecnicos.insertar(t);
		registrarOperacion(TipoOperacion.CAMBIO_ESTADO,"registro tecnico:"+nombre,"sin tecnico");
		actualizarVista();
	}	
	public void registrarUnidad(TipoUnidad tipo,String zona){
		UnidadServicio u = new UnidadServicio(tipo,zona);
		listaUnidades.insertar(u);
		registrarOperacion(TipoOperacion.CAMBIO_ESTADO,"registro unidad"+tipo,"sin unidad");
		actualizarVista();
	}
// Metodos para solicitudes
	public void crearSolicitud(String idCliente,TipoServicio tipoServicio, NivelCriticidad criticidad) {
		Cliente cliente =(Cliente)listaClientes.buscar(idCliente);
		if (cliente==null) {
			vista.mostrarError("Cliente no encontrado");
			return;
		}
		
		SolicitudServicio s = new SolicitudServicio(cliente,tipoServicio,criticidad);
		
		if(criticidad==NivelCriticidad.CRITICO) {
			colaCritica.encolar(s, s.getPrioridad());
		}else {
			colaSolicitudes.encolar(s);
			}
		
		registrarOperacion(TipoOperacion.CAMBIO_ESTADO,"Solicitud creada:"+tipoServicio,"Sin solicitud");
		actualizarVista();
	}//**/
	
// Metodos para asignaciones 	
//otros metodos recurrentes
	public void registrarOperacion(TipoOperacion tipo,String descripcion,String datosAntes) {
		Operacion op = new Operacion(tipo,descripcion,datosAntes);
	}
	
	public void actualizarVista() {
		//tenemos que poblar
	};
	
}
