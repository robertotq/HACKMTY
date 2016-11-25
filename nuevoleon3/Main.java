/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevoleon3;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author robertotrevino
 */
public class Main {
    
    public static int acceso;
    private static int userID; 
    
    public static int codigo_mun = 0;
    static boolean conected;
    static MySQLCon con;
    
    public static void main(String[] args) throws Exception {
    
        
        con = new MySQLCon();

        con.connect("AD1282017","basededatos1","TurismoNL");
        conected = con.checkFirstConnection();
        if(conected)
        {
            con.connect("AD1282017", "basededatos1", "TurismoNL");
         }
        new Intro_Form().setVisible(true);
    }
    
    public static void setUserID(int i){
    userID = i;
    }
    public static int getUserID() {
    return userID;
    }
    
}
