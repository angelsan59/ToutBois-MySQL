
package Exceptions;

/**
 * Gestion des exceptions dans les fichiers de l'application
 * @author Sandrine Ociepka
 * @author Stephane Coulon
 * @version 1.0
 */
public class GestionException extends Exception {
/**
 * Message d'erreur en cas d'exception
 * @param message texte du message
 */    
public GestionException( String message ) {
    super(message); 
}    
   

}
