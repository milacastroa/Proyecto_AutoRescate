package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

import co.edu.unbosque.controlador.ControladorRegistro;
import co.edu.unbosque.modelo.entidades.*;

public class PanelCliente extends JPanel {

    private JTextField txtNombre;
    private JTextField txtZona;

    private JComboBox<TipoCliente> comboTipo;

    private JTextArea areaClientes;

    private JButton btnRegistrar;
    private JButton btnVolver;

    private ControladorRegistro controladorR;

    public PanelCliente(ControladorRegistro controladorR) {

        this.controladorR = controladorR;

        setLayout(new BorderLayout());

        PanelFondo fondo = new PanelFondo("/img/cliente.png");
        fondo.setLayout(null);
        add(fondo, BorderLayout.CENTER);

        txtNombre = new JTextField();
        txtNombre.setBounds(200, 260, 220, 30);
        fondo.add(txtNombre);

        comboTipo = new JComboBox<>(TipoCliente.values());
        comboTipo.setBounds(200, 320, 220, 30);
        fondo.add(comboTipo);

        txtZona = new JTextField();
        txtZona.setBounds(200, 380, 220, 30);
        fondo.add(txtZona);

        areaClientes = new JTextArea();
        areaClientes.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaClientes);
        scroll.setBounds(550, 290, 350, 300);
        fondo.add(scroll);

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

        btnRegistrar.addActionListener(e -> {

            String nombre = txtNombre.getText();
            String zona = txtZona.getText();
            TipoCliente tipo = (TipoCliente) comboTipo.getSelectedItem();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el nombre");
                return;
            }

            try {
                controladorR.registrarCliente(nombre, tipo);

                areaClientes.append(
                    "Nombre: " + nombre +
                    " | Tipo: " + tipo +
                    " | Zona: " + zona + "\n"
                );

                JOptionPane.showMessageDialog(this, "Cliente registrado correctamente");

                txtNombre.setText("");
                txtZona.setText("");

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al registrar cliente");
            }
        });
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}