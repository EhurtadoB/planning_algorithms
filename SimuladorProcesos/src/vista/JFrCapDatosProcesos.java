/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import vista.JFrPedirProcesos;
/**
 *
 * @author Eleana Hurtado
 */
public class JFrCapDatosProcesos extends javax.swing.JFrame {

    /**
     * Creates new form JFrCapDatosProcesos
     */
    public JFrCapDatosProcesos() {
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

        jButtonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonGuardar.setText("jButton1");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jButtonGuardar)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addComponent(jButtonGuardar)
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
            if(JFrPedirProcesos.num_proc==0){
                System.exit(0);
            }
            if(JFrPedirProcesos.num_proc==1){
              System.out.println(JFrPedirProcesos.num_proc);
              JFrPedirProcesos.num_proc =JFrPedirProcesos.num_proc-1;
              dispose();
              this.setVisible(true);  
            }
            if(JFrPedirProcesos.num_proc==2){
              System.out.println(JFrPedirProcesos.num_proc);
              JFrPedirProcesos.num_proc =JFrPedirProcesos.num_proc-1;
              dispose();
              this.setVisible(true);  
            }
            if(JFrPedirProcesos.num_proc==3){
              System.out.println(JFrPedirProcesos.num_proc);
              JFrPedirProcesos.num_proc =JFrPedirProcesos.num_proc-1;
              dispose();
              this.setVisible(true);  
            }
            if(JFrPedirProcesos.num_proc==4){
              System.out.println(JFrPedirProcesos.num_proc);
              JFrPedirProcesos.num_proc =JFrPedirProcesos.num_proc-1;
              dispose();
              this.setVisible(true);  
            }
            if(JFrPedirProcesos.num_proc==5){
              System.out.println(JFrPedirProcesos.num_proc);
              JFrPedirProcesos.num_proc =JFrPedirProcesos.num_proc-1;
              dispose();
              this.setVisible(true);  
            }
            if(JFrPedirProcesos.num_proc==6){
              System.out.println(JFrPedirProcesos.num_proc);
              JFrPedirProcesos.num_proc =JFrPedirProcesos.num_proc-1;
              dispose();
              this.setVisible(true);  
            }
            if(JFrPedirProcesos.num_proc==7){
              System.out.println(JFrPedirProcesos.num_proc);
              JFrPedirProcesos.num_proc =JFrPedirProcesos.num_proc-1;
              dispose();
              this.setVisible(true);  
            }
     

    }//GEN-LAST:event_jButtonGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrCapDatosProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrCapDatosProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrCapDatosProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrCapDatosProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrCapDatosProcesos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGuardar;
    // End of variables declaration//GEN-END:variables
}
