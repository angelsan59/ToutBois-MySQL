
package Tables;

import javax.swing.table.*;
import java.io.*;
import java.util.*;

/**
 * Classe dérivée de la classe AbstractTableModel dans la bibliothèque java swing. 
 * Convertit les données contenues dans un fichier txt en vector pour les ranger dans une table affichée sur la fenêtre de gestion
 * des clients, prospects et représentants
 * 
 * @author Sandrine Ociepka
 * @author Stephane Coulon
 * @version 1.0
 */
 public class DataFileTableModel extends AbstractTableModel {
        /**
        * Données du fichier mis dans un vector
        */
         protected Vector data;            
        /**
        * Titre des colonnes du fichier mis dans un vector
        */
         protected Vector columnNames ;    //noms de colonnes
        /**
        * Nom du fichier  Txt à ouvrir et son chemin.
        */
         protected String datafile;        //nom du fichier de données
        
/**
 * Constructeur qui transfère les données d'un fichier txt dans des vectors
 * @param f données du fichier ouvert
 */
    public DataFileTableModel(String f) {
          datafile=f;
          initVectors();
         }
 
    /**
     * Initialisation des vectors (un pour les entetes de colonnes et un pour les données).
     * Et lecture du fichier texte avec gestion d'exception si le fichier est introuvable.
    */
    public void initVectors() {
        String ligne;
        boolean voirtout = false ;
        data=new Vector();
        columnNames=new Vector();
        
        try {
            FileInputStream fin=new FileInputStream(datafile);
            BufferedReader br=new BufferedReader(new InputStreamReader(fin, "UTF-8"));
            // lecture des noms de colonnes (1ère ligne)
            ligne=br.readLine();
            // Analyse de la ligne de données lue précédemment avec séparateur de données, ";"
            StringTokenizer st1=new StringTokenizer(ligne, ";");
            while(st1.hasMoreTokens()) {
                columnNames.addElement(st1.nextToken());
            }
            
            // lecture des données
            while ((ligne = br.readLine()) != null) {
            StringTokenizer st2=new StringTokenizer(ligne, ";");
            String vartempo = st2.nextToken() ;
            if (vartempo.equals("Oui")) {
                data.addElement(vartempo) ;
                while(st2.hasMoreTokens()) {
                  data.addElement(st2.nextToken());
                }
                }
                else
                {
                if (voirtout == true) {
                    data.addElement(vartempo) ; 
                    while(st2.hasMoreTokens()) {
                    data.addElement(st2.nextToken());
                    }
                }    
                }
            }    
           br.close();
          } catch (Exception e) {
           e.printStackTrace();
          }
         }
    /**
     * retourne le nombre de colonnes
     * @return nombre d'éléments du champ columnNames
     */
  public int getColumnCount() {
          return columnNames.size();
         }
    /**
    * retourne le nombre de lignes, obtenu en divisant le nombre d'éléments du champ data par le nombre de colonnes
    * @return nombre de lignes
    */
   public int getRowCount() {
          return data.size()/getColumnCount();
         }
   /**
    * reourne le nom des colonnes
    * @param columnIndex numéro de la colonne
    * @return nom des colonnes
    */
   public String getColumnName(int columnIndex) {
          String colName="";
          if (columnIndex<=getColumnCount())
           colName=(String)columnNames.elementAt(columnIndex);
          return colName;
         }
   /**
    * retourne le type de contenu des colonnes, ici String pour tous
    * @param columnIndex numéro de la colonne
    * @return type de contenu
    */
   public Class getColumnClass(int columnIndex){
       return String.class;
    }
   /**
    * rend les cellules du tableau non modifiables par défaut, mais on peut changer cette option en remplacant false par true
    * @param rowIndex position de la ligne d'une cellule du tableau
    * @param columnIndex position de la colonne d'une cellule du tableau
    * @return false
    */
   public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
   /**
    * Création de l'objet représentant le contenu d'une cellule du tableau
    * @param rowIndex numéro de la ligne de la cellule
    * @param columnIndex numéro de la colonne de la cellule
    * @return le contenu de la cellule sous forme d'un string
    */
   public Object getValueAt(int rowIndex, int columnIndex) {
        return (String)data.elementAt(
        (rowIndex*getColumnCount())+columnIndex);
    }

   /**
    * méthode de modification de la cellule donnée, dans le cas où "isCellEditable" est mise sur true
    * @param aValue valeur de la cellule
    * @param rowIndex numéro de la ligne
    * @param columnIndex numéro de la colonne
    */
   public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       data.addElement(aValue);
   }
}
