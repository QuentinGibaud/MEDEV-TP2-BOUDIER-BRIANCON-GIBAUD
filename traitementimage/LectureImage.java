/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitementimage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quentin GIBAUD
 */
public class LectureImage {
    
    public static void lireImage(String nomFichierACharger){
        BufferedReader fichier;
        String delimiteurs = " ,.;";
        String width, height;
        
        try {
            fichier = new BufferedReader(new FileReader(nomFichierACharger));
            
            String line = fichier.readLine();
            line = fichier.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line, delimiteurs);
            
            if(tokenizer.hasMoreTokens()){
                width = tokenizer.nextToken();
                if(tokenizer.hasMoreTokens()){
                    height = tokenizer.nextToken();
                }
                else{
                    System.err.println("Not a corrent pgm file");
                }
            }
            else{
                System.err.println("Not a corrent pgm file");
            }            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LectureImage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LectureImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
