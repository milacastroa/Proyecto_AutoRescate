package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

import co.edu.unbosque.controlador.Controlador;
import co.edu.unbosque.modelo.entidades.*;

public class PanelSolicitud extends JPanel {

    private JTextField txtCliente;
    private JCheckBox chkCritico;

    private JComboBox<TipoServicio> comboServicio;

    private JTextArea areaCriticas;
    private JTextArea areaNormales;

    private JButton btnCrear;
    private JButton btnVolver;

    private Controlador controlador;

    public PanelSolicitud(Controlador controlador) {

        this.controlador = controlador;

        setLayout(new BorderLayout());

        PanelFondo fondo = new PanelFondo("/img/solicitud.png");
        fondo.setLayout(null);
        add(fondo, BorderLayout.CENTER);

        txtCliente = new JTextField();
        txtCliente.setBounds(200, 265, 220, 30);
        fondo.add(txtCliente);

        comboServicio = new JComboBox<>(TipoServicio.values());
        comboServicio.setBounds(200, 320, 220, 30); 
        fondo.add(comboServicio);

        chkCritico = new JCheckBox();
        chkCritico.setBounds(200, 370, 60, 60);
        chkCritico.setOpaque(false);
        fondo.add(chkCritico);

        areaCriticas = new JTextArea();
        JScrollPane scrollCriticas = new JScrollPane(areaCriticas);
        scrollCriticas.setBounds(550, 290, 350, 150);
        fondo.add(scrollCriticas);

        areaNormales = new JTextArea();
        JScrollPane scrollNormales = new JScrollPane(areaNormales);
        scrollNormales.setBounds(550, 480, 350, 150);
        fondo.add(scrollNormales);

        btnCrear = new JButton();
        btnCrear.setBounds(110, 455, 200, 60);

        btnVolver = new JButton();
        btnVolver.setBounds(30, 590, 120, 40);

        JButton[] botones = {btnCrear, btnVolver};

        for (JButton b : botones) {
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            fondo.add(b);
        }

        btnCrear.addActionListener(e -> {

            String cliente = txtCliente.getText();
            boolean esCritico = chkCritico.isSelected();
            TipoServicio servicio = (TipoServicio) comboServicio.getSelectedItem();

            if (cliente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el cliente");
                return;
            }

            NivelCriticidad nivel = esCritico
                    ? NivelCriticidad.CRITICO
                    : NivelCriticidad.NORMAL;

            controlador.crearSolicitud(cliente, servicio, nivel);

            String solicitud = cliente + " | " + servicio;

            if (esCritico) {
                areaCriticas.append(solicitud + " (CRÍTICO)\n");
            } else {
                areaNormales.append(solicitud + "\n");
            }

            txtCliente.setText("");
            chkCritico.setSelected(false);
        });
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}