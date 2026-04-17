package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

import co.edu.unbosque.controlador.ControladorRegistro;
import co.edu.unbosque.modelo.entidades.*;

public class PanelCliente extends JPanel {

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtZona;

    private JComboBox<TipoCliente> comboTipo;

    private JButton btnRegistrar;
    private JButton btnVolver;

    private ControladorRegistro controladorR;

    public PanelCliente(ControladorRegistro controladorR) {

        this.controladorR = controladorR;

        setLayout(new BorderLayout());

        PanelFondo fondo = new PanelFondo("/img/cliente.png");
        fondo.setLayout(null);
        add(fondo, BorderLayout.CENTER);

        // ===== CAMPOS =====
        txtNombre = new JTextField();
        txtNombre.setBounds(200, 260, 220, 30);
        fondo.add(txtNombre);

        comboTipo = new JComboBox<>(TipoCliente.values());
        comboTipo.setBounds(200, 320, 220, 30);
        fondo.add(comboTipo);

        txtZona = new JTextField();
        txtZona.setBounds(200, 380, 220, 30);
        fondo.add(txtZona);

        // ===== BOTONES =====
        btnRegistrar = new JButton();
        btnRegistrar.setBounds(120, 470, 200, 60);

        btnVolver = new JButton();
        btnVolver.setBounds(30, 590, 120, 40);

        JButton[] botones = {btnRegistrar, btnVolver};

        for (JButton b : botones) {
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            fondo.add(b);
        }

        // ===== ACCIÓN =====
        btnRegistrar.addActionListener(e -> {

            String id = txtId.getText();
            String nombre = txtNombre.getText();
            String zona = txtZona.getText();
            TipoCliente tipo = (TipoCliente) comboTipo.getSelectedItem();

            if (id.isEmpty() || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete los campos obligatorios");
                return;
            }

            controladorR.registrarCliente(nombre, tipo);

            JOptionPane.showMessageDialog(this, "Cliente registrado correctamente");

            // limpiar
            txtId.setText("");
            txtNombre.setText("");
            txtZona.setText("");
        });
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}