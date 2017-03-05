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
        
        String recap = "Les étapes qui se répétent sont : ";
        
        System.out.println("Configuration Initiale : \n" + c);
        System.out.println("Modelisation pour 100 itérations :");
        while(i < 101){
        	if(c.areDead()){
        		System.out.println("On arrête, toutes les cellules sont mortes!");
        		break;
        	}
        	System.out.print("Etape " + i + " : ");
        	c.newLine();
        	
        	for(int j = 0; j < life.size(); j++){
        		if((c.getCell()[0] == life.get(j)[0]) && (c.getCell()[1] == life.get(j)[1]) && (c.getCell()[2] == life.get(j)[2])
        				&& (c.getCell()[3] == life.get(j)[3]) && (c.getCell()[4] == life.get(j)[4]) && (c.getCell()[5] == life.get(j)[5])
        				&& (c.getCell()[6] == life.get(j)[6]) && (c.getCell()[7] == life.get(j)[7])){
        			recap += "E" + i + " & E" + j + "\n";
        		}
        	}
        	
        	life.add(c.getCell());
        	i++;
        }
        System.out.println(recap);
        //Contenu de la liste
       /** for (int[] number : life) {
        	   System.out.println(number[0] + "," + number[1] + "," + number[2] + "," + number[3]
        			   		+ "," + number[4] + "," + number[5] + "," + number[6] + "," + number[7]);
        }
        */
    }

}
