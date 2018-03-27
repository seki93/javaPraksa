package zadaci.rajkoJegdic;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class MatricaPod {

	static Scanner sc = new Scanner(System.in);
	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] matrica = napraviMatricu(n, m);
		
		int[][] podMatrica = new int[2][2];
		
		if(n <2 || m <2) {
			logger.debug("Matrica mora da ima bar dva reda i dve kolone!");
		}
		podMatrica = maksPodMatrica(matrica, n, m);
		
		ispisiMatricu(podMatrica, 2, 2);
				
	}
	
	private static int[][] maksPodMatrica(int[][] matrica, int n, int m) {
		
		int[][] tmp = new int[2][2];
		int s = 0, sPom = 0;
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++) {
				sPom = matrica[i-1][j-1] + matrica[i-1][j] + matrica[i][j-1] + matrica[i][j]; 
				if(sPom > s) {
					s = sPom;
					tmp[0][0] = matrica[i-1][j-1];
					tmp[0][1] = matrica[i-1][j];
					tmp[1][0] = matrica[i][j-1];
					tmp[1][1] = matrica[i][j];
				}
			}			
		}
		
		return tmp;
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
	
	private static void ispisiMatricu(int[][] mat, int n, int m) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				logger.debug(mat[i][j] + " ");
			}
		}		
	}

}
