package lifegame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Vincent, Camille
 * Classe LifeGame
 * Classe Principale du projet, simulant le jeu
 */
public class LifeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    	//Tableau de 8 cellules
        int cell[] = new int[8];
        
        
        /**
        Scanner sc = new Scanner(System.in);
        for (int k = 0; k < 8; k++) {
            System.out.println("Veuillez entrer un 1 ou un 0 et appuyez sur Entrée");
            cell[k]= sc.nextInt();
        }
        * */
        
        //On genere aleatoirement la premiere ligne
        for (int i = 0; i < 8; i++) {
            cell[i] = (int) (Math.random() + 0.5);
        }
        
        /**
         * cell[0] = 1 ; 
        cell[1] = 1 ; 
        cell[2] = 1 ; 
        cell[3] = 0 ; 
        cell[4] = 1 ; 
        cell[5] = 1 ; 
        cell[6] = 0 ; 
        cell[7] = 0 ; 
        * */
        // Ligne de cellules : 1 1 1 0 1 1 0 0 
        Cellules c = new Cellules(cell);
        System.out.println("Configuration Initiale : \n" + c);
        System.out.println("Modelisation pour 100 itérations :");
        int i = 1; //Pour commencer a l'etape 1
        while(i < 101){
        	if(c.areDead()){
        		System.out.println("On arrête, toutes les cellules sont mortes!");
        		break;
        	}
        	System.out.print("Etape " + i + " : ");
        	c.newLine();
        	i++;
        }
        
    }

}
