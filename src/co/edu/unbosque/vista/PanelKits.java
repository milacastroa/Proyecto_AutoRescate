package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelKits extends JPanel {

    private JTextField txtKit;
    private JTextArea areaDisponibles;
    private JTextArea areaRevision;

    private JButton btnAgregar;
    private JButton btnRetirar;
    private JButton btnVolver;

    public PanelKits() {

        setLayout(null);

        // ===== FONDO =====
        setLayout(new BorderLayout());
        
        PanelFondo fondo = new PanelFondo("/img/kits.png");
        fondo.setLayout(null);
        add(fondo, BorderLayout.CENTER);

        // ===== CAMPO KIT =====
        txtKit = new JTextField();
        txtKit.setBounds(110, 270, 200, 30);
        fondo.add(txtKit);

        // ===== ÁREA DISPONIBLES =====
        areaDisponibles = new JTextArea();
        JScrollPane scrollDisponibles = new JScrollPane(areaDisponibles);
        scrollDisponibles.setBounds(550, 270, 350, 150);
        fondo.add(scrollDisponibles);

        // ===== ÁREA REVISIÓN =====
        areaRevision = new JTextArea();
        JScrollPane scrollRevision = new JScrollPane(areaRevision);
        scrollRevision.setBounds(550, 470, 350, 150);
        fondo.add(scrollRevision);

        // ===== BOTONES INVISIBLES =====
        btnAgregar = new JButton();
        btnAgregar.setBounds(130, 390, 220, 60);

        btnRetirar = new JButton();
        btnRetirar.setBounds(130, 480, 220, 60);

        btnVolver = new JButton();
        btnVolver.setBounds(30, 590, 120, 40);

        JButton[] botones = {btnAgregar, btnRetirar, btnVolver};

        for (JButton b : botones) {
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            fondo.add(b);
        }

        // ===== ACCIÓN AGREGAR =====
        btnAgregar.addActionListener(e -> {

            String kit = txtKit.getText();

            if (kit.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el kit");
                return;
            }

            areaDisponibles.append(kit + "\n");
            txtKit.setText("");
        });

        // ===== ACCIÓN RETIRAR =====
        btnRetirar.addActionListener(e -> {

            String contenido = areaDisponibles.getText();

            if (contenido.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay kits disponibles");
                return;
            }

            String[] lineas = contenido.split("\n");
            String ultimo = lineas[lineas.length - 1];

            // reconstruir sin el último
            String nuevoTexto = "";
            for (int i = 0; i < lineas.length - 1; i++) {
                nuevoTexto += lineas[i] + "\n";
            }

            areaDisponibles.setText(nuevoTexto);

            // pasa a revisión
            areaRevision.append(ultimo + "\n");
        });
    }

    // ===== GETTERS =====

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnRetirar() {
        return btnRetirar;
    }
}