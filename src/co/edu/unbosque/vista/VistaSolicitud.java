package co.edu.unbosque.vista;

import javax.swing.*;

public class VistaSolicitud extends JFrame {

    private PanelSolicitud panel;
    private JFrame anterior;

    public VistaSolicitud(JFrame anterior) {

        this.anterior = anterior;

        setTitle("Crear Solicitud");
        setSize(1040, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new PanelSolicitud();
        add(panel);

        // Acción botón volver
        panel.getBtnVolver().addActionListener(e -> {
            anterior.setVisible(true);
            this.dispose();
        });
    }

    public PanelSolicitud getPanel() {
        return panel;
    }
}