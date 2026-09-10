/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.gui;

import com.mycompany.sistemaagentesinteligentes.model.AgenteAsistenciaMedica;
import com.mycompany.sistemaagentesinteligentes.model.Usuario;
import com.mycompany.sistemaagentesinteligentes.services.IServicioAgentes;
import com.mycompany.sistemaagentesinteligentes.services.ServicioAgentes;
import com.mycompany.sistemaagentesinteligentes.services.ServicioUsuarios;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class GUIAdicionarAsistenciaMedica extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIAdicionarAsistenciaMedica.class.getName());

    private IServicioAgentes servicioAgentes;

    /**
     * Creates new form GUIAdicionarAsistenciaMedica
     */
    public GUIAdicionarAsistenciaMedica() {
        initComponents();
        setLocationRelativeTo(null);
        servicioAgentes = ServicioAgentes.getInstancia();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtIdAgente = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtNivelAutonomia = new javax.swing.JTextField();
        txtEstadoOperativo = new javax.swing.JTextField();
        txtNivelConfianza = new javax.swing.JTextField();
        txtTipoAsistencia = new javax.swing.JTextField();
        txtNivelUrgencia = new javax.swing.JTextField();
        txtEspecialidadMedica = new javax.swing.JTextField();
        txtProtocoloEmergencia = new javax.swing.JTextField();
        txtIdUsuarioAsociar = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GUIAdicionarAsistenciaMedica");

        jPanel1.setBackground(new java.awt.Color(21, 101, 192));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Adicionar Agente de Asistencia Medica");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Agente:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nivel Autonomia (0-100):");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado Operativo:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nivel Confianza (0-100):");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tipo Asistencia:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nivel Urgencia (1-5):");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Especialidad Medica:");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Protocolo Emergencia (true/false):");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Asociar a Usuario (ID, opcional):");

        btnAdicionar.setBackground(new java.awt.Color(255, 255, 255));
        btnAdicionar.setForeground(new java.awt.Color(21, 101, 192));
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(this::btnAdicionarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                        )
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNivelAutonomia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstadoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNivelConfianza, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNivelUrgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEspecialidadMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProtocoloEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdUsuarioAsociar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                    )
                    .addComponent(btnAdicionar)
                )
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdAgente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNivelAutonomia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEstadoOperativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNivelConfianza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTipoAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNivelUrgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEspecialidadMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtProtocoloEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtIdUsuarioAsociar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnAdicionar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        int idAgente;
        try {
            idAgente = Integer.parseInt(txtIdAgente.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo 'ID Agente' debe ser un número entero válido.", "Dato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombre = txtNombre.getText().trim();

        double nivelAutonomia;
        try {
            nivelAutonomia = Double.parseDouble(txtNivelAutonomia.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo 'Nivel Autonomia' debe ser un número válido.", "Dato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String estadoOperativo = txtEstadoOperativo.getText().trim();

        double nivelConfianza;
        try {
            nivelConfianza = Double.parseDouble(txtNivelConfianza.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo 'Nivel Confianza' debe ser un número válido.", "Dato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String tipoAsistencia = txtTipoAsistencia.getText().trim();

        int nivelUrgencia;
        try {
            nivelUrgencia = Integer.parseInt(txtNivelUrgencia.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo 'Nivel Urgencia' debe ser un número entero válido (1-5).", "Dato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String especialidadMedica = txtEspecialidadMedica.getText().trim();

        String strProtocolo = txtProtocoloEmergencia.getText().trim();
        boolean protocoloEmergencia;
        if (strProtocolo.equalsIgnoreCase("true") || strProtocolo.equalsIgnoreCase("si")) {
            protocoloEmergencia = true;
        } else if (strProtocolo.equalsIgnoreCase("false") || strProtocolo.equalsIgnoreCase("no")) {
            protocoloEmergencia = false;
        } else {
            JOptionPane.showMessageDialog(this, "El campo 'Protocolo Emergencia' debe ser 'true' o 'false'.", "Dato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            AgenteAsistenciaMedica ag = new AgenteAsistenciaMedica(idAgente, nombre, nivelAutonomia, estadoOperativo, nivelConfianza,
                    tipoAsistencia, nivelUrgencia, especialidadMedica, protocoloEmergencia);
            servicioAgentes.addAgente(ag);

            // Asociacion opcional con un Usuario (Clase D) ya existente, al momento de crear el agente (Clase B)
            String strIdUsuarioAsociar = txtIdUsuarioAsociar.getText().trim();
            if (!strIdUsuarioAsociar.isEmpty()) {
                try {
                    int idUsuarioAsociar = Integer.parseInt(strIdUsuarioAsociar);
                    Usuario usuario = ServicioUsuarios.getInstancia().buscarUsuario(idUsuarioAsociar);
                    if (usuario == null) {
                        JOptionPane.showMessageDialog(this, "El agente se creó, pero no existe ningún Usuario con el ID " + idUsuarioAsociar + "; no se asoció.", "Usuario no encontrado", JOptionPane.WARNING_MESSAGE);
                    } else {
                        ag.agregarUsuarioAsistido(usuario);
                        usuario.setIdAgenteAsistencia(ag.getIdAgente());
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "El agente se creó, pero el campo 'Asociar a Usuario' debe ser un ID numérico; no se asoció.", "Dato inválido", JOptionPane.WARNING_MESSAGE);
                }
            }

            JOptionPane.showMessageDialog(this, "¡Agente de asistencia médica creado!");

            txtIdAgente.setText("");
            txtNombre.setText("");
            txtNivelAutonomia.setText("");
            txtEstadoOperativo.setText("");
            txtNivelConfianza.setText("");
            txtTipoAsistencia.setText("");
            txtNivelUrgencia.setText("");
            txtEspecialidadMedica.setText("");
            txtProtocoloEmergencia.setText("");
            txtIdUsuarioAsociar.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "No se pudo crear el agente", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new GUIAdicionarAsistenciaMedica().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEspecialidadMedica;
    private javax.swing.JTextField txtEstadoOperativo;
    private javax.swing.JTextField txtIdAgente;
    private javax.swing.JTextField txtIdUsuarioAsociar;
    private javax.swing.JTextField txtNivelAutonomia;
    private javax.swing.JTextField txtNivelConfianza;
    private javax.swing.JTextField txtNivelUrgencia;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProtocoloEmergencia;
    private javax.swing.JTextField txtTipoAsistencia;
    // End of variables declaration//GEN-END:variables
}
