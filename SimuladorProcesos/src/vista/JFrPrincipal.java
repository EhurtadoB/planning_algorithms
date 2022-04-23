/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Eleana Hurtado
 */
public class JFrPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFrPrincipal
     */
    public JFrPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jButtonEmpezar = new javax.swing.JButton();
        jButtonCreditos = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Simulador de planificador de procesos");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 430, 60));

        jButtonEmpezar.setBackground(new java.awt.Color(153, 255, 255));
        jButtonEmpezar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonEmpezar.setForeground(new java.awt.Color(0, 0, 51));
        jButtonEmpezar.setText("Empezar");
        jButtonEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmpezarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEmpezar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 110, 40));

        jButtonCreditos.setBackground(new java.awt.Color(153, 255, 255));
        jButtonCreditos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonCreditos.setText("Creditos");
        jButtonCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreditosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 110, 40));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/83bb374c7295613ac86b18cb5f93edbc.jpg"))); // NOI18N
        jLabelFondo.setText("jLabel1");
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 286));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmpezarActionPerformed
        JFrPedirProcesos pedirProcesos = new JFrPedirProcesos();
        pedirProcesos.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonEmpezarActionPerformed

    private void jButtonCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreditosActionPerformed
        // TODO add your handling code here:
        JFrCreditos creditos = new JFrCreditos();
        creditos.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButtonCreditosActionPerformed

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
            java.util.logging.Logger.getLogger(JFrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreditos;
    private javax.swing.JButton jButtonEmpezar;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables
}
