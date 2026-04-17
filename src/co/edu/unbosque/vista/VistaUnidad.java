package co.edu.unbosque.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import co.edu.unbosque.controlador.Controlador;
import co.edu.unbosque.modelo.entidades.TipoUnidad;

public class VistaUnidad extends JFrame {

	private JFrame anterior;

	public VistaUnidad(JFrame anterior, Controlador controlador) {
		this.anterior = anterior;

		setTitle("Registrar Unidad");
		setSize(1040, 700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel root = new JPanel(new BorderLayout());
		root.setBackground(Color.WHITE);
		setContentPane(root);

		// header desde imagen
		Image imgHeader = new ImageIcon(getClass().getResource("/img/unidades.png")).getImage();
		JPanel header = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imgHeader, 0, 0, getWidth(), getHeight(),
						0, 0, 1040, 185, this);
			}
		};
		header.setPreferredSize(new Dimension(1040, 180));
		root.add(header, BorderLayout.NORTH);

		// contenido
		JPanel contenido = new JPanel(new BorderLayout(20, 0));
		contenido.setBackground(Color.WHITE);
		contenido.setBorder(new EmptyBorder(20, 30, 10, 30));
		root.add(contenido, BorderLayout.CENTER);

		// formulario izquierda
		JPanel form = new JPanel(new GridBagLayout());
		form.setBackground(Color.WHITE);
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(10, 5, 10, 5);
		gc.anchor = GridBagConstraints.WEST;
		gc.fill = GridBagConstraints.HORIZONTAL;

		Font fBold = new Font("Arial", Font.BOLD, 13);

		gc.gridx = 0; gc.gridy = 0; gc.weightx = 0;
		form.add(label("Tipo:", fBold), gc);
		gc.gridx = 1; gc.weightx = 1.0;
		String[] tipos = { "Grua", "Moto", "Camioneta", "Vehiculo liviano" };
		JComboBox<String> comboTipo = new JComboBox<>(tipos);
		form.add(comboTipo, gc);

		gc.gridx = 0; gc.gridy = 1; gc.weightx = 0;
		form.add(label("Zona:", fBold), gc);
		gc.gridx = 1; gc.weightx = 1.0;
		JTextField txtZona = new JTextField(15);
		form.add(txtZona, gc);

		gc.gridx = 0; gc.gridy = 2; gc.gridwidth = 2;
		JButton btnRegistrar = new JButton("Registrar Unidad");
		form.add(btnRegistrar, gc);

		contenido.add(form, BorderLayout.WEST);

		// area lista de unidades
		JPanel areaPanel = new JPanel(new BorderLayout(0, 4));
		areaPanel.setBackground(Color.WHITE);
		JLabel lblLista = new JLabel("Lista de unidades");
		lblLista.setFont(fBold);
		JTextArea areaUnidades = new JTextArea();
		areaUnidades.setEditable(false);
		areaUnidades.setLineWrap(true);
		areaPanel.add(lblLista, BorderLayout.NORTH);
		areaPanel.add(new JScrollPane(areaUnidades), BorderLayout.CENTER);
		contenido.add(areaPanel, BorderLayout.CENTER);

		// pie
		JPanel pie = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pie.setBackground(Color.WHITE);
		JButton btnVolver = new JButton("Volver");
		pie.add(btnVolver);
		root.add(pie, BorderLayout.SOUTH);

		// acciones
		btnRegistrar.addActionListener(e -> {
			String zona = txtZona.getText().trim();
			if (zona.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Ingrese la zona.");
				return;
			}
			TipoUnidad tipo = mapearTipo((String) comboTipo.getSelectedItem());
			controlador.registrarUnidad(tipo, zona);
			areaUnidades.append("Tipo: " + tipo + " | Zona: " + zona + "\n");
			txtZona.setText("");
		});

		btnVolver.addActionListener(e -> {
			anterior.setVisible(true);
			this.dispose();
		});
	}

	private JLabel label(String texto, Font f) {
		JLabel l = new JLabel(texto);
		l.setFont(f);
		return l;
	}

	private TipoUnidad mapearTipo(String str) {
		switch (str) {
			case "Grua":     return TipoUnidad.GRUA;
			case "Moto":     return TipoUnidad.MOTO;
			case "Camioneta": return TipoUnidad.CAMIONETA;
			default:         return TipoUnidad.VEHICULO_LIVIANO;
		}
	}
}
