package co.edu.unbosque.controlador;

import co.edu.unbosque.modelo.entidades.*;
import co.edu.unbosque.modelo.estructuras.*;
import co.edu.unbosque.vista.VistaPrincipal;
import java.io.FileWriter;
import java.io.IOException;

public class ControladorOperaciones {

    private VistaPrincipal vista;
    private Pila pilaOperaciones;
    private ListaEnlazada listaSolicitudesAtendidas;

    public ControladorOperaciones(VistaPrincipal vista, Pila pilaOperaciones,
            ListaEnlazada listaSolicitudesAtendidas) {
        this.vista = vista;
        this.pilaOperaciones = pilaOperaciones;
        this.listaSolicitudesAtendidas = listaSolicitudesAtendidas;
    }

    public void revertirOperacion() {
        if (pilaOperaciones.estaVacia()) {
            vista.mostrarError("No hay operaciones para revertir.");
            return;
        }
        Operacion op = (Operacion) pilaOperaciones.desapilar();
        vista.mostrarMensaje("Revertida: " + op.getDescripcion()
                + " | Antes: " + op.getDatosAntes());
    }

    public void exportarCSV() {
        try {
            FileWriter fw = new FileWriter("reporte_dia.csv");
            fw.write("id,cliente,servicio,criticidad,estado,unidad,tecnico,timestamp\n");
            Object[] atendidas = listaSolicitudesAtendidas.obtenerTodos();
            for (Object o : atendidas) {
                SolicitudServicio s = (SolicitudServicio) o;
                fw.write(s.csv() + "\n");
            }
            fw.close();
            vista.mostrarMensaje("CSV exportado correctamente.");
        } catch (IOException e) {
            vista.mostrarError("Error al exportar: " + e.getMessage());
        }
    }
}