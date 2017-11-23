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

    /**
     * Function to read a file pgm.
     * @param nomFichierACharger PGM file
     * @return A 2D matrix representing the image(height, width)
     */
    public static int[][] lireImage(String nomFichierACharger){
        BufferedReader fichier;
        String delimiteurs = " ,.;";
        int width, height;
        int[][] image = null;

        try {
            fichier = new BufferedReader(new FileReader(nomFichierACharger));

            String line = fichier.readLine();
            line = fichier.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line, delimiteurs);

            if(tokenizer.hasMoreTokens()){
                width = Integer.parseInt(tokenizer.nextToken());
                if(tokenizer.hasMoreTokens()){
                    height = Integer.parseInt(tokenizer.nextToken());

                    image = new int[height][width];
                    
                    int nbPixelLu = 0;
                    int nbLigneLue = 0;
                    line = fichier.readLine();                            
                    while(nbLigneLue != height){
                        if(nbPixelLu == width){
                            nbPixelLu = 0;
                            nbLigneLue++;
                        }
                        tokenizer = new StringTokenizer(line, delimiteurs);
                        
                        while(tokenizer.hasMoreTokens()){
                            if(nbPixelLu < width){
                                image[nbLigneLue][nbPixelLu] = Integer.parseInt(tokenizer.nextToken());
                                nbPixelLu++;
                            }
                            else{
                                System.err.println("Not a correct pgm file : Width and file not matching");
                            }
                        }
                        
                    }
                }
                else{
                    System.err.println("No width indicator in the pgm file");
                }
            }
            else{
                System.err.println("No length indicator in the pgm file");
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LectureImage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LectureImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return image;
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
