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
    
    public static int[][] lireImage(String nomFichierACharger){
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
    
    public static int maxTab(int[] tab){
        int max = tab [0];
        for (int i=0;i<tab.length;i++){
            if (tab[i]>max){
                max = tab[i];
            } 
        }
        return max;
    }
    
    public static void histogramme(String nomFichier){
        int[][] matriceImage = lireImage(nomFichier);
        int nbLigne = matriceImage.length;
        int nbColonne = matriceImage[0].length;
        int[] histo = new int[256];
        for(int i=0;i<nbLigne;i++){
            for (int j=0;j<nbColonne;j++){
                histo[matriceImage[i][j]]++;
            }
        }
        
        int maxHisto = maxTab(histo);
        int hauteur = maxHisto+2;
        int largeur = 258;
        
        int[][] matriceHisto = new int[hauteur][largeur];
        
        matriceHisto[hauteur-1][0]=0;
        matriceHisto[hauteur-1][largeur-1]=0;
        for(int i =0;i<largeur;i++){
            matriceHisto[0][i]=0;
            if ((i>1) && (i<257)){
                matriceHisto[hauteur-1][i]=i-1;
            }
            
        }
        
        for(int j=1;j<largeur-1;j++){
            for(int i=1;i<hauteur-1;i++){
                if((i>0)&&(i<(maxHisto-histo[j-1]))){
                    matriceHisto[i][j]=0;
                }
                else {
                    matriceHisto[i][j]=255;
                }
            }
        }
        
        ecritureImage(matriceHisto,"histogramme");
        
    }
    
}
