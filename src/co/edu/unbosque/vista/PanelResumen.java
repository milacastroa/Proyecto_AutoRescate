package co.edu.unbosque.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import co.edu.unbosque.controlador.Controlador;

public class PanelResumen extends JPanel {

	private JLabel valUnidadesDisp;
	private JLabel valUnidadesOcup;
	private JLabel valSolPendientes;
	private JLabel valSolCriticas;
	private JLabel valKitsRevision;
	private JLabel valTecnicosDisp;
	private JButton btnVolver;

	public PanelResumen(Controlador controlador) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		// header desde imagen
		Image imgHeader = new ImageIcon(getClass().getResource("/img/resumen.png")).getImage();
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
		JPanel contenido = new JPanel(new BorderLayout(20, 20));
		contenido.setBackground(Color.WHITE);
		contenido.setBorder(new EmptyBorder(20, 40, 10, 40));
		add(contenido, BorderLayout.CENTER);

		Font fLabel = new Font("Arial", Font.BOLD, 14);
		Font fValor = new Font("Arial", Font.BOLD, 22);
		Color colorValor = new Color(0, 70, 140);

		// grid de estadisticas
		JPanel stats = new JPanel(new GridLayout(3, 4, 20, 20));
		stats.setBackground(Color.WHITE);
		stats.setBorder(new TitledBorder("Estado del sistema"));

		valUnidadesDisp  = new JLabel("0"); valUnidadesDisp.setFont(fValor); valUnidadesDisp.setForeground(colorValor);
		valUnidadesOcup  = new JLabel("0"); valUnidadesOcup.setFont(fValor); valUnidadesOcup.setForeground(colorValor);
		valSolPendientes = new JLabel("0"); valSolPendientes.setFont(fValor); valSolPendientes.setForeground(colorValor);
		valSolCriticas   = new JLabel("0"); valSolCriticas.setFont(fValor); valSolCriticas.setForeground(new Color(180, 0, 0));
		valKitsRevision  = new JLabel("0"); valKitsRevision.setFont(fValor); valKitsRevision.setForeground(colorValor);
		valTecnicosDisp  = new JLabel("0"); valTecnicosDisp.setFont(fValor); valTecnicosDisp.setForeground(colorValor);

		stats.add(stat("Unidades disponibles", valUnidadesDisp, fLabel));
		stats.add(stat("Unidades ocupadas",     valUnidadesOcup, fLabel));
		stats.add(stat("Sol. pendientes",        valSolPendientes, fLabel));
		stats.add(stat("Sol. criticas",          valSolCriticas, fLabel));
		stats.add(stat("Kits en revision",       valKitsRevision, fLabel));
		stats.add(stat("Tecnicos disponibles",   valTecnicosDisp, fLabel));

		contenido.add(stats, BorderLayout.CENTER);

		// botones de operaciones
		JPanel acciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		acciones.setBackground(Color.WHITE);
		JButton btnRevertir = new JButton("Revertir ultima operacion");
		JButton btnExportar = new JButton("Exportar CSV del dia");
		btnRevertir.setFont(new Font("Arial", Font.BOLD, 12));
		btnExportar.setFont(new Font("Arial", Font.BOLD, 12));
		acciones.add(btnRevertir);
		acciones.add(btnExportar);
		contenido.add(acciones, BorderLayout.SOUTH);

		// pie
		JPanel pie = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pie.setBackground(Color.WHITE);
		btnVolver = new JButton("Volver");
		pie.add(btnVolver);
		add(pie, BorderLayout.SOUTH);

		// carga los datos al abrir
		cargarDatos(controlador);

		btnRevertir.addActionListener(e -> {
			controlador.revertirOperacion();
			cargarDatos(controlador);
		});

		btnExportar.addActionListener(e -> controlador.exportarCSV());
	}

	// panel individual de estadistica: etiqueta + valor centrado
	private JPanel stat(String titulo, JLabel valor, Font fLabel) {
		JPanel p = new JPanel(new BorderLayout(0, 4));
		p.setBackground(Color.WHITE);
		p.setBorder(new EmptyBorder(8, 8, 8, 8));
		JLabel lbl = new JLabel(titulo, SwingConstants.CENTER);
		lbl.setFont(fLabel);
		valor.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(lbl, BorderLayout.NORTH);
		p.add(valor, BorderLayout.CENTER);
		return p;
	}

	private void cargarDatos(Controlador controlador) {
		valUnidadesDisp.setText(String.valueOf(controlador.getConteoUnidadesDisponibles()));
		valUnidadesOcup.setText(String.valueOf(controlador.getConteoUnidadesOcupadas()));
		valSolPendientes.setText(String.valueOf(controlador.getConteoSolicitudesPendientes()));
		valSolCriticas.setText(String.valueOf(controlador.getConteoSolicitudesCriticas()));
		valKitsRevision.setText(String.valueOf(controlador.getConteoKitsRevision()));
		valTecnicosDisp.setText(String.valueOf(controlador.getConteoTecnicosDisponibles()));
	}

	public JButton getBtnVolver() { return btnVolver; }
}
