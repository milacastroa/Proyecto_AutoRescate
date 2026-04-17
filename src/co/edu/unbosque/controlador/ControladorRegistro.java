package co.edu.unbosque.controlador;

import co.edu.unbosque.modelo.entidades.*;
import co.edu.unbosque.modelo.estructuras.*;
import co.edu.unbosque.vista.VistaPrincipal;

public class ControladorRegistro {

    private VistaPrincipal vista;
    private ListaEnlazada listaUnidades;
    private ListaEnlazada listaTecnicos;
    private ListaEnlazada listaClientes;
    private Pila pilaOperaciones;

    public ControladorRegistro(VistaPrincipal vista, ListaEnlazada listaUnidades,
            ListaEnlazada listaTecnicos, ListaEnlazada listaClientes, Pila pilaOperaciones) {
        this.vista = vista;
        this.listaUnidades = listaUnidades;
        this.listaTecnicos = listaTecnicos;
        this.listaClientes = listaClientes;
        this.pilaOperaciones = pilaOperaciones;
    }

    public void registrarCliente(String nombre, TipoCliente tipo) {
        Cliente c = new Cliente(nombre, tipo);
        listaClientes.insertar(c);
        pilaOperaciones.apilar(new Operacion(TipoOperacion.CAMBIO_ESTADO,
                "Registro cliente: " + nombre, "Sin cliente"));
    }

    public void registrarTecnico(String nombre, EspecialidadTecnico especialidad, String zona) {
        Tecnico t = new Tecnico(nombre, especialidad, zona);
        listaTecnicos.insertar(t);
        pilaOperaciones.apilar(new Operacion(TipoOperacion.CAMBIO_ESTADO,
                "Registro tecnico: " + nombre, "Sin tecnico"));
    }

    public void registrarUnidad(TipoUnidad tipo, String zona) {
        UnidadServicio u = new UnidadServicio(tipo, zona);
        listaUnidades.insertar(u);
        pilaOperaciones.apilar(new Operacion(TipoOperacion.CAMBIO_ESTADO,
                "Registro unidad: " + tipo, "Sin unidad"));
    }
}