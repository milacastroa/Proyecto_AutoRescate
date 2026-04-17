package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelResumen extends JPanel {

    private JLabel lblUnidadesDisponibles;
    private JLabel lblUnidadesOcupadas;
    private JLabel lblSolicitudesPendientes;
    private JLabel lblSolicitudesCriticas;
    private JLabel lblKitsRevision;
    private JLabel lblTecnicosDisponibles;

    private JButton btnVolver;

    public PanelResumen() {

        setLayout(null);

        // ===== FONDO =====
        setLayout(new BorderLayout());
        
        PanelFondo fondo = new PanelFondo("/img/resumen.png");
        fondo.setLayout(null);
        add(fondo, BorderLayout.CENTER);

        Font fuente = new Font("Arial", Font.BOLD, 18);
        Color color = new Color(0, 70, 140);

        // ===== LABELS =====
        lblUnidadesDisponibles = new JLabel();
        lblUnidadesDisponibles.setBounds(400, 250, 100, 30);
        lblUnidadesDisponibles.setFont(fuente);
        lblUnidadesDisponibles.setForeground(color);
        fondo.add(lblUnidadesDisponibles);

        lblUnidadesOcupadas = new JLabel();
        lblUnidadesOcupadas.setBounds(400, 315, 100, 30);
        lblUnidadesOcupadas.setFont(fuente);
        lblUnidadesOcupadas.setForeground(color);
        fondo.add(lblUnidadesOcupadas);

        lblSolicitudesPendientes = new JLabel();
        lblSolicitudesPendientes.setBounds(400, 380, 100, 30);
        lblSolicitudesPendientes.setFont(fuente);
        lblSolicitudesPendientes.setForeground(color);
        fondo.add(lblSolicitudesPendientes);

        lblSolicitudesCriticas = new JLabel();
        lblSolicitudesCriticas.setBounds(400, 445, 100, 30);
        lblSolicitudesCriticas.setFont(fuente);
        lblSolicitudesCriticas.setForeground(color);
        fondo.add(lblSolicitudesCriticas);

        lblKitsRevision = new JLabel();
        lblKitsRevision.setBounds(400, 510, 100, 30);
        lblKitsRevision.setFont(fuente);
        lblKitsRevision.setForeground(color);
        fondo.add(lblKitsRevision);

        lblTecnicosDisponibles = new JLabel();
        lblTecnicosDisponibles.setBounds(400, 575, 100, 30);
        lblTecnicosDisponibles.setFont(fuente);
        lblTecnicosDisponibles.setForeground(color);
        fondo.add(lblTecnicosDisponibles);

        // ===== BOTÓN INVISIBLE =====
        btnVolver = new JButton();
        btnVolver.setBounds(30, 590, 120, 40);

        btnVolver.setOpaque(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setFocusPainted(false);
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));

        fondo.add(btnVolver);
    }

    // ===== MÉTODOS PARA ACTUALIZAR =====

    public void setUnidadesDisponibles(int valor) {
        lblUnidadesDisponibles.setText(String.valueOf(valor));
    }

    public void setUnidadesOcupadas(int valor) {
        lblUnidadesOcupadas.setText(String.valueOf(valor));
    }

    public void setSolicitudesPendientes(int valor) {
        lblSolicitudesPendientes.setText(String.valueOf(valor));
    }

    public void setSolicitudesCriticas(int valor) {
        lblSolicitudesCriticas.setText(String.valueOf(valor));
    }

    public void setKitsRevision(int valor) {
        lblKitsRevision.setText(String.valueOf(valor));
    }

    public void setTecnicosDisponibles(int valor) {
        lblTecnicosDisponibles.setText(String.valueOf(valor));
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
}