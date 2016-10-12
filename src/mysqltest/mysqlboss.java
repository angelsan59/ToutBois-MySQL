/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltest;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sociepka
 */
public class mysqlboss {

    private java.sql.Connection dbConnect = null;
    private java.sql.Statement dbStatement = null;
 ResultSet res;
 Connection con = null;
 
    public mysqlboss() {
 }

  /**
     * Connecter à la base de donnée
     * @return false en cas d'échec
     */
    public Boolean connect() {
     
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
    
    public String ListeReprésentants ()
    {
        String liste = "";
        mysqlboss test = new mysqlboss();
       if (test.connect())
       {

       // création d'une variable qui référencera l'ensemble des résultats
       
            try {
                
              res = this.dbStatement.executeQuery("SELECT numrep,nomrep,prenomrep FROM representants");
   
                // Exploitation du résultat de la requête
                while (res.next())
                {
                    int i = res.getInt("numrep");
                    String nom = res.getString("nomrep");
                    String prenom = res.getString("prenomrep");
                    System.out.println("ligne " + i + " " + nom + " " + prenom );
                    String chaine = i + " " + nom + " " + prenom;
                    return chaine;
                } 
            } catch (SQLException ex) {
                Logger.getLogger(mysqlboss.class.getName()).log(Level.SEVERE, null, ex);
            }
           
    }
       else {}
       return liste;
    }  
    

public void FermerConnection()
{
 try {
res.close(); // il est recommandé de fermer le resultset
//même si le garbage collector fait le travail quand même.
con.close(); // idem pour la connexion
 }
 catch (SQLException ex) {
            Logger.getLogger(mysqlboss.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
