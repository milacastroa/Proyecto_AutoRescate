package co.edu.unbosque.vista;

import javax.swing.*;
import co.edu.unbosque.controlador.Controlador;

public class VistaKits extends JFrame {

	private PanelKits panel;
	private JFrame anterior;

	public VistaKits(JFrame anterior, Controlador controlador) {
		this.anterior = anterior;

		setTitle("Gestion de Kits");
		setSize(1040, 700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		panel = new PanelKits(controlador);
		add(panel);

		panel.getBtnVolver().addActionListener(e -> {
			anterior.setVisible(true);
			this.dispose();
		});
	}

	public PanelKits getPanel() {
		return panel;
	}
}
