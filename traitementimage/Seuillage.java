/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitementimage;

/**
 *
 * @author Quentin GIBAUD, Yann BRIANCON, Justine BOUDIER
 */
public class Seuillage {

    //Fonction de seuillage : prend une image et un niveau max et renvoie l'image avec les niveaux de gris seuillées
    public static void seuillage(String nomImage, int seuil) {
        int[][] matImage = LectureImage.lireImage(nomImage);
        for (i = 0; i < matImage.length; i++) {
            for (j = 0; j<matImage[0].length;j++) {
                if (matImage[i][j]>seuil){
                    matImage[i][j] = seuil;
                }
            }
        }
        LectureImage.ecritureImage(matImage, nomImage + "_seuil");
    }
}
