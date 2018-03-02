package zadaci.VladimirJevtic;

import java.util.Scanner;

public class TransponovanaMatrica {
	
	
	public static Integer[][] transponujMatricu(Integer matrica[][], int red, int kolona){
	
		Integer pomocna[][] = new Integer[kolona][red];

		for(int i = 0; i < red; i++) {
			for(int j = 0; j < kolona; j++) {
				pomocna[j][i] = matrica[i][j];
			}
		}
		
		return pomocna;
	}
	
	public static void ispisiMatricu(Integer matrica[][], int red, int kolona){
		for(int i = 0; i < red; i++) {
			for(int j = 0; j < kolona; j++) {
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	

	public static void main(String[] args) {
		
		Scanner mat = new Scanner(System.in);
		
		System.out.println("Unesite broj redova : ");
		int red = mat.nextInt();
		
		System.out.println("Unesite broj kolona : ");
		int kolona = mat.nextInt();
		
        Integer matrica[][] = new Integer[red][kolona];
        
        System.out.println(" Unesite stringove matrice : ");
 
        for (int i=0 ; i < red; i++) {
			for (int j=0; j < kolona; j++) {
				matrica[i][j] = mat.nextInt();
				}
			}

    matrica = TransponovanaMatrica.transponujMatricu(matrica, red, kolona);
    
    TransponovanaMatrica.ispisiMatricu(matrica, kolona, red);
    
    
 
	}
	
	
}
