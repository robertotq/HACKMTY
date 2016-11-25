/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevoleon3;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.lang.String;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static nuevoleon3.MySQLCon.Conection;


/**
 *
 * @author robertotrevino
 */
public class DetallesMunicipio_Form extends javax.swing.JFrame {

    DefaultTableModel modeloTabla;
    MySQLCon con = new MySQLCon();
    
    
    
    
    
    public DetallesMunicipio_Form() throws SQLException {
        int i = Main.codigo_mun;
        
        
        System.out.println(con.getString(i));
        modeloTabla = new DefaultTableModel(null, getColumn());
        
        setFilas();
        
        initComponents();
    }
    
    public String[] getColumn() {
    
    String columna[] = new String[3];
columna[0] = "Tipo";
columna[1] = "Nombre";
columna[2] = "Direción";
    
    return columna;
    }
    
    public void setFilas() {
    try{
    String Query = "SELECT Tipo, Nombre, Direccion FROM DesgloseMunicipios WHERE CodigoM = " + Main.codigo_mun;
    
    Statement st = Conection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            
            Object datos[] = new Object[3];
            while(resultSet.next())
            {
            for(int i = 0; i < 3; i++){
                datos[i] = resultSet.getObject(i+1);
            }
            
            modeloTabla.addRow(datos);
            }
    
    }catch(SQLException ex){
    
    }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setModel(modeloTabla);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 130, 454, 404);

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/robertotrevino/NetBeansProjects/NuevoLeon3/imagenes hack/B_regreso_xs.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 0, 113, 85);

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(300, 10, 410, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/robertotrevino/NetBeansProjects/NuevoLeon3/imagenes hack/nuevas/Fondo.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 830, 570);

        jButton1.setIcon(new javax.swing.ImageIcon("/Users/robertotrevino/NetBeansProjects/NuevoLeon3/imagenes hack/B_regreso_xs.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 0, 140, 80);

        setBounds(0, 0, 831, 589);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Metodo_Form().setVisible(true);
        
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
            java.util.logging.Logger.getLogger(DetallesMunicipio_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesMunicipio_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesMunicipio_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesMunicipio_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DetallesMunicipio_Form().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DetallesMunicipio_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}