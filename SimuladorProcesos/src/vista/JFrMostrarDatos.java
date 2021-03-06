/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import javax.swing.table.DefaultTableModel;
import static vista.JFrCapDatosProcesos.procesos;

/**
 *
 * @author Eleana Hurtado
 */
public class JFrMostrarDatos extends javax.swing.JFrame {

    /**
     * Creates new form JFrMostrarDatos
     */
    DefaultTableModel modelo;
    public JFrMostrarDatos() {
        initComponents();
        modelo= new DefaultTableModel();
        this.setLocationRelativeTo(null);
        jLabel1.setText(JFrMenu.nom_algoritmo);
        modelo.addColumn("Nombre");
        modelo.addColumn("T. Llegada");
        modelo.addColumn("T. CPU");
        modelo.addColumn("Prioridad");
        modelo.addColumn("T. Comienzo");
        modelo.addColumn("T. Final");
        modelo.addColumn("T. Espera");
        this.jTableResultados.setModel(modelo);
        
        String[] info = new String[7];
        for(int x=0; x<procesos.length; x++){
          info[0]=procesos[x].getNomProceso();
          info[1]=Float.toString(procesos[x].getT_llegada());
          info[2]=Float.toString(procesos[x].getT_cpu());
          info[3]=Float.toString(procesos[x].getPrioridad());
          info[4]=Float.toString(procesos[x].getT_comienzo());
          info[5]=Float.toString(procesos[x].getT_fin());
          info[6]=Float.toString(procesos[x].getT_espera());
          modelo.addRow(info);
        }
        
        float suma=0, promedio;
        for(int x=0; x<procesos.length; x++)
        {
            suma+=procesos[x].getT_espera();
        }
        promedio = suma/procesos.length;
        this.jLabelPromedio.setText(Float.toString(promedio));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResultados = new javax.swing.JTable();
        jButtonRetroceder = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelPromedio = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 460, 40));

        jTableResultados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "T. Llegada", "T. CPU", "Prioridad", "T. Comienzo", "T. Fin", "T. Espera"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableResultados.setEnabled(false);
        jScrollPane1.setViewportView(jTableResultados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 510, 170));

        jButtonRetroceder.setBackground(new java.awt.Color(153, 255, 255));
        jButtonRetroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-gira-a-la-izquierda-48.png"))); // NOI18N
        jButtonRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetrocederActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Promedio:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, 30));

        jLabelPromedio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jLabelPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 90, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4c6c326026c11aa31a94f442170502c9.jpg"))); // NOI18N
        jLabelFondo.setText("jLabel1");
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 560, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetrocederActionPerformed
        // TODO add your handling code here:
        JFrMenu menu = new JFrMenu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRetrocederActionPerformed

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
            java.util.logging.Logger.getLogger(JFrMostrarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrMostrarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrMostrarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrMostrarDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrMostrarDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRetroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelPromedio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResultados;
    // End of variables declaration//GEN-END:variables
}
