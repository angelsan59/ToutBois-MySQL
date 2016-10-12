package GestionFichierTXT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Classe gérant l'écriture des données clients, représentants et prospects dans des fichiers txt à partir des données collectées dans les formulaires de l'application
 * @author Sandrine Ociepka
 * @author Stephane Coulon
 * @version 1.0
 */
public class EcritureDansFichier {
   
    /**
    * méthode d'écriture dans les fichiers txt après collection des données dans les formulaires de l'application
    * @param nomfichier récupération du chemin et nom du fichier
    * @param chaine données formatées (séparées par ;) pour former la ligne de texte à ajouter
    * @throws IOException message d'erreur si le programme ne trouve pas le fichier txt
    */
    public static void EcritureFichier (String nomfichier, String chaine) throws IOException {
        // Création du fichier texte pour le programme
	//String nomfichier = "Data/Representants.txt" ;	
        File fichierTexte = new File (nomfichier);
	// Création de "l'écrivain"
	FileWriter ecrireFichier;
	try {
            // Instanciation de l'objet ecrireFichier qui va écrire dans fichierTexte.txt
            //true c'est elle qui permet d'écrire à la suite des donnée enregistrer et non de les remplacé
            ecrireFichier = new FileWriter(fichierTexte, true);
            // Écriture d'une chaîne de caractères dans le fichier texte
            ecrireFichier.write(chaine);
            // "Fermeture" du FileWriter
            ecrireFichier.close();
	}
        catch (FileNotFoundException e) 
        {
        e.printStackTrace();
        } 
        catch (IOException e) 
        {
	e.printStackTrace();
        }
    }
    
    /**
     * méthode de modification de fichier txt à partir de données récoltées dans les formulaires de l'application
     * @param nomfichier chemin et nom du fichier à modifier
     * @param chaine ligne de texte formatée avec les ; qui remplacera lees données à modifier
     * @param ligneachanger les données à modifier qui seront remplacées par "chaine"
     * @throws IOException message d'erreur si le programme ne trouve pas le fichier txt
     */
    public static void ModificationLigne (String nomfichier, String chaine, int ligneachanger) throws IOException {
        int ligneactive = 0 ;
        String lignearecopier ="" ;
        File entree = new File(nomfichier);
        File sortie = new File("Data\\temp.txt");
        BufferedReader br = new BufferedReader(new FileReader(entree));
        BufferedWriter bw = new BufferedWriter(new FileWriter(sortie));
        try {
            while ((lignearecopier = br.readLine()) != null) {
                if (ligneactive != ligneachanger) {
                    bw.write (lignearecopier + "\n") ;
                    ligneactive = ligneactive + 1 ;
                    }
                else
                {                
                bw.write (chaine) ;
                ligneactive = ligneactive + 1 ; 
                }            }
            bw.close () ;
            br.close () ;
            entree.delete();
            sortie.renameTo(new File(nomfichier));
            }
        catch (FileNotFoundException e) 
            {
            e.printStackTrace();
            } 
        catch (IOException e) 
            {
            e.printStackTrace();
            }
    }
}
    
        
        
        
        
        
        


