/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevoleon3;

import java.sql.SQLException;
import java.lang.Exception;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import static nuevoleon3.MySQLCon.Conection;

/**
 *
 * @author robertotrevino
 */
public class EditarDesglose extends javax.swing.JFrame {
    
    DefaultListModel modeloLista = new DefaultListModel();
    static MySQLCon con = new MySQLCon();
    static int i = 0;
    static String tip = "";
    String Query;
   
    public EditarDesglose() throws SQLException{
        //refresh();
        test();
        
        initComponents();
    }
    
    public void test() {
    
     Query = "SELECT Nombre FROM DesgloseMunicipios";
       
    String nom = " ";
            
            try{
                Statement st = Conection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
               nom = resultSet.getString("Nombre");
            modeloLista.addElement(nom);
            }catch(NullPointerException ex){   
            }catch(SQLException ex){
            
            }
     jList1 = new javax.swing.JList(modeloLista);
    
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NombreMun = new javax.swing.JComboBox();
        NombreTipo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        NuevoDes = new javax.swing.JButton();
        BuscarBt = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        NombreMun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monterrey", "Abasolo", "Agualeguas", "Los Aldamos","Allende","Anáhuac","Apodaca", "Aramberri", "Bustamante", "Cadereyta Jiménez","Carmen", "Cerralvo", "Ciénega de Flores", "Doctor Arroyo", "Doctor Cross", "Doctor González", "Galeana", "García", "San Pedro Garza García", "General Bravo","General Escobedo", "General Terán", "General Treviño", "General Zaragosa","China", "General Zuazua", "Guadalupe","Los Herreras", "Higueras", "Hualahuises", "Iturbide", "Juárez", "Lampazos de Naranjo", "Linares","Marín", "Melchor Ocampo", "Mier y Noriega", "Mina", "Montemorelos", "Parás", "Pesquería", "Los Ramones", "Rayones", "Ciudad Sabinas Hidalgo", "Salinas Victoria", "San Nicolás de los Garza","Hidalgo", "Santa Cataina", "Santiago","Vallecillo", "Vllaldama"}));
        NombreMun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NombreMunMouseClicked(evt);
            }
        });
        getContentPane().add(NombreMun);
        NombreMun.setBounds(590, 330, 151, 27);

        NombreTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hotel", "Atraccion", "Restaurante"}));
        NombreTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NombreTipoMouseClicked(evt);
            }
        });
        getContentPane().add(NombreTipo);
        NombreTipo.setBounds(560, 380, 180, 27);

        jList1.setModel(modeloLista);
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 210, 301, 218);

        NuevoDes.setText("Nuevo Desglose");
        NuevoDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoDesActionPerformed(evt);
            }
        });
        getContentPane().add(NuevoDes);
        NuevoDes.setBounds(380, 220, 146, 29);

        BuscarBt.setIcon(new javax.swing.ImageIcon("/Users/robertotrevino/NetBeansProjects/NuevoLeon3/imagenes hack/B_Buscar.png")); // NOI18N
        BuscarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBtActionPerformed(evt);
            }
        });
        getContentPane().add(BuscarBt);
        BuscarBt.setBounds(50, 450, 220, 80);

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(580, 430, 170, 28);

        jTextField2.setText("jTextField2");
        getContentPane().add(jTextField2);
        jTextField2.setBounds(600, 480, 160, 28);

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/robertotrevino/NetBeansProjects/NuevoLeon3/imagenes hack/P_EditarDato.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 820, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreMunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreMunMouseClicked

    }//GEN-LAST:event_NombreMunMouseClicked

    private void NombreTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreTipoMouseClicked

    }//GEN-LAST:event_NombreTipoMouseClicked

    private void NuevoDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoDesActionPerformed
    this.setVisible(false);
    new NuevoDesglose().setVisible(true);
    }//GEN-LAST:event_NuevoDesActionPerformed

    private void BuscarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBtActionPerformed
        try {
            i = con.getIndex((String)NombreMun.getSelectedItem());
                   tip = (String)NombreTipo.getSelectedItem();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EditarDesglose.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Query = "SELECT Nombre FROM DesgloseMunicipios WHERE ID =" + i + ", Tipo ='" + tip + "`";
        
    String nom = " ";
            
            try{
                Statement st = Conection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
               nom = resultSet.getString("Nombre");
            modeloLista.addElement(nom);
            }catch(NullPointerException ex){
            
            }catch(SQLException ex){
            
            }
            
    jList1 = new javax.swing.JList(modeloLista);
        
        
        
        
    }//GEN-LAST:event_BuscarBtActionPerformed

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
            java.util.logging.Logger.getLogger(EditarDesglose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarDesglose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarDesglose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarDesglose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EditarDesglose().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(EditarDesglose.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarBt;
    private javax.swing.JComboBox NombreMun;
    private javax.swing.JComboBox NombreTipo;
    private javax.swing.JButton NuevoDes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
