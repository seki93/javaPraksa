package zadaci.rajkoJegdic;

import java.util.Scanner;

public class TransponovanaMatrica {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Unesite dimenzije matrice");
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] matrica = napravimatricu(n,m);
		
		matrica = obrniMatricu(matrica, n, m);
		
		ispisiMatricu(matrica, m, n);
		
	}

	private static int[][] obrniMatricu(int[][] matrica, int n, int m) {
		
		int pomocnaMatrica[][] = new int[m][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				pomocnaMatrica[j][i] = matrica[i][j];
			}
		}
		
		return pomocnaMatrica;
		
	}

//	radi kada je n x n
//	private static int[][] obrniMatricu(int[][] matrica, int n, int m) {
//		
//		for(int i = 0; i < n; i++) {
//			for(int j = i; j < m; j++) {
//				if(j > i) {
//					int tmp = matrica[i][j];
//				matrica[i][j] = matrica[j][i];
//				matrica[j][i] = tmp;
//				}
//			}
//		}
//		
//		return matrica;
//	}

	private static void ispisiMatricu(int[][] matrica, int n, int m) {
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(matrica[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static int[][] napravimatricu(int n, int m) {
		
		int[][] matrica = new int[n][m];
		System.out.println("Unesite elemente matrice!");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				matrica[i][j] = sc.nextInt();
			}
		}
		
		return matrica;
		
	}

}
