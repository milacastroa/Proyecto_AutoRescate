package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;
import co.edu.unbosque.controlador.Controlador;

public class VistaPrincipal extends JFrame {

	private Controlador controlador;

	public VistaPrincipal() {
		setTitle("AutoRescate 24/7");
		setSize(1040, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		PanelFondo fondo = new PanelFondo("/img/fondoPrincipal.png");
		add(fondo);

		JButton btnSolicitudes = new JButton("");
		btnSolicitudes.setBounds(80, 410, 180, 50);

		JButton btnUnidades = new JButton("");
		btnUnidades.setBounds(325, 410, 180, 50);

		JButton btnTecnicos = new JButton("");
		btnTecnicos.setBounds(530, 410, 180, 50);

		JButton btnKits = new JButton("");
		btnKits.setBounds(740, 410, 180, 50);

		JButton btnControl = new JButton("");
		btnControl.setBounds(450, 540, 180, 50);

		JButton[] botones = { btnSolicitudes, btnUnidades, btnTecnicos, btnKits, btnControl };
		for (JButton b : botones) {
			b.setOpaque(false);
			b.setContentAreaFilled(false);
			b.setBorderPainted(false);
			b.setFocusPainted(false);
			fondo.add(b);
		}

		// los listeners acceden a controlador en tiempo de clic, no de construccion
		btnSolicitudes.addActionListener(e -> {
			new VistaSolicitud(this, controlador).setVisible(true);
			this.setVisible(false);
		});

		btnUnidades.addActionListener(e -> {
			new VistaUnidad(this, controlador).setVisible(true);
			this.setVisible(false);
		});

		btnTecnicos.addActionListener(e -> {
			new VistaTecnico(this, controlador).setVisible(true);
			this.setVisible(false);
		});

		btnKits.addActionListener(e -> {
			new VistaKits(this, controlador).setVisible(true);
			this.setVisible(false);
		});

		btnControl.addActionListener(e -> {
			new VistaResumen(this, controlador).setVisible(true);
			this.setVisible(false);
		});
	}

	// se llama desde Main despues de construir el controlador
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void mostrarError(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void mostrarMensaje(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Info", JOptionPane.INFORMATION_MESSAGE);
	}
}
