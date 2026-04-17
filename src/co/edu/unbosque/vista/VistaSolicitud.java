package co.edu.unbosque.vista;

import javax.swing.*;
import co.edu.unbosque.controlador.Controlador;

public class VistaSolicitud extends JFrame {

	private PanelSolicitud panel;
	private JFrame anterior;

	public VistaSolicitud(JFrame anterior, Controlador controlador) {
		this.anterior = anterior;

		setTitle("Gestionar Solicitudes");
		setSize(1040, 700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		panel = new PanelSolicitud(controlador);
		add(panel);

		panel.getBtnVolver().addActionListener(e -> {
			anterior.setVisible(true);
			this.dispose();
		});
	}

	public PanelSolicitud getPanel() {
		return panel;
	}
}
