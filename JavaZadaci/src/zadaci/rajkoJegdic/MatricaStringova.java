package zadaci.rajkoJegdic;

import java.util.Scanner;

public class MatricaStringova {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Unesite dimenzije matrice");
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[][] matrica = napraviMatricu(n,m);
		
		System.out.println("unesite karakter za koji zelite da proverite da li se pojavljuje");
		char c = sc.next().charAt(0);
		
		int ponavljanja = nadjiPonavljanjaCuMatrici(matrica, c);
		System.out.println(c + " se pojavljue: ");
		System.out.println(ponavljanja);
		
	}

	private static int nadjiPonavljanjaCuMatrici(String[][] matrica, char c) {
		
		int ponavljanja = 0;
		
		for(int i = 0; i < matrica.length; i++) {
			for(int j = 0; j < matrica[i].length; j++) {
				int k = 0;
				while(k < matrica[i][j].length()) {
					if(matrica[i][j].charAt(k) == c) {
						ponavljanja++;
					}
					k++;
				}
			}
		}
		
		return ponavljanja;
	}

	private static String[][] napraviMatricu(int n, int m) {
		System.out.println("Uneiste elemente matrice");
		String[][] matrica = new String[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				matrica[i][j] = sc.next();
			}
		}
		return matrica;
	}

}
