package co.edu.unbosque.controlador;

import co.edu.unbosque.modelo.entidades.*;
import co.edu.unbosque.modelo.estructuras.*;
import co.edu.unbosque.vista.VistaPrincipal;

public class Controlador {

    private VistaPrincipal vista;

    // Estructuras compartidas
    private ListaEnlazada listaUnidades;
    private ListaEnlazada listaTecnicos;
    private ListaEnlazada listaClientes;
    private ListaEnlazada listaSolicitudesAtendidas;
    private Cola colaSolicitudes;
    private ColaPrioridad colaCriticas;
    private Pila pilaKits;
    private Pila pilaOperaciones;

    // Subcontroladores
    private ControladorRegistro ctrlRegistro;
    private ControladorSolicitudes ctrlSolicitudes;
    private ControladorKits ctrlKits;
    private ControladorOperaciones ctrlOperaciones;

    public Controlador(VistaPrincipal vista) {
        this.vista = vista;

        // Inicializar estructuras
        this.listaUnidades = new ListaEnlazada();
        this.listaTecnicos = new ListaEnlazada();
        this.listaClientes = new ListaEnlazada();
        this.listaSolicitudesAtendidas = new ListaEnlazada();
        this.colaSolicitudes = new Cola();
        this.colaCriticas = new ColaPrioridad();
        this.pilaKits = new Pila();
        this.pilaOperaciones = new Pila();

        // Pasar estructuras a subcontroladores
        this.ctrlRegistro = new ControladorRegistro(vista,
                listaUnidades, listaTecnicos, listaClientes, pilaOperaciones);
        this.ctrlSolicitudes = new ControladorSolicitudes(vista,
                listaUnidades, listaTecnicos, listaClientes,
                colaSolicitudes, colaCriticas, pilaOperaciones);
        this.ctrlKits = new ControladorKits(vista, pilaKits, pilaOperaciones);
        this.ctrlOperaciones = new ControladorOperaciones(vista,
                pilaOperaciones, listaSolicitudesAtendidas);
    }

    // subcontroladores

    public Controlador() {
		// TODO Auto-generated constructor stub
	}
 
	public void registrarCliente(String nombre, TipoCliente tipo) {
        ctrlRegistro.registrarCliente(nombre, tipo);
        actualizarVista();
    }

    public void registrarTecnico(String nombre, EspecialidadTecnico especialidad, String zona) {
        ctrlRegistro.registrarTecnico(nombre, especialidad, zona);
        actualizarVista();
    }

    public void registrarUnidad(TipoUnidad tipo, String zona) {
        ctrlRegistro.registrarUnidad(tipo, zona);
        actualizarVista();
    }

    public void crearSolicitud(String idCliente, TipoServicio tipoServicio,
            NivelCriticidad criticidad) {
        ctrlSolicitudes.crearSolicitud(idCliente, tipoServicio, criticidad);
        actualizarVista();
    }

    public void atenderSiguiente() {
        ctrlSolicitudes.atenderSiguiente();
        actualizarVista();
    }

    public void devolverKit(TipoServicio tipo) {
        ctrlKits.devolverKit(tipo);
        actualizarVista();
    }

    public KitAtencion retirarKit() {
        KitAtencion kit = ctrlKits.retirarKit();
        actualizarVista();
        return kit;
    }

    public void revertirOperacion() {
        ctrlOperaciones.revertirOperacion();
        actualizarVista();
    }

    public void exportarCSV() {
        ctrlOperaciones.exportarCSV();
    }

    public void actualizarVista() {
        // Se implementa cuando la vista esté lista
    }
}