package GestionFichierTXT;

import java.io.* ;
import java.util.Vector ;


/**
 * Classe gérant l'ouverture et la lecture des fichiers txt
 * @author Sandrine Ociepka
 * @author Stephane Coulon
 * @version 1.0
 */
public class LectureDuFichierComplet {
    private int nbdelignes ; // nombres de lignes dans le fichier CSV car évolutif.
    private int nbdecolonnes ; // nombres de colonnes dans le fichier CSV car évolutif.
    private Vector contenudufichier ; // Vector est le resultat de la lecture du fichier.
    private String unedonnee ;
    private final static char separateurdecolonnes = ';' ; // Séparateur par défaut ";".
    
/**
 * retourne le nombre de lignes du fichier
 * @return nombre de lignes du fichier
 */
    public int getNbdelignes() {
        return nbdelignes;
    }
/**
 * méthode pour implémenter le nombre de lignes
 * @param nbdelignes nombre de lignes
 */
    public void setNbdelignes(int nbdelignes) {
        this.nbdelignes = nbdelignes ;
        majdelatailleduvector() ;
    }
/**
 * retourne le nombre de colonnes du tableau de données
 * @return nombre de colonnes
 */
    public int getNbdecolonnes() {
        return nbdecolonnes;
    }
/**
 * méthode pour récupérer une donnée d'après sa position dans le tableau généré par Vector à partir du fichier txt
 * @param ligne numéro de la ligne où se trouve la donnée à récupérer
 * @param colonne numéro de la colonne où se trouve la donnée à récupérer
 * @return retourne la donnée demandée
 */
    public String getUnedonnee(int ligne,int colonne) {
        if (ligne<0 || colonne<0 || ligne>(getNbdelignes() - 1) || colonne>(getNbdecolonnes() - 1)) {
            return null ;
        }
        Vector laligne = (Vector)contenudufichier.get(ligne);
        String resultat = (String)laligne.get(colonne) ;
        return resultat ; 
        }
/**
 * méthode pour donner une valeur à la donnée
 * @param unedonnee donnée
 */
    public void setUnedonnee(String unedonnee) {
        this.unedonnee = unedonnee;
    }
/**
 * méthode pour modifier le nombre de colonnes et donc mettre à jour la taille du vector
 * @param nbdecolonnes nombre de colonnes
 */
    public void setNbdecolonnes(int nbdecolonnes) {
        this.nbdecolonnes = nbdecolonnes ;
        majdelatailleduvector() ;
    }
/**
 * méthode pour récupérer le contenu du fichier et le mettre dans un vector
 * @return le contenu du fichier
 */
    public Vector getContenudufichier() {
        return contenudufichier;
    }
/**
 * méthode donnant la valeur contenudufichier au vector contenudufichier à partir du fichier txt
 * @param contenudufichier données venant du fichier txt
 */
    public void setContenudufichier(Vector contenudufichier) {
        this.contenudufichier = contenudufichier;
    }
    
/**
 * Constructeur pour transférer les données d'un fichier txt dans un vector pour remplir le jTable dans les fenêtres de gestion des clients, représentants et prospects
 * @param chemincomplet chemin et nom du fichier à lire
 * @throws FileNotFoundException message d'erreur quand le fichier txt n'est pas trouvé
 */
    public LectureDuFichierComplet (String chemincomplet) throws FileNotFoundException {
        // Création d'un nouveau contenu de fichier CSV (Vector).
        contenudufichier = new Vector () ;
        // Charge le contenu dans fichierlu.
        FileReader fichierlu = new FileReader(chemincomplet) ;
        // Lance la fonction de lecture du contenu du fichier.
        LectureDuContenu (fichierlu) ;
    }

