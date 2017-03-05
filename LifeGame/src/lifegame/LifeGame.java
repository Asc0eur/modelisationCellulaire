package lifegame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Vincent, Camille, Clément
 * Classe LifeGame
 * Classe Principale du projet, simulant le jeu
 */
public class LifeGame {

    public static void main(String[] args) {

    	//Creation d'un tableau de 8 entiers, vide
        int cellu[] = new int[8];

        //On genere aleatoirement la premiere ligne
        for (int i = 0; i < 8; i++) {
            cellu[i] = (int)(Math.random() + 0.5);
        }

        //Creation de l'ensemble de cellules
        Cellules c = new Cellules(cellu);
        
        //Liste de toutes les etapes de l'avancement du tableau de cellules
        ArrayList<int[]> life = new ArrayList<int[]>();
        life.add(c.getCell());
        
        //Pour commencer a l'etape 1
        int i = 1;
        
        System.out.println("Configuration Initiale : \n" + c);   
        
        System.out.println("Modelisation pour 100 itérations :");
        while(i < 101){
        	if(c.areDead()){
        		System.out.println("On arrête, toutes les cellules sont mortes!");
        		break;
        	}
        	System.out.print("Etape " + i + " : ");
        	c.newLine();
        	life.add(c.getCell());
        	i++;
        }
        
        for (int[] number : life) {
        	   System.out.println(number[0] + "," + number[1] + "," + number[2] + "," + number[3]
        			   		+ "," + number[4] + "," + number[5] + "," + number[6] + "," + number[7]);
        }
    }

}
