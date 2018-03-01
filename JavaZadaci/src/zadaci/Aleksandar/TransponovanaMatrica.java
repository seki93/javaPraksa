package zadaci.Aleksandar;

import java.util.Scanner;

public class TransponovanaMatrica {
	
	private static Scanner sc = new Scanner(System.in);;
	
	public static void main(String[] args) {
		
		System.out.print("Ubaci broj redova ");
		int m = sc.nextInt();
		System.out.print("Ubaci broj kolona ");
		int n = sc.nextInt();
		int [][]mat = new int[m][n];
		
		popuniMatricu(mat, m, n);
		
		transponujMatricu(mat, m, n);
		
		for(int i = 0;i < m;i++) {
			for(int j = 0;j < n;j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
    public static void popuniMatricu(int [][]mat, int m, int n) {
		
		for(int i = 0;i < m;i++) {
			for(int j = 0;j < n;j ++) {
				System.out.print("Ubaci element: "+"Pozicija: [" + i + "][" + j + "]");
				mat[i][j] = sc.nextInt();
			}
			
		}
	}
    
    public static int [][] transponujMatricu(int [][]mat, int m, int n) {
    	
    	int pom[][] = new int[n][m];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				pom[j][i] = mat[i][j];
			}
		}
		
		return pom;
    	
    }

}
