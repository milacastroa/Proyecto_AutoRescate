package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class VistaPrincipal extends JFrame {

    public VistaPrincipal() {

        setTitle("AutoRescate 24/7");
        setSize(1040, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        PanelFondo fondo = new PanelFondo("/img/fondoPrincipal.png");
        add(fondo);

        JButton btnSolicitudes = new JButton("");
        btnSolicitudes.setBounds(80, 410, 180, 50);

        JButton btnUnidades = new JButton("");
        btnUnidades.setBounds(325, 410, 180, 50);

        JButton btnTecnicos = new JButton("");
        btnTecnicos.setBounds(530, 410, 180, 50);

        JButton btnKits = new JButton("");
        btnKits.setBounds(740, 410, 180, 50);

        JButton btnControl = new JButton("");
        btnControl.setBounds(450, 540, 180, 50);

        JButton[] botones = {
            btnSolicitudes, btnUnidades, btnTecnicos, btnKits, btnControl
        };

        for (JButton b : botones) {
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            fondo.add(b);
        }


        btnSolicitudes.addActionListener(e -> {
            new VistaSolicitud(this).setVisible(true);
            this.setVisible(false);
        });

        btnUnidades.addActionListener(e -> {
            new VistaUnidad(this).setVisible(true);
            this.setVisible(false);
        });

        btnTecnicos.addActionListener(e -> {
           new VistaTecnico(this).setVisible(true);
            this.setVisible(false);
        });

        btnKits.addActionListener(e -> {
        	new VistaKits(this).setVisible(true);
            this.setVisible(false);
        });
        
        btnControl.addActionListener(e -> {
        	new VistaResumen(this).setVisible(true);
            this.setVisible(false);
        });
    }
}