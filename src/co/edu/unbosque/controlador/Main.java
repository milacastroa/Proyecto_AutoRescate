package co.edu.unbosque.controlador;

import javax.swing.SwingUtilities;

import co.edu.unbosque.vista.VistaPrincipal;


public class Main {
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {

	        Controlador controlador = new Controlador();

	        VistaPrincipal ventana = new VistaPrincipal();
	        ventana.setVisible(true);
	    });
	}

}