    /**
     * Fonction privée de lecture du contenu du fichier (reader = fichierlu)
     * Attend le contenu du fichier "reader" en entrée.
     * Pas de retour.
     * @param reader chemin et nom du fichier lu
     */
    private void LectureDuContenu(Reader reader) {
        BufferedReader buffReader = new BufferedReader(reader);
        // si le fichier n'est pas vide faire...
        if (buffReader != null) {
            // Risque ==> donc exception.
            try {
                // Lecture de la ligne et l'ajoute à la mémoire tampon (buffReader)
                String lignelu;
                lignelu = buffReader.readLine();
            // Tant ce que la ligne n'est pas vide.
            while (lignelu != null) {
               LectureDuContenuDeLaLigne (lignelu) ;
               lignelu = buffReader.readLine();
            }
        // Gestion des exceptions impossible de lire le fichier.    
         } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier CSV : " + e.toString());
        } 
        finally {
            // et pour finir vider le tampon.
            try {
               buffReader.close();
            // Gestion des exceptions impossible de fermer le fichier.   
            } catch (IOException e) {
               System.err.println("Erreur de fermeture du fichier CSV :" + e.toString());
            }
         }
      }
    // Fermeture de la fonction privée de lecture du contenu du fichier (reader = fichierlu)
    }

    /**
     * Fonction privée de lecture du contenu d'une ligne.
     * Attends le contenu du fichier "reader" en entrée.
     * Pas de retour.
     * @param lignelu contenu d'une ligne
     */
    private void LectureDuContenuDeLaLigne (String lignelu) {
        // Si la ligne lue est vide, fermeture de la fonction.
        if (lignelu == null) {
            return;
        }
        // Création d'un nouveau contenu de fichier CSV (Vector).
        Vector ligneentraintement = new Vector();
        // Ajout de la ligne au contenu complet (contenudufichier).
        contenudufichier.add(ligneentraintement);
        // nbdelignes + 1
        nbdelignes++;
        // Si la ligne lue est pleinne que d'espace, fermeture de la fonction.
        if (lignelu.trim().length() == 0) {
            return;
        }
        int nbdecolonnes = 0;
        int debutducurseur = 0;
        // Renvoi dans findelaligne la premiere séparation CSV si inexistante alors renvoi "-1".
        int findelaligne = lignelu.indexOf(separateurdecolonnes);
        // Faire tant qu'un séparateur précedent existe (on a mis la donnée à "0")
        while (debutducurseur > -1) {
            // Si fin de ligne, extrait la dernière colonne et passe "debutducurseur" a -1 pour arrèter la boucle
            if (findelaligne == -1) {
                ligneentraintement.add(lignelu.substring(debutducurseur));
                debutducurseur = findelaligne;
            } 
            // Sinon, extrait la colonne et passe à la séparation suivante.
            else 
            {
            ligneentraintement.add(lignelu.substring(debutducurseur, findelaligne));
            debutducurseur = findelaligne + 1;
            }
            findelaligne = lignelu.indexOf(separateurdecolonnes, debutducurseur);
            // nbdecolonnes + 1
            nbdecolonnes++;
        // Fin du faire tant qu'un séparateur précedent existe (on a mis la donnée à "0")
        }
        // Change le nombre de colonne défini au départ par le nouveau nombre si supérieur.
        // Ne pas oublier qu'il s'agit d'une données variable.
        if (nbdecolonnes > getNbdecolonnes()) {
            setNbdecolonnes(Math.max(getNbdecolonnes(), nbdecolonnes));
        }
   }
    
    /**
     * Fonction privée de redimensionnement du Vector.
     * Pas d'entrées. Pas de retour.
     */
    private void majdelatailleduvector() {
      contenudufichier.setSize(getNbdelignes());
      int nbdelignes = getNbdelignes();
      int nbdecolonnes = getNbdecolonnes();
      for (int i = 0; i < nbdelignes; i++) {
         Vector aRow = (Vector)contenudufichier.get(i);
         if (aRow == null) {
            contenudufichier.set(i, new Vector());
            aRow = (Vector)contenudufichier.get(i);
         }
         aRow.setSize(nbdecolonnes);
      }
   }
}
