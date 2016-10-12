/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleDeChamps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author scoulon
 */
public class ChampsDates  {
    
    public boolean sidatebonne(String dateaverifier) throws ParseException {
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        String date1 = dateaverifier;
        try {
            date = simpleDateFormat.parse(date1);
            System.out.println(date);
            //date = simpleDateFormat.parse(date2);
            //System.out.println(date);
            } 
        catch (ParseException e) 
            {
            System.out.println("La date est fausse : "+ date);    
            return false ;
            }
    return true ;
    // Fermeture de la fonction sidatebonne
    }    

// Fermeture de la classe ChampsDates
}  