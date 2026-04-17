package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class VistaUnidad extends JFrame {

    private JFrame anterior;

    public VistaUnidad(JFrame anterior) {

        this.anterior = anterior;

        setTitle("Registrar Unidad");
        setSize(1040, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        PanelFondo fondo = new PanelFondo("/img/unidades.png");
        add(fondo);

        // ===== COMBOBOX =====
        String[] tipos = {"Grúa", "Moto", "Camioneta", "Vehículo liviano"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);
        comboTipo.setBounds(200, 270, 200, 30);

        String[] estados = {"Disponible", "Ocupado", "Mantenimiento"};
        JComboBox<String> comboEstado = new JComboBox<>(estados);
        comboEstado.setBounds(200, 380, 200, 30);

        fondo.add(comboTipo);
        fondo.add(comboEstado);

        // ===== TEXTFIELD =====
        JTextField txtZona = new JTextField();
        txtZona.setBounds(200, 325, 200, 30);
        fondo.add(txtZona);

        // ===== BOTONES =====
        JButton btnRegistrar = new JButton();
        btnRegistrar.setBounds(150, 450, 200, 60);

        JButton btnVolver = new JButton();
        btnVolver.setBounds(30, 590, 120, 40);

        // invisibles
        JButton[] botones = {btnRegistrar, btnVolver};

        for (JButton b : botones) {
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            fondo.add(b);
        }

        // ===== ÁREA =====
        JTextArea areaUnidades = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaUnidades);
        scroll.setBounds(500, 300, 400, 300);
        fondo.add(scroll);

        // ===== ACCIONES =====
        btnRegistrar.addActionListener(e -> {
            String tipo = (String) comboTipo.getSelectedItem();
            String zona = txtZona.getText();
            String estado = (String) comboEstado.getSelectedItem();

            areaUnidades.append(
                "Tipo: " + tipo +
                " | Zona: " + zona +
                " | Estado: " + estado + "\n"
            );
        });

        // 🔥 AQUÍ ESTÁ EL ARREGLO IMPORTANTE
        btnVolver.addActionListener(e -> {
            anterior.setVisible(true);
            this.dispose();
        });
    }
}