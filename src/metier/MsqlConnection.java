/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysqltest.mysqlboss;

/**
 *
 * @author sociepka
 */
public class MsqlConnection {
        private java.sql.Connection dbConnect = null;
        private java.sql.Statement dbStatement = null;
        ResultSet res;
        Connection con = null;
        
        public static void MsqlConnection ()
        {}
        /**
     * Connecter à la base de donnée
     * @return false en cas d'échec
     */
    public Boolean connecter() {
     
        try {
     // chargement de la classe du pilote
        Class.forName ("com.mysql.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/toutbois";
        this.dbConnect = DriverManager.getConnection(url,"root","");
        this.dbStatement = this.dbConnect.createStatement(); // création d'un objet requête directe
        
        
        System.out.println ("ça marche ");
        
        return true;
         } catch (SQLException ex) {
            Logger.getLogger(mysqlboss.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mysqlboss.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
 
 
}
