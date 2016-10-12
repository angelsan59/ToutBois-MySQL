/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
* Classe pour ouvrir la javadoc dans le navigateur par défaut
 * @author Sandrine Ociepka
 * @author Stephane Coulon
 * @version 1.0
 */
public class AppelJavadoc {
    /**
   * @throws URISyntaxException erreur si le navigateur ne s'ouvre pas
     */
    //public static void main(String[] args) throws URISyntaxException {
   public static void lancerjavadoc () throws URISyntaxException {
    if(Desktop.isDesktopSupported()) {
		Desktop desktop = Desktop.getDesktop();
		if ( desktop.isSupported(Desktop.Action.BROWSE) ) {
			try {
				desktop.browse(new URI(new File("dist/javadoc/index.html").getAbsolutePath().replaceAll("\\\\", "/")));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Problème avec votre navigateur : il n'est probablement pas bien configuré...");
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Aucun navigateur par défaut : veuillez configurer...blah blah...");
		}
	}
	else {
		JOptionPane.showMessageDialog(null, "Désolé, cette fonctionalité n'est pas disponible");
	}
}    
}
