/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevoleon3;
import java.sql.PreparedStatement;
import javax.swing.DefaultListModel;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import static nuevoleon3.MySQLCon.Conection;

/**
 *
 * @author robertotrevino
 */
public class EditarID extends javax.swing.JFrame {

    static int i = 0;
    static DefaultListModel modeloLista = new DefaultListModel(); 
    static MySQLCon con = new MySQLCon();
    
    public EditarID() throws SQLException {
       
        
        jList1 = new javax.swing.JList(modeloLista);
        modeloLista.clear();
        String Query = "SELECT * FROM Cuentas";
            Statement st = Conection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            String nombre;
                    try {
                while(resultSet.next()){
                nombre = resultSet.getString("Nomb");
                modeloLista.addElement(nombre);
                }
            }catch(NullPointerException e){}
            initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NextID = new javax.swing.JTextField();
        NextContra = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        NextTipo = new javax.swing.JComboBox();
        Apply = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        NextID.setText("CurrntID");
        getContentPane().add(NextID);
        NextID.setBounds(550, 270, 220, 28);

        NextContra.setText("CurrentContra");
        getContentPane().add(NextContra);
        NextContra.setBounds(610, 330, 170, 28);

        jList1.setModel(modeloLista
        );
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(130, 230, 230, 290);

        NextTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Analista", "Capturista", "Guru" }));
        getContentPane().add(NextTipo);
        NextTipo.setBounds(540, 400, 160, 27);

        Apply.setText("Aplicar");
        Apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyActionPerformed(evt);
            }
        });
        getContentPane().add(Apply);
        Apply.setBounds(680, 490, 88, 29);

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/robertotrevino/NetBeansProjects/NuevoLeon3/imagenes hack/B_regreso_xs.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 470, 110, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/robertotrevino/NetBeansProjects/NuevoLeon3/imagenes hack/P_EditarID.png")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 560);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 460, 120, 90);

        setBounds(0, 0, 852, 582);
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
    
     String Nombre = "", Contra = "";
     int tipo = 0; 
        
       i = jList1.getSelectedIndex() +1;
       
       String Query = "SELECT * FROM Cuentas WHERE ID =" + i;
            Statement st;
        try {
            st = Conection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            
            while(resultSet.next())
            {
                Nombre = resultSet.getString("Nomb");
                Contra = resultSet.getString("Contra");
                tipo = resultSet.getInt("Type");     
            }
            } catch (SQLException ex) {
            Logger.getLogger(EditarID.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        NextID.setText(Nombre);
        NextContra.setText(Contra);
        NextTipo.setSelectedIndex(tipo-1);
        
       
    }//GEN-LAST:event_jList1MouseClicked

    private void ApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyActionPerformed
    String nombre, contra, Query;
    int tipo;
        nombre = NextID.getText();
        contra = NextContra.getText();
        tipo = NextTipo.getSelectedIndex() +1;
    
    Query = "UPDATE Cuentas SET Nomb = ?, Contra = ?,Type = ? WHERE ID = ?";
        try {
            PreparedStatement prepared = con.Conection.prepareStatement(Query);
            prepared.setString(1,nombre);
            prepared.setString(2, contra);
            prepared.setInt(3,tipo);
            prepared.setInt(4,i);
            prepared.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(EditarID.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    
        
    
    }//GEN-LAST:event_ApplyActionPerformed

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
            java.util.logging.Logger.getLogger(EditarID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarID.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new EditarID().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(EditarID.class.getName()).log(Level.SEVERE, null, ex);
                }

    }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Apply;
    private javax.swing.JTextField NextContra;
    private javax.swing.JTextField NextID;
    private javax.swing.JComboBox NextTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
