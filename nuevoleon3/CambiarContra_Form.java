/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevoleon3;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static nuevoleon3.EditarID.con;
import static nuevoleon3.MySQLCon.Conection;

/**
 *
 * @author robertotrevino
 */
public class CambiarContra_Form extends javax.swing.JFrame {

    /**
     * Creates new form CambiarContra_Form
     */
    public CambiarContra_Form() {
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

        ContraActual = new javax.swing.JTextField();
        ContraNueva1 = new javax.swing.JTextField();
        ContraNueva2 = new javax.swing.JTextField();
        Cambiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        ContraActual.setText("jTextField1");
        getContentPane().add(ContraActual);
        ContraActual.setBounds(350, 250, 300, 28);

        ContraNueva1.setText("jTextField2");
        getContentPane().add(ContraNueva1);
        ContraNueva1.setBounds(370, 350, 270, 28);

        ContraNueva2.setText("jTextField3");
        getContentPane().add(ContraNueva2);
        ContraNueva2.setBounds(420, 450, 220, 28);

        Cambiar.setIcon(new javax.swing.ImageIcon("/Users/robertotrevino/NetBeansProjects/NuevoLeon3/imagenes hack/B_cambiar_contra.png")); // NOI18N
        Cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarActionPerformed(evt);
            }
        });
        getContentPane().add(Cambiar);
        Cambiar.setBounds(570, 530, 260, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/robertotrevino/NetBeansProjects/NuevoLeon3/imagenes hack/B_regreso_xs.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 130, 120, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/robertotrevino/NetBeansProjects/NuevoLeon3/imagenes hack/P_CambiarContra.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 590);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 130, 130, 90);

        setBounds(0, 0, 854, 608);
    }// </editor-fold>//GEN-END:initComponents

    private void CambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarActionPerformed
    String ContraAct, CN1 = "", CN2 = "";
    int ID;
    ID = Main.getUserID();
    ContraAct = ContraActual.getText();
    CN1 = ContraNueva1.getText();
    CN2 = ContraNueva2.getText();
    
    if(CN1.equals(CN2)){
    String Query = "SELECT Contra FROM Cuentas WHERE ID = " + ID;
            Statement st;
        try {
            st = Conection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while(resultSet.next())
            {
            String i = resultSet.getString("Contra");
            if(i.equals(ContraAct)){
                String Query2 = "UPDATE Cuentas SET Contra = ? WHERE ID = ?";
                PreparedStatement prepared = con.Conection.prepareStatement(Query2);
                prepared.setString(1,CN1);
                prepared.setInt(2, ID);
                prepared.executeUpdate();
                JOptionPane.showMessageDialog(null, "Contraseña cambiada con éxito");
                this.setVisible(false);
                new Intro_Form().setVisible(true);
            }
            
            }
            
             } catch (SQLException ex) {
            Logger.getLogger(CambiarContra_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }else{
    JOptionPane.showMessageDialog(null, "Contraseñas no coinciden. Intente de nuevo");
    } 
        
        
        
    }//GEN-LAST:event_CambiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        switch(Main.acceso){
            case 1:
                new MenuAdm_Form().setVisible(true);
                break;
                
            case 2:
                new Analista_Form().setVisible(true);
                break;
                
            case 3:
                new Empleado_Form().setVisible(true);
                break;
                
            case 4:
                new Metodo_Form().setVisible(true);
                break;
        }
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
            java.util.logging.Logger.getLogger(CambiarContra_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambiarContra_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambiarContra_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambiarContra_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambiarContra_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cambiar;
    private javax.swing.JTextField ContraActual;
    private javax.swing.JTextField ContraNueva1;
    private javax.swing.JTextField ContraNueva2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
