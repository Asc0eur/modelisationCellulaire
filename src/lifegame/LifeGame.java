package lifegame;

import java.util.Scanner;

/**
 * @author Vincent, Camille, Clément
 * Classe LifeGame
 * Classe Principale du projet, simulant le jeu
 */
public class LifeGame {

    public static void main(String[] args) {
    	
    	//Taille de l'echantillon de cellules
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre de cellules de l'echantillon : ");
        int nbCell = sc.nextInt();
        while(nbCell < 4){
        	System.out.println("Votre echantillon est trop petit, saissisez une valeur supérieur à 3.");
        	nbCell = sc.nextInt();
        }
    	
    	//Creation du tableau contenant une ligne de cellules, vide
        int cellu[] = new int[nbCell];

        //On genere aleatoirement la premiere ligne
        for (int i = 0; i < nbCell; i++) {
            cellu[i] = (int)(Math.random() + 0.5);
        }

        //Creation de l'ensemble de cellules
        Cellules c = new Cellules(cellu);
        
        //Pour commencer a l'etape 1
        int i = 1;
        
        //Pour générer la mutation lors d'une etape aleatoire
        int mutat = (int)(Math.random() * (101));
        
        System.out.println("Configuration Initiale : \n" + c);
        System.out.println("Modelisation pour 100 itérations :");
        while(i < 101){
        	if(i == mutat){
        		c.mutation();
        		i++;
        	} else{
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

}
