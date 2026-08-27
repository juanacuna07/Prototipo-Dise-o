/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.gui;

import com.mycompany.sistemaagentesinteligentes.model.AgenteAsistenciaMedica;
import com.mycompany.sistemaagentesinteligentes.model.AgenteInteligente;
import com.mycompany.sistemaagentesinteligentes.services.ServicioAgentes;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Permite eliminar un AgenteAsistenciaMedica seleccionandolo de una lista
 * visible, sin tener que recordar ni escribir su ID.
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class GUIEliminarAsistenciaMedica extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIEliminarAsistenciaMedica.class.getName());

    private JComboBox<AgenteInteligente> cmbAgentes;
    private JButton btnEliminar;

    public GUIEliminarAsistenciaMedica() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar Agente de Asistencia Medica");

        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        panel.setBackground(new Color(21, 101, 192));
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblTitulo = new JLabel("Eliminar Agente de Asistencia Medica");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(java.awt.Font.BOLD, 16f));
        panel.add(lblTitulo);
        panel.add(new JLabel());

        JLabel lblSeleccion = new JLabel("Selecciona un agente:");
        lblSeleccion.setForeground(Color.WHITE);
        cmbAgentes = new JComboBox<>();
        cmbAgentes.setRenderer(new AgenteComboRenderer());
        panel.add(lblSeleccion);
        panel.add(cmbAgentes);

        btnEliminar = new JButton("Eliminar seleccionado");
        btnEliminar.setBackground(Color.WHITE);
        btnEliminar.setForeground(new Color(192, 21, 21));
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);
        panel.add(btnEliminar);
        panel.add(new JLabel());

        cargarAgentes();
        actualizarEstadoBoton();
        cmbAgentes.addActionListener(e -> actualizarEstadoBoton());

        getContentPane().add(panel);
        setSize(650, 220);
    }

    private void cargarAgentes() {
        cmbAgentes.removeAllItems();
        ServicioAgentes.getAgentes().values().stream()
                .filter(AgenteAsistenciaMedica.class::isInstance)
                .sorted(Comparator.comparing(AgenteInteligente::getNombre, String.CASE_INSENSITIVE_ORDER))
                .forEach(cmbAgentes::addItem);
    }

    private void actualizarEstadoBoton() {
        btnEliminar.setEnabled(cmbAgentes.getSelectedItem() instanceof AgenteAsistenciaMedica);
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        Object seleccionado = cmbAgentes.getSelectedItem();
        if (!(seleccionado instanceof AgenteAsistenciaMedica agente)) {
            JOptionPane.showMessageDialog(this, "No hay un agente seleccionado.", "Sin seleccion", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Deseas eliminar al agente '" + agente.getNombre() + "'?",
                "Confirmar eliminacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (respuesta != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            ServicioAgentes.deleteAgente(agente.getIdAgente());
            JOptionPane.showMessageDialog(this, "Agente eliminado correctamente");
            cargarAgentes();
            actualizarEstadoBoton();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
