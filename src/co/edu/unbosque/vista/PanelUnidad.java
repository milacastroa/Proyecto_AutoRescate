package co.edu.unbosque.vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelUnidad extends JPanel {

    private JTextField txtTipo, txtZona;
    private JButton btnRegistrar;
    private JTextArea area;

    public PanelUnidad() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(3,2));

        form.add(new JLabel("Tipo:"));
        txtTipo = new JTextField();
        form.add(txtTipo);

        form.add(new JLabel("Zona:"));
        txtZona = new JTextField();
        form.add(txtZona);

        btnRegistrar = new JButton("Registrar Unidad");
        form.add(btnRegistrar);

        add(form, BorderLayout.NORTH);

        area = new JTextArea();
        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}