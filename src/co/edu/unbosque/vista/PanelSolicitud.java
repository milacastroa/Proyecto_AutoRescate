package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelSolicitud extends JPanel {

    private JTextField txtCliente;
    private JTextField txtDescripcion;
    private JCheckBox chkCritico;

    private JTextArea areaCriticas;
    private JTextArea areaNormales;

    private JButton btnCrear;
    private JButton btnVolver;

    public PanelSolicitud() {

        setLayout(null);

        // ===== FONDO =====
        setLayout(new BorderLayout());

        PanelFondo fondo = new PanelFondo("/img/solicitud.png");
        fondo.setLayout(null);

        add(fondo, BorderLayout.CENTER);

        // ===== CAMPOS =====
        txtCliente = new JTextField();
        txtCliente.setBounds(200, 265, 220, 30);
        fondo.add(txtCliente);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(200, 320, 220, 30);
        fondo.add(txtDescripcion);

        chkCritico = new JCheckBox();
        chkCritico.setBounds(200, 370, 60, 60);
        chkCritico.setOpaque(false);
        fondo.add(chkCritico);

        // ===== ÁREA CRÍTICAS =====
        areaCriticas = new JTextArea();
        JScrollPane scrollCriticas = new JScrollPane(areaCriticas);
        scrollCriticas.setBounds(550, 290, 350, 150);
        fondo.add(scrollCriticas);

        // ===== ÁREA NORMALES =====
        areaNormales = new JTextArea();
        JScrollPane scrollNormales = new JScrollPane(areaNormales);
        scrollNormales.setBounds(550, 480, 350, 150);
        fondo.add(scrollNormales);

        // ===== BOTONES INVISIBLES =====
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

        // ===== ACCIÓN CREAR =====
        btnCrear.addActionListener(e -> {

            String cliente = txtCliente.getText();
            String descripcion = txtDescripcion.getText();
            boolean esCritico = chkCritico.isSelected();

            if (cliente.isEmpty() || descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos");
                return;
            }

            String solicitud = cliente + " | " + descripcion;

            if (esCritico) {
                areaCriticas.append(solicitud + " (CRÍTICO)\n");
            } else {
                areaNormales.append(solicitud + "\n");
            }

            // limpiar campos
            txtCliente.setText("");
            txtDescripcion.setText("");
            chkCritico.setSelected(false);
        });
    }

    // ===== GETTERS =====

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }
}