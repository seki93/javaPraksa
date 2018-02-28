package zadaci.VladimirJevtic;

import java.util.Scanner;

public class MatricaStringova {

    	public static int proveraCharaUMatrici (String matrica[][], int chr) {
   
    		int ponavljanje = 0;
    		
    		for (int i=0 ; i < matrica.length; i++) {
    			for (int j=0; j < matrica[i].length; j++) {
    				 int poz = 0;
    				 while (poz < matrica[i][j].length()) {
    					 if(matrica[i][j].charAt(poz) == chr ) {
    						 ponavljanje= ponavljanje + 1;
    					 }
    					 poz = poz + 1;
    				 }
    			
    			}
    		}
    		return ponavljanje;
    	}
    
	
	
	
	
	public static void main(String[] args) {
	
		Scanner mat = new Scanner(System.in);
		
		System.out.println("Unesite broj redova : ");
		int red = mat.nextInt();
		
		System.out.println("Unesite broj kolona : ");
		int kolona = mat.nextInt();
		
        String matrica[][] = new String[red][kolona];
        
        System.out.println(" Unesite stringove matrice : ");
 
        for (int i=0 ; i < red; i++) {
			for (int j=0; j < kolona; j++) {
				matrica[i][j] = mat.next();
				}
			}
        
        System.out.println(" Unesite karakter koji proveravate : ");
        char chr = mat.next().charAt(0);
        
       System.out.println(MatricaStringova.proveraCharaUMatrici(matrica, chr));
        
 	}

}
