package co.edu.unbosque.vista;

import javax.swing.*;

import co.edu.unbosque.controlador.ControladorRegistro;

public class VistaCliente extends JFrame {

    private PanelCliente panel;

    public VistaCliente(JFrame anterior, ControladorRegistro controladorR) {

        setTitle("Registro de Cliente");
        setSize(1040, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new PanelCliente(controladorR);
        add(panel);

        panel.getBtnVolver().addActionListener(e -> {
            anterior.setVisible(true);
            this.dispose();
        });
    }
}