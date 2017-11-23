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
public class TraitementImage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int[][] matImage = LectureImage.lireImage("lena.pgm");
        LectureImage.histogramme("lena.pgm");
    }
    
}
