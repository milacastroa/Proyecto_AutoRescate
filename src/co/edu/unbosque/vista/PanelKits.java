package co.edu.unbosque.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import co.edu.unbosque.controlador.Controlador;
import co.edu.unbosque.modelo.entidades.*;

public class PanelKits extends JPanel {

	private JButton btnVolver;

	public PanelKits(Controlador controlador) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		// header desde imagen
		Image imgHeader = new ImageIcon(getClass().getResource("/img/kits.png")).getImage();
		JPanel header = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imgHeader, 0, 0, getWidth(), getHeight(),
						0, 0, 1040, 185, this);
			}
		};
		header.setPreferredSize(new Dimension(1040, 180));
		add(header, BorderLayout.NORTH);

		// contenido
		JPanel contenido = new JPanel(new BorderLayout(20, 0));
		contenido.setBackground(Color.WHITE);
		contenido.setBorder(new EmptyBorder(20, 30, 10, 30));
		add(contenido, BorderLayout.CENTER);

		Font fBold = new Font("Arial", Font.BOLD, 13);

		// formulario izquierda
		JPanel form = new JPanel(new GridBagLayout());
		form.setBackground(Color.WHITE);
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(10, 5, 10, 5);
		gc.anchor = GridBagConstraints.WEST;
		gc.fill = GridBagConstraints.HORIZONTAL;

		gc.gridx = 0; gc.gridy = 0; gc.weightx = 0;
		form.add(label("Tipo de kit:", fBold), gc);
		gc.gridx = 1; gc.weightx = 1.0;
		String[] servicios = { "BATERIA", "LLANTA", "GRUA_REMOLQUE", "COMBUSTIBLE",
				"APERTURA_PUERTA", "REVISION_MECANICA", "PASO_CORRIENTE" };
		JComboBox<String> comboTipo = new JComboBox<>(servicios);
		form.add(comboTipo, gc);

		gc.gridx = 0; gc.gridy = 1; gc.gridwidth = 2;
		JButton btnAgregar = new JButton("Devolver a revision");
		form.add(btnAgregar, gc);

		gc.gridy = 2;
		JButton btnRetirar = new JButton("Retirar del stack (LIFO)");
		form.add(btnRetirar, gc);

		contenido.add(form, BorderLayout.WEST);

		// areas derecha
		JPanel areas = new JPanel(new GridLayout(2, 1, 0, 15));
		areas.setBackground(Color.WHITE);

		JTextArea areaRevision = new JTextArea();
		areaRevision.setEditable(false);
		areaRevision.setLineWrap(true);
		areas.add(areaPanel("Kits en revision (pila)", areaRevision));

		JTextArea areaListos = new JTextArea();
		areaListos.setEditable(false);
		areaListos.setLineWrap(true);
		areas.add(areaPanel("Kits listos para despacho", areaListos));

		contenido.add(areas, BorderLayout.CENTER);

		// pie
		JPanel pie = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pie.setBackground(Color.WHITE);
		btnVolver = new JButton("Volver");
		pie.add(btnVolver);
		add(pie, BorderLayout.SOUTH);

		// acciones
		btnAgregar.addActionListener(e -> {
			TipoServicio tipo = TipoServicio.valueOf((String) comboTipo.getSelectedItem());
			controlador.devolverKit(tipo);
			areaRevision.append("En revision: " + tipo + "\n");
		});

		btnRetirar.addActionListener(e -> {
			KitAtencion kit = controlador.retirarKit();
			if (kit != null) {
				areaListos.append("Listo para despacho: " + kit.getTipo() + "\n");
			}
		});
	}

	private JLabel label(String texto, Font f) {
		JLabel l = new JLabel(texto);
		l.setFont(f);
		return l;
	}

	private JPanel areaPanel(String titulo, JTextArea area) {
		JPanel p = new JPanel(new BorderLayout(0, 4));
		p.setBackground(Color.WHITE);
		JLabel lbl = new JLabel(titulo);
		lbl.setFont(new Font("Arial", Font.BOLD, 13));
		p.add(lbl, BorderLayout.NORTH);
		p.add(new JScrollPane(area), BorderLayout.CENTER);
		return p;
	}

	public JButton getBtnVolver() { return btnVolver; }
}
