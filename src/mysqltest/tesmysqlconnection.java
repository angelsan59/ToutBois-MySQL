/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltest;
import java.sql.*;
/**
 *
 * @author sociepka
 */
public class tesmysqlconnection {
    public static void main (String[] args) { try {
// chargement de la classe du pilote
Class.forName ("com.mysql.jdbc.Driver");
}
    catch(Exception e)
{
e.printStackTrace ();
}
try
{
String url ="jdbc:mysql://localhost:3306/toutbois";
Connection con= DriverManager.getConnection(url,"root","");
System.out.println ("ça marche ");
}
catch(Exception e)
{
System.out.println ("la connexion a échoué");
}
}
}
