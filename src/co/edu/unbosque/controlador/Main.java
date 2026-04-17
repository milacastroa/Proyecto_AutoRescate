package co.edu.unbosque.controlador;

import javax.swing.SwingUtilities;
import co.edu.unbosque.vista.VistaPrincipal;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			VistaPrincipal vista = new VistaPrincipal();
			Controlador controlador = new Controlador(vista);
			vista.setControlador(controlador);
			vista.setVisible(true);
		});
	}
}
