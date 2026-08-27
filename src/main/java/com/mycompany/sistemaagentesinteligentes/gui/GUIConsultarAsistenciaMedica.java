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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Permite consultar un AgenteAsistenciaMedica seleccionandolo de una lista
 * visible, sin tener que recordar ni escribir su ID.
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class GUIConsultarAsistenciaMedica extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIConsultarAsistenciaMedica.class.getName());

    private JComboBox<AgenteInteligente> cmbAgentes;
    private JLabel lblNombre, lblAutonomia, lblEstado, lblConfianza, lblUsuarioAsignado,
            lblTipoAsistencia, lblUrgencia, lblEspecialidad, lblPrioridad, lblProtocolo;

    public GUIConsultarAsistenciaMedica() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Agente de Asistencia Medica");

        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        panel.setBackground(new Color(21, 101, 192));
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblTitulo = new JLabel("Consultar Agente de Asistencia Medica");
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

        lblNombre = agregarFila(panel, "Nombre:");
        lblAutonomia = agregarFila(panel, "Nivel Autonomia:");
        lblEstado = agregarFila(panel, "Estado Operativo:");
        lblConfianza = agregarFila(panel, "Nivel Confianza:");
        lblUsuarioAsignado = agregarFila(panel, "Usuario Asignado:");
        lblTipoAsistencia = agregarFila(panel, "Tipo Asistencia:");
        lblUrgencia = agregarFila(panel, "Nivel Urgencia:");
        lblEspecialidad = agregarFila(panel, "Especialidad Medica:");
        lblPrioridad = agregarFila(panel, "Prioridad Paciente:");
        lblProtocolo = agregarFila(panel, "Protocolo Emergencia:");

        cargarAgentes();
        cmbAgentes.addActionListener(e -> mostrarSeleccionado());
        mostrarSeleccionado();

        getContentPane().add(panel);
        setSize(620, 560);
    }

    private void cargarAgentes() {
        ServicioAgentes.getAgentes().values().stream()
                .filter(AgenteAsistenciaMedica.class::isInstance)
                .sorted(Comparator.comparing(AgenteInteligente::getNombre, String.CASE_INSENSITIVE_ORDER))
                .forEach(cmbAgentes::addItem);
    }

    private JLabel agregarFila(JPanel panel, String etiqueta) {
        JLabel lblEtiqueta = new JLabel(etiqueta);
        lblEtiqueta.setForeground(Color.WHITE);
        JLabel lblValor = new JLabel("-");
        lblValor.setForeground(Color.WHITE);
        panel.add(lblEtiqueta);
        panel.add(lblValor);
        return lblValor;
    }

    private void mostrarSeleccionado() {
        Object seleccionado = cmbAgentes.getSelectedItem();
        if (!(seleccionado instanceof AgenteAsistenciaMedica ag)) {
            limpiarDatos();
            return;
        }

        lblNombre.setText(ag.getNombre());
        lblAutonomia.setText(String.valueOf(ag.getNivelAutonomia()));
        lblEstado.setText(ag.getEstadoOperativo());
        lblConfianza.setText(String.valueOf(ag.getNivelConfianza()));
        lblUsuarioAsignado.setText(ag.getUsuarioAsignado());
        lblTipoAsistencia.setText(ag.getTipoAsistencia());
        lblUrgencia.setText(String.valueOf(ag.getNivelUrgencia()));
        lblEspecialidad.setText(ag.getEspecialidadMedica());
        lblPrioridad.setText(String.valueOf(ag.getNivelPrioridadPaciente()));
        lblProtocolo.setText(ag.isProtocoloEmergencia() ? "Si" : "No");
    }

    private void limpiarDatos() {
        lblNombre.setText("-");
        lblAutonomia.setText("-");
        lblEstado.setText("-");
        lblConfianza.setText("-");
        lblUsuarioAsignado.setText("-");
        lblTipoAsistencia.setText("-");
        lblUrgencia.setText("-");
        lblEspecialidad.setText("-");
        lblPrioridad.setText("-");
        lblProtocolo.setText("-");
        if (cmbAgentes.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay agentes de asistencia medica registrados.", "Sin agentes", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
