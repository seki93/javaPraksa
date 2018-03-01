package zadaci.SekeresStefan;

import java.util.Scanner;

public class MatrixTransport {
	
	private static Scanner sc;
	
	public static void main(String[] args) {
		
		
		sc = new Scanner(System.in);
		
		
		System.out.println("Enter n: ");
		int n = sc.nextInt();
		
		System.out.println("Enter m: ");
		int m = sc.nextInt();
		
		int[][] matrix = new int[n][m];
		
		fillTheMatrix(n, m, matrix);
		System.out.println("Original matrix:");
		printMatrix(matrix, n, m);
		transpose(matrix, n, m);
		System.out.println("After transpose matrix: ");
		
		
	}
	
	public static void fillTheMatrix(int n, int m, int[][]matrix) {
		
		for(int i = 0; i < n; i++) {
			for( int j = 0; j < m; j++) {
				System.out.println("Enter value: ["+i+"]["+j+"]");
				matrix[i][j] = sc.nextInt();
			}
		}
		
	}
	
	public static void transpose(int [][] matrix, int n, int m) {
		for(int i = 0; i < m; i++) {
			for(int j = 0 ; j < n; j++) {
				int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
			}
		}
	}
	
	
	public static void printMatrix(int [][] matrix, int n, int m) {
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(" "+matrix[i][j]);
			}
			System.out.println();
		}
	}

}
