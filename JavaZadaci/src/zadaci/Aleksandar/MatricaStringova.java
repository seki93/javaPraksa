package zadaci.Aleksandar;

import java.util.Scanner;

public class MatricaStringova {

	private static Scanner sc;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		System.out.print("Ubaci broj redova ");
		int m = sc.nextInt();
		System.out.print("Ubaci broj kolona ");
		int n = sc.nextInt();
		String [][]mat = new String[m][n];
		
		popuniMatricu(mat);
		
		for(int i = 0;i < m;i++) {
			for(int j = 0;j < n;j ++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.print("Proveri karakter: ");
		char c = sc.next().charAt(0);
		
		
		int ponavljanja = ponavljanjeKaraktera(mat,c);
		System.out.println("Karakter "+ c + " se pojavljue: " + ponavljanja);

	}
	
    public static void popuniMatricu(String [][]mat) {
		
		for(int i = 0;i < mat.length;i++) {
			for(int j = 0;j < mat[0].length;j ++) {
				System.out.print("Ubaci element: "+"Pozicija: [" + i + "][" + j + "]");
				mat[i][j] = sc.next();
				
			}
			
		}
	}
    
    public static int ponavljanjeKaraktera(String [][]mat, char c) {
    	
    int ponavljanja = 0;
		
		for(int i = 0; i < mat.length; i++) {
			
			for(int j = 0; j < mat[i].length; j++) {
				
			    int karakter = 0;
				
				while(karakter < mat[i][j].length()) {
					
					if(mat[i][j].charAt(karakter) == c) {
						ponavljanja++;
					}
					karakter++;
				}
			}
         }
		return ponavljanja;
     }
}
