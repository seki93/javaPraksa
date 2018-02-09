package zadaci.SekeresStefan;

import java.util.Scanner;

public class Matrica {
	
	private static Scanner sc;


	public static void main(String[] args) {
		
		int n,m;
	    sc = new Scanner(System.in);
		System.out.println("Enter matrix: ");
		System.out.println("n: ");
		n = sc.nextInt();
		System.out.println("m: ");
		m = sc.nextInt();
		int [][]  matrix = new int [n][m];
		
		fillTheMatrix(matrix, n, m);
		printMatrix(matrix, n, m);
	}
	
	public static void fillTheMatrix(int [][] matrix, int n, int m) {
		
		sc = new Scanner(System.in);
		int value;
		for(int i = 0; i < n; i++) {
			for( int j = 0; j < m; j++) {
				System.out.println("Enter element: "+"Position: ["+i+"]["+j+"]");
				value = sc.nextInt();
				matrix[i][j] = value;
				if(value == 1) {
					j = 0;
					while(j < m) {
						matrix[i][j] = value;
						j++;
					}
				}
			}
		}
		
	}
	
	public static void printMatrix(int[][] matrix, int n, int m) {
		for( int i = 0; i < n; i++) {
			for( int j = 0; j < m; j++) {
				System.out.print(" "+matrix[i][j]);
			}
			System.out.println();
		}
	}

}
