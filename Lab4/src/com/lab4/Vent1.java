/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lab4;

/**
 *
 * @author cleme
 */
public class Vent1 extends javax.swing.JFrame {

    /**
     * Creates new form prueba_interfaz
     */
    public Vent1() {
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
        Salir_quit = new javax.swing.JButton();
        Jugar_v2 = new javax.swing.JButton();
        Título = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 183, 176));
        background.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Salir_quit.setBackground(new java.awt.Color(255, 239, 255));
        Salir_quit.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        Salir_quit.setText("SALIR");
        background.add(Salir_quit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 100, -1));

        Jugar_v2.setBackground(new java.awt.Color(255, 239, 255));
        Jugar_v2.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        Jugar_v2.setText("JUGAR");
        background.add(Jugar_v2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

        Título.setBackground(new java.awt.Color(255, 183, 176));
        Título.setFont(new java.awt.Font("Segoe UI", 1, 84)); // NOI18N
        Título.setForeground(new java.awt.Color(255, 239, 255));
        Título.setText("DOBBLE");
        background.add(Título, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 330, 160));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Vent1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vent1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vent1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vent1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vent1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jugar_v2;
    private javax.swing.JButton Salir_quit;
    private javax.swing.JLabel Título;
    private javax.swing.JPanel background;
    // End of variables declaration//GEN-END:variables
}
