/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitementimage;

import java.io.IOException;

/**
 *
 * @author Quentin GIBAUD, Yann BRIANCON, Justine BOUDIER
 */
public class Seuillage {

    //Fonction de seuillage : prend une image et un niveau max et renvoie l'image avec les niveaux de gris seuillées
    public static void seuillage(String nomImage, int seuil) throws IOException {
        int[][] matImage = LectureImage.lireImage(nomImage);
        for (int i = 0; i < matImage.length; i++) {
            for (int j = 0; j<matImage[0].length;j++) {
                if (matImage[i][j]>seuil){
                    matImage[i][j] = seuil;
                }
            }
        }
        LectureImage.ecritureImage(matImage, nomImage + "_seuil");
    }
    
    //Fonction d'agrandissement de l'image
    public static void agrandir(String nomImage, int facteurAgrandissant){
        int[][] matImage = LectureImage.lireImage(nomImage);
    }
}
