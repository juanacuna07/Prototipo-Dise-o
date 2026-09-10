/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistemaagentesinteligentes.gui;

import com.mycompany.sistemaagentesinteligentes.model.AgenteInteligente;
import com.mycompany.sistemaagentesinteligentes.model.AgenteNavegacion;
import com.mycompany.sistemaagentesinteligentes.services.ServicioAgentes;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Acuña, Luis Hernández, Stephany Trujillo
 */
public class GUIEditarNavegacion extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIEditarNavegacion.class.getName());

    /**
     * Creates new form GUIEditarNavegacion
     */
    public GUIEditarNavegacion() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtConsulta = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtAutonomia = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtConfianza = new javax.swing.JTextField();
        txtOrigen = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        txtPrecision = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GUIEditarNavegacion");

        jPanel1.setBackground(new java.awt.Color(21, 101, 192));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Actualizar Agente de Navegacion");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inserta el ID del agente:");

        txtConsulta.addActionListener(this::txtConsultaActionPerformed);

        btnConsultar.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultar.setForeground(new java.awt.Color(21, 101, 192));
        btnConsultar.setText("Buscar");
        btnConsultar.addActionListener(this::btnConsultarActionPerformed);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID:");

        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("Aun no encontrado");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");

        txtNombre.setEnabled(false);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nivel Autonomia:");

        txtAutonomia.setEnabled(false);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Estado Operativo:");

        txtEstado.setEnabled(false);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nivel Confianza:");

        txtConfianza.setEnabled(false);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Origen:");

        txtOrigen.setEnabled(false);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Destino:");

        txtDestino.setEnabled(false);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Precision GPS:");

        txtPrecision.setEnabled(false);

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setForeground(new java.awt.Color(21, 101, 192));
        btnActualizar.setText("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                        )
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblId)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAutonomia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfianza, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecision, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                    )
                    .addComponent(btnActualizar)
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
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblId))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAutonomia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtConfianza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPrecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsultaActionPerformed
        btnConsultar.doClick();
    }//GEN-LAST:event_txtConsultaActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String idStr = txtConsulta.getText().trim();

        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa el ID del agente a buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int idConsulta = Integer.parseInt(idStr);
            AgenteInteligente agente = ServicioAgentes.getInstancia().buscarAgente(idConsulta);

            if (agente != null && agente instanceof AgenteNavegacion) {
                AgenteNavegacion ag = (AgenteNavegacion) agente;

                lblId.setText(String.valueOf(ag.getIdAgente()));
                txtNombre.setText(ag.getNombre());
                txtAutonomia.setText(String.valueOf(ag.getNivelAutonomia()));
                txtEstado.setText(ag.getEstadoOperativo());
                txtConfianza.setText(String.valueOf(ag.getNivelConfianza()));
                txtOrigen.setText(ag.getOrigen());
                txtDestino.setText(ag.getDestino());
                txtPrecision.setText(String.valueOf(ag.getPrecisionGPS()));

                txtNombre.setEnabled(true);
                txtAutonomia.setEnabled(true);
                txtEstado.setEnabled(true);
                txtConfianza.setEnabled(true);
                txtOrigen.setEnabled(true);
                txtDestino.setEnabled(true);
                txtPrecision.setEnabled(true);
                btnActualizar.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún agente de navegación con ese ID.", "No Encontrado / Tipo Incorrecto", JOptionPane.ERROR_MESSAGE);
                limpiarDatos();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo 'ID' debe ser un número entero válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if ("Aun no encontrado".equals(lblId.getText())) {
            JOptionPane.showMessageDialog(this, "Primero busca un agente válido para actualizarlo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idOriginal = Integer.parseInt(lblId.getText().trim());

        double nivelAutonomia;
        try {
            nivelAutonomia = Double.parseDouble(txtAutonomia.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo 'Nivel Autonomia' debe ser un número válido.", "Dato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double nivelConfianza;
        try {
            nivelConfianza = Double.parseDouble(txtConfianza.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo 'Nivel Confianza' debe ser un número válido.", "Dato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double precisionGPS;
        try {
            precisionGPS = Double.parseDouble(txtPrecision.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo 'Precision GPS' debe ser un número válido.", "Dato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String nombre = txtNombre.getText().trim();
            String estadoOperativo = txtEstado.getText().trim();
            String origen = txtOrigen.getText().trim();
            String destino = txtDestino.getText().trim();

            AgenteNavegacion agenteActualizado = new AgenteNavegacion(idOriginal, nombre, nivelAutonomia, estadoOperativo, nivelConfianza,
                    origen, destino, precisionGPS);

            ServicioAgentes.getInstancia().actualizarAgente(idOriginal, agenteActualizado);

            JOptionPane.showMessageDialog(this, "Agente de navegación actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            txtConsulta.setText("");
            limpiarDatos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void limpiarDatos() {
        lblId.setText("Aun no encontrado");
        txtNombre.setText("");
        txtNombre.setEnabled(false);
        txtAutonomia.setText("");
        txtAutonomia.setEnabled(false);
        txtEstado.setText("");
        txtEstado.setEnabled(false);
        txtConfianza.setText("");
        txtConfianza.setEnabled(false);
        txtOrigen.setText("");
        txtOrigen.setEnabled(false);
        txtDestino.setText("");
        txtDestino.setEnabled(false);
        txtPrecision.setText("");
        txtPrecision.setEnabled(false);
        btnActualizar.setEnabled(false);
    }

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
        java.awt.EventQueue.invokeLater(() -> new GUIEditarNavegacion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtAutonomia;
    private javax.swing.JTextField txtConfianza;
    private javax.swing.JTextField txtConsulta;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtPrecision;
    // End of variables declaration//GEN-END:variables
}
