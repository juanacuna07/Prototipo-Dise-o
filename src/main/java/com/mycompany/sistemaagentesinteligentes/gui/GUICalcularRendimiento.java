/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.gui;

import com.mycompany.sistemaagentesinteligentes.model.AgenteAsistenciaMedica;
import com.mycompany.sistemaagentesinteligentes.model.AgenteInteligente;
import com.mycompany.sistemaagentesinteligentes.model.AgenteNavegacion;
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
 * Calcula el rendimiento de un agente seleccionado de una lista, sin pedir ID.
 * Mantiene el ejemplo de polimorfismo porque se trabaja con la referencia
 * abstracta AgenteInteligente y se invoca calcularRendimiento().
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class GUICalcularRendimiento extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUICalcularRendimiento.class.getName());

    private JComboBox<AgenteInteligente> cmbAgentes;
    private JLabel lblTipo;
    private JLabel lblResultado;

    public GUICalcularRendimiento() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calcular Rendimiento (Polimorfismo)");

        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        panel.setBackground(new Color(21, 101, 192));
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblTitulo = new JLabel("Calcular Rendimiento de un Agente");
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

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBackground(Color.WHITE);
        btnCalcular.setForeground(new Color(21, 101, 192));
        btnCalcular.addActionListener(this::btnCalcularActionPerformed);
        panel.add(btnCalcular);
        panel.add(new JLabel());

        JLabel lblTipoTxt = new JLabel("Tipo de agente seleccionado:");
        lblTipoTxt.setForeground(Color.WHITE);
        lblTipo = new JLabel("-");
        lblTipo.setForeground(Color.WHITE);
        panel.add(lblTipoTxt);
        panel.add(lblTipo);

        JLabel lblResultadoTxt = new JLabel("Rendimiento calculado:");
        lblResultadoTxt.setForeground(Color.WHITE);
        lblResultado = new JLabel("-");
        lblResultado.setForeground(Color.WHITE);
        lblResultado.setFont(lblResultado.getFont().deriveFont(java.awt.Font.BOLD, 16f));
        panel.add(lblResultadoTxt);
        panel.add(lblResultado);

        cargarAgentes();
        cmbAgentes.addActionListener(e -> actualizarTipo());
        actualizarTipo();

        getContentPane().add(panel);
        setSize(650, 280);
    }

    private void cargarAgentes() {
        ServicioAgentes.getAgentes().values().stream()
                .sorted(Comparator.comparing(AgenteInteligente::getNombre, String.CASE_INSENSITIVE_ORDER))
                .forEach(cmbAgentes::addItem);
    }

    private void actualizarTipo() {
        Object seleccionado = cmbAgentes.getSelectedItem();
        if (seleccionado instanceof AgenteNavegacion) {
            lblTipo.setText("Agente de Navegacion");
        } else if (seleccionado instanceof AgenteAsistenciaMedica) {
            lblTipo.setText("Agente de Asistencia Medica");
        } else {
            lblTipo.setText("-");
        }
        lblResultado.setText("-");
    }

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {
        Object seleccionado = cmbAgentes.getSelectedItem();
        if (!(seleccionado instanceof AgenteInteligente agente)) {
            JOptionPane.showMessageDialog(this, "No hay agentes registrados para calcular.", "Sin agentes", JOptionPane.WARNING_MESSAGE);
            lblTipo.setText("-");
            lblResultado.setText("-");
            return;
        }

        double rendimiento = agente.calcularRendimiento();
        lblResultado.setText(String.format("%.2f", rendimiento));
    }
}
