package zadaci.SekeresStefan;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Matrix2x2 {
	
	
	
	private static Scanner sc;


	public static void main(String[] args) {
		
		
		int n,m;
		sc = new Scanner(System.in);
		
		System.out.println("Enter n: ");
		n = sc.nextInt();
		
		System.out.println("Enter m: ");
		m = sc.nextInt();
		
		int [][] sequence = new int [n][m];
		
		createMatrix(sequence, n, m);
		int maxSum = maxSum(sequence, n, m);
		System.out.println("Max sum je: "+maxSum);
		printMatrix(sequence, n, m);
	}
	
	
	public static void createMatrix(int [][] sequence, int n, int m) {
		
		for( int i = 0; i < n; i++) {
			for( int j = 0; j < m; j++) {
				int value = sc.nextInt();
				sequence[i][j] = value;
			}
		}
	}
	
	public static int maxSum(int [][] sequence, int n, int m) {
		int zbir = 0;
		int max = 0;
		for( int i = 0; i < n-1; i++) {
			for( int j = 0; j < m-1; j++) {
				zbir = zbir + sequence[i][j];
				zbir = zbir + sequence[i][j+1];
				zbir = zbir + sequence[i+1][j];
				zbir = zbir + sequence[i+1][j+1];
				
				if(zbir > max) max = zbir;
				zbir = 0;
			}
		}
		
		return max;
	}
	
	public static void printMatrix(int [][] sequenece, int n, int m) {
		
		for( int i = 0; i < n; i++) {
			for( int j = 0; j < m; j++) {
				System.out.print(" "+sequenece[i][j]);
			}
			System.out.println();
		}
	}

}
