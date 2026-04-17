package co.edu.unbosque.vista;

import javax.swing.*;

public class VistaKits extends JFrame {

    private PanelKits panel;
    private JFrame anterior;

    public VistaKits(JFrame anterior) {

        this.anterior = anterior;

        setTitle("Gestión de Kits");
        setSize(1040, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new PanelKits();
        add(panel);

        // botón volver
        panel.getBtnVolver().addActionListener(e -> {
            anterior.setVisible(true);
            this.dispose();
        });
    }

    public PanelKits getPanel() {
        return panel;
    }
}