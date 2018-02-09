package zadaci.rajkoJegdic;

import java.util.Scanner;

public class MatircaPetak1 {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		System.out.println("unesite dimenzije matrice");
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] matrica = napraviMatricu(n, m);
		
		matrica = jeJedinica(matrica, n, m);
		
		ispisiMatricu(matrica, n, m);

	}

	private static int[][] jeJedinica(int[][] matrica, int n, int m) {
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(matrica[i][j] == 1) {
					matrica = postaviJedinice(matrica, n, m, i);
					break;
				}
			}
		}
		
		return matrica;
	}

	private static int[][] postaviJedinice(int[][] matrica, int n, int m, int k) {
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if( i == k) {
					matrica[i][j] = 1;
				}
			}
		}
		
		return matrica;
		
	}

	private static void ispisiMatricu(int[][] mat, int n, int m) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}		
	}

	private static int[][] napraviMatricu(int n, int m) {
		
		int[][]mat = new int[n][m];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		return mat;
	}

}
