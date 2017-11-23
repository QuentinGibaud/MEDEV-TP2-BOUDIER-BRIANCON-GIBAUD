/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitementimage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quentin GIBAUD
 */
public class LectureImage {

    public static void lireImage(String nomFichierACharger) {
        BufferedReader fichier;
        String delimiteurs = " ,.;";
        String width, height;

        try {
            fichier = new BufferedReader(new FileReader(nomFichierACharger));

            String line = fichier.readLine();
            line = fichier.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line, delimiteurs);

            if (tokenizer.hasMoreTokens()) {
                width = tokenizer.nextToken();
                if (tokenizer.hasMoreTokens()) {
                    height = tokenizer.nextToken();
                } else {
                    System.err.println("Not a corrent pgm file");
                }
            } else {
                System.err.println("Not a corrent pgm file");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LectureImage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LectureImage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void ecritureImage(int[][] matImage, String nomImage) throws IOException {
        BufferedWriter bufferedWriter;
        String nomSauvegarde = nomImage + ".pgm";
        
        //Création du BufferedWriter
        bufferedWriter = new BufferedWriter(new FileWriter(nomSauvegarde));
        
        //On entre les informations de base
        bufferedWriter.write("P2");
        bufferedWriter.newLine();
        bufferedWriter.write("#");
        bufferedWriter.newLine();
        int numLigne = matImage.length;
        int numColonne = matImage[0].length;
        bufferedWriter.write(numColonne + " " + numLigne);
        bufferedWriter.newLine();
        bufferedWriter.write(255);
        bufferedWriter.newLine();
        
        //On boucle sur le tableau pour écrire par ligne et par colonne
        for(int i=0;i<numLigne;i++){
            int [] ligneEnCours = matImage[i];
            for(int j=0;j<numColonne;j++){
                bufferedWriter.write(ligneEnCours[j] + " ");
            }
            bufferedWriter.newLine();
        }
        
        // Je force l'écriture dans le fichier
        bufferedWriter.flush();
        // Puis je le ferme
        bufferedWriter.close();
    }

}
