package co.edu.unbosque.vista;

import javax.swing.*;

import co.edu.unbosque.controlador.ControladorRegistro;

import java.awt.*;

public class VistaTecnico extends JFrame {

    private JFrame anterior;

    private ControladorRegistro controlador;

    public VistaTecnico(JFrame anterior, ControladorRegistro controlador) {
        this.controlador = controlador;
    

        this.anterior = anterior;

        setTitle("Registrar Técnico");
        setSize(1040, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        PanelFondo fondo = new PanelFondo("/img/tecnico.png");
        fondo.setLayout(null); // IMPORTANTE
        add(fondo);

        

        // ===== TEXTFIELD (Nombre) =====
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(220, 265, 200, 30);
        fondo.add(txtNombre);
        
     // ===== COMBOBOX (Especialidad) =====
        String[] especialidades = {
            "Mecánica", "Electricidad", "Cerrajería", "Combustible"
        };

        JComboBox<String> comboEspecialidad = new JComboBox<>(especialidades);
        comboEspecialidad.setBounds(220, 320, 200, 30);
        fondo.add(comboEspecialidad);

        // ===== ÁREA =====
        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(550, 300, 400, 300);
        fondo.add(scroll);

        // ===== ESTADO =====
        String[] estados = {"Disponible", "Ocupado", "Inactivo"};

        JComboBox<String> comboEstado = new JComboBox<>(estados);
        comboEstado.setBounds(220, 380, 200, 30);
        fondo.add(comboEstado);

        // ===== BOTONES =====
        JButton btnRegistrar = new JButton();
        btnRegistrar.setBounds(130, 470, 200, 60);

        JButton btnVolver = new JButton();
        btnVolver.setBounds(30, 590, 90, 40);

        fondo.add(btnRegistrar);
        fondo.add(btnVolver);
        
        JButton[] botones = {btnRegistrar, btnVolver};

        for (JButton b : botones) {
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setCursor(new Cursor(Cursor.HAND_CURSOR)); // cambia el mouse
            fondo.add(b);
        }

        btnRegistrar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String especialidad = (String) comboEspecialidad.getSelectedItem();
            String estado = (String) comboEstado.getSelectedItem();

            area.append(
                "Nombre: " + nombre +
                " | Especialidad: " + especialidad +
                " | Estado: " + estado + "\n"
            );
        });

        btnVolver.addActionListener(e -> {
            anterior.setVisible(true);
            this.dispose();
        });
    }
}