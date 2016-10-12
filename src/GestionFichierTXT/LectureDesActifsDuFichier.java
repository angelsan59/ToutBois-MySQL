
package GestionFichierTXT;

import java.io.*;
import java.util.*;


/**
 * Classe dérivée de la classe AbstractTableModel dans la bibliothèque java swing. 
 * Convertit les données contenues dans un fichier txt en vector pour les ranger dans une table affichée sur la fenêtre de gestion
 * des clients, prospects et représentants. Permet également de ressortir le nombre de ligne active dans le fichier.
 * 
 * @author Sandrine Ociepka
 * @author Stephane Coulon
 * @version 1.0
 */

public class LectureDesActifsDuFichier  {
        protected Vector data;            //données
        protected Vector columnNames ;    //noms de colonnes
        protected String datafile;        //nom du fichier de données


   
/**
 * Constructeur qui transfère les données d'un fichier txt dans des vectors
 * @param f données du fichier ouvert
 */
public LectureDesActifsDuFichier(String f) {
          datafile=f;
          initVectors();
}

public void initVectors() {
    String ligne;
    boolean voirtout = false ;
    data =new Vector();
    columnNames=new Vector();
        /*
        * Ouverture du fichier et analyse des données ligne par ligne.
        */
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
   
    // methode d'actualisation des tables non utilisée pour le moment : problème de définition du type de variable de la jTable pour importer son nom et l'utiliser
    // dans la méthode
    // public static void actualiseTable(String fichiernom, javax.swing.JTable nomtable) {
    //   name = new javax.swing.JTable (nomtable);  
    //   String nomFichier1=fichiernom;
    //  DataFileTableModel model1 = new DataFileTableModel(nomFichier1);
    //
    //   model1.fireTableDataChanged();
    //  name.setModel(model1); 
    //}
}