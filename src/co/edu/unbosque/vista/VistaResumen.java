package co.edu.unbosque.vista;

import javax.swing.*;

public class VistaResumen extends JFrame {

    private PanelResumen panel;
    private JFrame anterior;

    public VistaResumen(JFrame anterior) {

        this.anterior = anterior;

        setTitle("Resumen del sistema");
        setSize(1040, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new PanelResumen();
        add(panel);

        panel.getBtnVolver().addActionListener(e -> {
            anterior.setVisible(true);
            this.dispose();
        });
    }

    public PanelResumen getPanel() {
        return panel;
    }
}