package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelTecnico extends JPanel {

    private JTextField txtNombre;
    private JComboBox<String> comboEspecialidad;
    private JComboBox<String> comboEstado;
    private JButton btnRegistrar;
    private JTextArea area;

    public PanelTecnico() {

        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(4, 2));

        form.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        form.add(txtNombre);

        form.add(new JLabel("Especialidad:"));
        comboEspecialidad = new JComboBox<>(new String[]{
            "Mecánica", "Electricidad", "Cerrajería", "Combustible"
        });
        form.add(comboEspecialidad);

        form.add(new JLabel("Estado:"));
        comboEstado = new JComboBox<>(new String[]{
            "Disponible", "Ocupado", "Inactivo"
        });
        form.add(comboEstado);

        btnRegistrar = new JButton("Registrar Técnico");
        form.add(btnRegistrar);

        add(form, BorderLayout.NORTH);

        area = new JTextArea();
        add(new JScrollPane(area), BorderLayout.CENTER);

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
    }
}