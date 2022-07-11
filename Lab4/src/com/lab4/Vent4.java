/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lab4;
import lab3.controlador.*;
import com.lab4.Vent2;
import com.lab4.Vent3;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

/**
 *
 * @author cleme
 */
public class Vent4 extends javax.swing.JFrame {

    /**
     * Cuarta ventana del programa.
     * initComponents() Inicializa los componentes del JFrame.
     */
    public Vent4() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        Volver_v3 = new javax.swing.JButton();
        Aceptar_v3 = new javax.swing.JButton();
        newPlayerName_label = new javax.swing.JLabel();
        newPlayerName_field = new javax.swing.JTextField();
        Separator = new javax.swing.JSeparator();
        qmark1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingresar nombre");
        setPreferredSize(new java.awt.Dimension(320, 260));
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 183, 176));
        background.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        background.setPreferredSize(new java.awt.Dimension(320, 260));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Volver_v3.setBackground(new java.awt.Color(255, 239, 255));
        Volver_v3.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        Volver_v3.setText("VOLVER");
        background.add(Volver_v3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 130, -1));

        Aceptar_v3.setBackground(new java.awt.Color(255, 239, 255));
        Aceptar_v3.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        Aceptar_v3.setText("ACEPTAR");
        Aceptar_v3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar_v3ActionPerformed(evt);
            }
        });
        background.add(Aceptar_v3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        newPlayerName_label.setBackground(new java.awt.Color(255, 183, 176));
        newPlayerName_label.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        newPlayerName_label.setForeground(new java.awt.Color(255, 239, 255));
        newPlayerName_label.setText("Ingresar nombre:");
        background.add(newPlayerName_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        newPlayerName_field.setBackground(new java.awt.Color(255, 239, 255));
        newPlayerName_field.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newPlayerName_field.setToolTipText("");
        newPlayerName_field.setBorder(null);
        newPlayerName_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPlayerName_fieldActionPerformed(evt);
            }
        });
        background.add(newPlayerName_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 190, 30));
        background.add(Separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 130, 10));

        qmark1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/q_mark.png"))); // NOI18N
        qmark1.setToolTipText("Ingresa un nombre para un jugador nuevo.");
        background.add(qmark1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Operación del botón ACEPTAR.
     * @param evt 
     * Oculta Vent4 e inicializa Vent3.
     * Le entrega el nombre ingresado en el campo al controlador.
     * Vuelve a visualizar la nueva lista de jugadores y los elementos del mazo
     * de juego.
     */
    private void Aceptar_v3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar_v3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Vent3 v3 = new Vent3();
        Vent2.controlador.addplayer(newPlayerName_field.getText());
        v3.Jugadores_display1.setText(Vent2.controlador.visualizar_Jugadores());
        v3.elements_display.setText(Vent2.controlador.visualizar_Elementos());
        v3.setVisible(true);  
    }//GEN-LAST:event_Aceptar_v3ActionPerformed

    private void newPlayerName_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPlayerName_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPlayerName_fieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vent4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vent4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vent4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vent4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vent4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar_v3;
    private javax.swing.JSeparator Separator;
    private javax.swing.JButton Volver_v3;
    private javax.swing.JPanel background;
    private javax.swing.JTextField newPlayerName_field;
    private javax.swing.JLabel newPlayerName_label;
    private javax.swing.JLabel qmark1;
    // End of variables declaration//GEN-END:variables
}
