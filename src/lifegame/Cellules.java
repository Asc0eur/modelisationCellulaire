package lifegame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Vincent, Camille, Clément
 * Classe Cellules
 * S'occupe de la gestion du comportement des cellules
 */
public class Cellules {

		//ATTRIBUTS
	
	/**La tableau de couple de 3 cellules*/
    public int t[][][] = new int[2][2][2];
    /**Le tableau de conversion binaire*/
    int tab_binaire[] = new int[8];
    /**Le tableau de cellules*/
    private int cell[];

    	//CONSTRUCTEUR
    
    /**
     * Constructeur a 1 parametre
     * @param cell	le tableau de cellules
     */
    public Cellules(int[] cell) {
        this.cell = cell;
        System.out.println("Numéro de la règle que vous souhaitez utiliser :  ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        /**
         * conversion en binaire 2^0 = 1 2^1 = 2 2^3 = 4 2^4 = 8 2^5= 16 2^6 =
         * 32 2^7 = 64 || Un octet 2^8 = 128 2^9 = 256 2^10 = 512
         */
        String binaire = Integer.toBinaryString(i);
        //System.out.println(binaire);
        for (int j = 0; j < 8; j++) {
            if (j < binaire.length()) {
                if (Character.getNumericValue(binaire.charAt(binaire.length() - (j + 1))) == 1) {
                    tab_binaire[j] = 1;
                } else {
                    tab_binaire[j] = 0;
                }
                
            } else
                tab_binaire[j] = 0;
        }

        System.out.println("Code : " + Arrays.toString(tab_binaire));
        t[0][0][0] = tab_binaire[0];
        t[0][0][1] = tab_binaire[1];
        t[0][1][0] = tab_binaire[2];
        t[0][1][1] = tab_binaire[3];
        t[1][0][0] = tab_binaire[4];
        t[1][0][1] = tab_binaire[5];
        t[1][1][0] = tab_binaire[6];
        t[1][1][1] = tab_binaire[7];
        //afficherT();
    }
    
    	//METHODES
    
    /**
     * Methode newLine
     * Permet d'afficher une nouvelle ligne de cellules
     */
    public void newLine() {
    	//Nombre de cellules par ligne
    	int taille = this.cell.length;
    	
        int cell1[]= new int[taille];
        System.arraycopy(cell, 0, cell1, 0, taille);
        setCell(cell1); //MAJ des cellules dans l'attribut
        for (int i = 0; i < taille; i++) {
            
            if (i == 0) {
                //System.out.print(cell[7]+","+cell[0]+","+cell[1]);
                cell1[i] = t[cell[taille - 1]] [cell[0]] [cell[1]];
                
            } else if (i == (taille - 1)) {
                //System.out.print(cell[i-1]+"|"+cell[7]+"|"+cell[0]);
                cell1[i] = t[cell[i - 1]] [cell[taille - 1]] [cell[0]];
            } else{
                //System.out.print(cell[i-1]+"-"+cell[0]+"-"+cell[i+1]);
                cell1[i] = t[cell[i - 1]] [cell[i]] [cell[i + 1]];
            }
            //System.out.println(" =  "+ cell1[i]);
        }
        System.arraycopy(cell1, 0, cell, 0, taille);
        setCell(cell1);	//MAJ des cellules dans l'attribut
        System.out.println(this);
    }

	@Override
        public String toString() {
        return Arrays.toString(cell);
    }

    /**
     * Methode afficherT
     * Permet d'afficher un tableau de cellules
     */
    public void afficherT() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.println(t[i][j][k]);
                }
            }
        }
    }

	/**
	 * Methode areDead
	 * Permet de voir si les cellules du tableau sont a 0
	 * @return boolean	vrai si toutes les cellules sont mortes
	 */
    public boolean areDead(){
    	boolean rep = false;
    	int cpt = 0;
    	for(int i = 0; i < this.cell.length; i++){
        	if(this.cell[i] == 0)
        		cpt ++;	//on incremente le compteur de chaque cellule a 0
    	}
    	//Si toutes les cellules sont a 0, alors elles sont toutes mortes
    	if(cpt == this.cell.length)
    		rep = true;
    	return rep;
    }
    
    /**
     * Methode mutation
     * Incorpore une mutation sur une des cellules de la ligne, aleatoirement
     * Inverse la valeur de la case aleatoirement choisie
     */
    public void mutation(){
    	int random = (int)(Math.random() * (this.cell.length - 1));
    	if(this.cell[random] == 0){
    		this.cell[random] = 1;
    	} else if(this.cell[random] == 1){
    		this.cell[random] = 0;
    	}
    	random ++; //pour avoir le numero correspondant si on compte a partir de 1 et pas de 0
    	System.out.println("Mutation de la cellule numéro " + random);
    	System.out.println("Etape mutée " + this);
    }
   
    /**
     * Getter de l'attribut cell
     * @return	int[]	le tableau de cellules
     */
    public int[] getCell() {
		return cell;
	}

    /**
     * Setter de l'attribut cell
     * @param cell	le nouveau tableau de cellules
     */
	public void setCell(int[] cell) {
		this.cell = cell;
	}
}
