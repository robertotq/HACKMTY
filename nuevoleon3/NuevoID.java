/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevoleon3;

/**
 *
 * @author robertotrevino
 */
public class NuevoID extends javax.swing.JFrame {

    public NuevoID() {
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

        Aceptar = new javax.swing.JButton();
        Contra = new javax.swing.JTextField();
        Nombre = new javax.swing.JTextField();
        TipoUsuario = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Aceptar.setIcon(new javax.swing.ImageIcon("/Users/robertotrevino/NetBeansProjects/NuevoLeon3/imagenes hack/B_aceptar.png")); // NOI18N
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(Aceptar);
        Aceptar.setBounds(590, 450, 220, 80);

        Contra.setText("Contraseña");
        getContentPane().add(Contra);
        Contra.setBounds(450, 310, 180, 28);

        Nombre.setText("Nombre");
        getContentPane().add(Nombre);
        Nombre.setBounds(400, 250, 230, 28);

        TipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Analista", "Capturista", "Guru" }));
        getContentPane().add(TipoUsuario);
        TipoUsuario.setBounds(380, 380, 240, 27);

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/robertotrevino/NetBeansProjects/NuevoLeon3/imagenes hack/B_regreso_xs.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 480, 110, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/robertotrevino/NetBeansProjects/NuevoLeon3/imagenes hack/P_AgregarID.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 570);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 470, 120, 90);

        setBounds(0, 0, 852, 590);
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
     String nombre,contra, tipo;
     int tipoIndex;
      MySQLCon con  = new MySQLCon();   
        
       nombre =  Nombre.getText();
       contra = Contra.getText();
       tipoIndex = TipoUsuario.getSelectedIndex();
       
       switch (tipoIndex){
           case 0:
               con.enterNewID(nombre,contra,1);
               
               this.setVisible(false);
               new MenuAdm_Form().setVisible(true);
               break;
               
           case 1: 
               con.enterNewID(nombre,contra,2);
               
               this.setVisible(false);
               new MenuAdm_Form().setVisible(true);
               break;
               
           case 2: 
               con.enterNewID(nombre,contra,3);
               
               this.setVisible(false);
               new MenuAdm_Form().setVisible(true);
               break;
               
               
           case 3: 
               con.enterNewID(nombre,contra,4);
               
               this.setVisible(false);
               new MenuAdm_Form().setVisible(true);
               break;
               
           default:
               System.out.println("Lo rompiste pero no se como");
               break;
               
       
       
       }
       
        
    }//GEN-LAST:event_AceptarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MenuAdm_Form().setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NuevoID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoID().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JTextField Contra;
    private javax.swing.JTextField Nombre;
    private javax.swing.JComboBox TipoUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
