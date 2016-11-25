/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevoleon3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MySQLCon {

static Connection Conection; 

public void connect(String user, String pass, String db_name) throws Exception {
    
    try {
            Class.forName("com.mysql.jdbc.Driver");
            Conection = DriverManager.getConnection("jdbc:mysql://turismonl.cbuubvyr64vn.us-east-1.rds.amazonaws.com:3306/" + db_name, user, pass);
                //JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLCon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public boolean checkFirstConnection() throws SQLException{
    boolean found = false;
    ResultSet resultSet = Conection.getMetaData().getCatalogs();
    try{
    while(resultSet.next() || found == false)
    {
    String databaseName = resultSet.getString(1);
    //System.out.println(databaseName);
    if(databaseName.equals("GestionTurismo"))
        found = true;
    }
    }catch(SQLException e){       
}

    
return found;
}

public void createTableCuentas() {
        try {
            String Query = "CREATE TABLE Cuentas" + ""
                    + "(ID INT, Nomb VARCHAR(10),Contra VARCHAR(25),Type INT)";
            Statement st = Conection.createStatement();
            st.executeUpdate(Query);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 public void createDB(String name) throws Exception {
        try {
            
            String Query = "CREATE DATABASE " + name;
            Statement st = Conection.createStatement();
            st.executeUpdate(Query);
            closeConnection();
            connect("AD1282017", "basededatos1", name);
            //JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
 public void closeConnection() {
        try {
            Conection.close();
            JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
 public void createTable(String name) {
        try {
            String Query = "CREATE TABLE " + name + ""
                    + "(ID VARCHAR(25),Nombre VARCHAR(50), Apellido VARCHAR(50),"
                    + " Edad VARCHAR(3), Sexo VARCHAR(1))";
 
            Statement st = Conection.createStatement();
            st.executeUpdate(Query);
JOptionPane.showMessageDialog(null, "Se ha creado la tabla " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
 public void createMainTable() {
        try {
            String Query = "CREATE TABLE DesgloseMunicipios "
                    + "(ID INT, CodigoM INT,Tipo VARCHAR(15),"
                    + " Nombre VARCHAR(40), Direccion VARCHAR(75))";
 
            Statement st = Conection.createStatement();
            st.executeUpdate(Query);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
  public void createCuiudadTable() {
        try {
            String Query = "CREATE TABLE Ciudades "
                    + "(CodigoM INT,Nombre VARCHAR(25))";

 
            Statement st = Conection.createStatement();
            st.executeUpdate(Query);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public void insertData(String table_name, String ID, String name, String lastname, String age, String gender) {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
                    + "\"" + ID + "\", "
                    + "\"" + name + "\", "
                    + "\"" + lastname + "\", "
                    + "\"" + age + "\", "
                    + "\"" + gender + "\")";
            Statement st = Conection.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }
 
 public int getIntroValues(String table_name, String Username, String Pass) throws SQLException {
     int index = 0; 
     String iD,Password = "";
     
     //try {
            String Query = "SELECT * FROM Cuentas";
            Statement st = Conection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            while (resultSet.next() & index == 0 ) {
                iD = resultSet.getString("Nomb");
                
                if(iD.equals(Username))
                    {
                     Password = resultSet.getString("Contra");
                    }
                    if(Password.equals(Pass))
                    {
                        index = resultSet.getInt("Type");
                        Main.setUserID(resultSet.getInt("ID")); 
                    
                    }  
            }
 
        //} catch (SQLException ex) {
        //    JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        //}
        
        return index;
    }
 
 public void enterNewID(String Pass,String Nomb,int type){
 try {
            int ID = getpreviousID() + 1;
            String Query = "INSERT INTO Cuentas" + " VALUES("
                    + "\"" + ID + "\", "
                    + "\"" + Nomb + "\", "
                    + "\"" + Pass + "\", "
                    + "\"" + type + "\")";
            Statement st = Conection.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
 
 
 }
 
 public void enterNewDesglosadas(int CodigoM ,String tipo,String Nombre, String direccion){
 try {
            String Query = "INSERT INTO DesgloseMunicipios(CodigoM, Tipo, Nombre, Direccion)" + " VALUES("
                    + "\"" + CodigoM + "\", "
                    + "\"" + tipo + "\", "
                    + "\"" + Nombre + "\", "
                    + "\"" + direccion + "\")";
            System.out.println(Query);
            Statement st = Conection.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
 }
 
 public int getIndex(String Nom) throws SQLException {
   int index = -1;  
 String Query = "SELECT CodigoM FROM Ciudades WHERE Nombre ='" + Nom + "'";
 Statement st = Conection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while(resultSet.next())
             index = resultSet.getInt("CodigoM");
 return index;
 
 }
 
 public String getString(int i) throws SQLException{
 String d = "";
 String Query = "SELECT CodigoM FROM Ciudades WHERE Nombre = " + i;
 Statement st = Conection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while(resultSet.next())
              d = resultSet.getString("Nombre");
 
 
 return d;
 }
 
 public int getpreviousID() throws SQLException {
 int ID = -1; 
 String Query = "SELECT * FROM Cuentas";
            Statement st = Conection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while(resultSet.next())
            ID = resultSet.getInt("ID");
 
 return ID; 
 }
 

 
}
