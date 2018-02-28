package zadaci.SekeresStefan;

import java.util.Scanner;

public class MatrixOfString {
	
	private static Scanner sc;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		System.out.println("Enter n: ");
		int n = sc.nextInt();
		
		System.out.println("Enter m: ");
		int m = sc.nextInt();
		
		System.out.println("Enter character: ");
		String s = sc.next();
		
		Character c = s.charAt(0);
		
		//System.out.println("N "+n+"M "+m+"Charachter: "+c);
		
		System.out.println("Number of character "+c+" in matrix is : "+numberOfCharacter(n, m, c));
		
	}
	
	public static int numberOfCharacter(int n, int m, Character a) {
		String[][] matrix = new String[n][m];
		int number = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.println("Enter string in matrix: ");
				matrix[i][j] = sc.next();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int k = 0;
				while( k < matrix[i][j].length()) {
					if(matrix[i][j].charAt(k) == a) number++;
					k++;
				}
			}
		}
		
		return number;
	}

}
