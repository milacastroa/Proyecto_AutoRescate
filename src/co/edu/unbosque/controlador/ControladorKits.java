package co.edu.unbosque.controlador;

import co.edu.unbosque.modelo.entidades.*;
import co.edu.unbosque.modelo.estructuras.*;
import co.edu.unbosque.vista.VistaPrincipal;

public class ControladorKits {

    private VistaPrincipal vista;
    private Pila pilaKits;
    private Pila pilaOperaciones;

    public ControladorKits(VistaPrincipal vista, Pila pilaKits, Pila pilaOperaciones) {
        this.vista = vista;
        this.pilaKits = pilaKits;
        this.pilaOperaciones = pilaOperaciones;
    }

    public void devolverKit(TipoServicio tipo) {
        KitAtencion kit = new KitAtencion(tipo);
        pilaKits.apilar(kit);
        pilaOperaciones.apilar(new Operacion(TipoOperacion.CAMBIO_ESTADO,
                "Kit devuelto: " + tipo, "Kit en campo"));
    }

    public KitAtencion retirarKit() {
        if (pilaKits.estaVacia()) {
            vista.mostrarError("No hay kits en revision.");
            return null;
        }
        return (KitAtencion) pilaKits.desapilar();
    }
}