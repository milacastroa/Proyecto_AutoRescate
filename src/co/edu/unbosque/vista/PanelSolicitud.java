package co.edu.unbosque.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import co.edu.unbosque.controlador.Controlador;
import co.edu.unbosque.modelo.entidades.*;

public class PanelSolicitud extends JPanel {

	private JTextField txtCliente;
	private JComboBox<String> comboTipo;
	private JCheckBox chkCritico;
	private JTextArea areaCriticas;
	private JTextArea areaNormales;
	private JButton btnCrear;
	private JButton btnVolver;
	private JButton btnAtender;
	private JButton btnNuevoCliente;
	private JButton btnControl;

	public PanelSolicitud(Controlador controlador) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		// header: solo la franja superior de la imagen (recorte de los primeros ~185px)
		Image imgHeader = new ImageIcon(getClass().getResource("/img/solicitud.png")).getImage();
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

		// contenido principal: Swing puro
		JPanel contenido = new JPanel(new BorderLayout(20, 0));
		contenido.setBackground(Color.WHITE);
		contenido.setBorder(new EmptyBorder(20, 30, 10, 30));
		add(contenido, BorderLayout.CENTER);

		// formulario izquierda
		JPanel form = new JPanel(new GridBagLayout());
		form.setBackground(Color.WHITE);
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(8, 5, 8, 5);
		gc.anchor = GridBagConstraints.WEST;
		gc.fill = GridBagConstraints.HORIZONTAL;

		Font fBold = new Font("Arial", Font.BOLD, 13);

		// fila 0: cliente + boton nuevo cliente
		gc.gridx = 0; gc.gridy = 0; gc.gridwidth = 1; gc.weightx = 0;
		form.add(crearLabel("Cliente:", fBold), gc);

		gc.gridx = 1; gc.weightx = 1.0;
		txtCliente = new JTextField(15);
		form.add(txtCliente, gc);

		gc.gridx = 2; gc.weightx = 0;
		btnNuevoCliente = new JButton("+ Nuevo");
		form.add(btnNuevoCliente, gc);

		// fila 1: tipo de servicio
		gc.gridx = 0; gc.gridy = 1; gc.gridwidth = 1; gc.weightx = 0;
		form.add(crearLabel("Servicio:", fBold), gc);

		gc.gridx = 1; gc.gridwidth = 2; gc.weightx = 1.0;
		String[] servicios = { "BATERIA", "LLANTA", "GRUA_REMOLQUE", "COMBUSTIBLE",
				"APERTURA_PUERTA", "REVISION_MECANICA", "PASO_CORRIENTE" };
		comboTipo = new JComboBox<>(servicios);
		form.add(comboTipo, gc);

		// fila 2: critico
		gc.gridx = 0; gc.gridy = 2; gc.gridwidth = 1; gc.weightx = 0;
		form.add(crearLabel("Critico:", fBold), gc);

		gc.gridx = 1; gc.gridwidth = 2;
		chkCritico = new JCheckBox();
		chkCritico.setBackground(Color.WHITE);
		form.add(chkCritico, gc);

		// fila 3: botones de accion
		gc.gridx = 0; gc.gridy = 3; gc.gridwidth = 3; gc.weightx = 1.0;
		JPanel acciones = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		acciones.setBackground(Color.WHITE);
		btnCrear = new JButton("Crear Solicitud");
		btnAtender = new JButton("Atender Siguiente");
		acciones.add(btnCrear);
		acciones.add(btnAtender);
		form.add(acciones, gc);

		contenido.add(form, BorderLayout.WEST);

		// areas de visualizacion derecha
		JPanel areas = new JPanel(new GridLayout(2, 1, 0, 15));
		areas.setBackground(Color.WHITE);
		areaCriticas = new JTextArea();
		areaNormales = new JTextArea();
		areas.add(crearAreaPanel("Solicitudes criticas", areaCriticas));
		areas.add(crearAreaPanel("Solicitudes normales", areaNormales));
		contenido.add(areas, BorderLayout.CENTER);

		// pie: boton volver
		JPanel pie = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pie.setBackground(Color.WHITE);
		btnVolver = new JButton("Volver");
		pie.add(btnVolver);
		add(pie, BorderLayout.SOUTH);

		// --- acciones ---

		btnNuevoCliente.addActionListener(e -> {
			String nombre = JOptionPane.showInputDialog(this, "Nombre del cliente:");
			if (nombre == null || nombre.trim().isEmpty()) return;
			String[] opciones = { "PARTICULAR", "EMPRESA_TRANSPORTE", "ASEGURADORA" };
			String tipoStr = (String) JOptionPane.showInputDialog(this,
					"Tipo de cliente:", "Nuevo Cliente",
					JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
			if (tipoStr == null) return;
			controlador.registrarCliente(nombre.trim(), TipoCliente.valueOf(tipoStr));
			JOptionPane.showMessageDialog(this, "Cliente registrado: " + nombre.trim());
		});

		btnCrear.addActionListener(e -> {
			String nombre = txtCliente.getText().trim();
			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Ingrese el nombre del cliente.");
				return;
			}
			TipoServicio tipo = TipoServicio.valueOf((String) comboTipo.getSelectedItem());
			NivelCriticidad nivel = chkCritico.isSelected()
					? NivelCriticidad.CRITICO : NivelCriticidad.NORMAL;
			controlador.crearSolicitud(nombre, tipo, nivel);
			String linea = nombre + " | " + tipo;
			if (nivel == NivelCriticidad.CRITICO) {
				areaCriticas.append(linea + " [CRITICO]\n");
			} else {
				areaNormales.append(linea + "\n");
			}
			txtCliente.setText("");
			chkCritico.setSelected(false);
		});

		btnAtender.addActionListener(e -> {
			SolicitudServicio s = controlador.atenderSiguiente();
			if (s != null) {
				JOptionPane.showMessageDialog(this,
						"Atendida: " + s.getTipoServicio()
						+ "\nUnidad: " + s.getUnidadAsignada().getId().substring(0, 8) + "..."
						+ "\nTecnico: " + s.getTecnicoAsignado().getNombre());
			}
		});
	}

	private JLabel crearLabel(String texto, Font f) {
		JLabel l = new JLabel(texto);
		l.setFont(f);
		return l;
	}

	private JPanel crearAreaPanel(String titulo, JTextArea area) {
		JPanel p = new JPanel(new BorderLayout(0, 4));
		p.setBackground(Color.WHITE);
		JLabel lbl = new JLabel(titulo);
		lbl.setFont(new Font("Arial", Font.BOLD, 13));
		area.setEditable(false);
		area.setLineWrap(true);
		p.add(lbl, BorderLayout.NORTH);
		p.add(new JScrollPane(area), BorderLayout.CENTER);
		return p;
	}

	public JButton getBtnVolver()       { return btnVolver; }
	public JButton getBtnCrear()        { return btnCrear; }
	public JButton getBtnAtender()      { return btnAtender; }
	public JButton getBtnNuevoCliente() { return btnNuevoCliente; }
}
