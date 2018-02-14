package zadaci.Aleksandar;

import java.util.Scanner;

public class PodMatrica {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		System.out.print("Ubaci broj redova ");
		int m = sc.nextInt();
		System.out.print("Ubaci broj kolona ");
		int n = sc.nextInt();
		int [][]mat = new int[m][n];
		
		popuniMatricu(mat);
		
		int maxSumaPodmatrica = maxSumaPodmatrica(mat, m, n);
		System.out.println("Maksimalna suma podmatrica je:" + maxSumaPodmatrica);
		
		
		for(int i = 0;i < m;i++) {
			for(int j = 0;j < n;j ++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	public static void popuniMatricu(int [][]mat) {
		
		for(int i = 0;i < mat.length;i++) {
			for(int j = 0;j < mat[0].length;j ++) {
				System.out.print("Ubaci element: "+"Pozicija: [" + i + "][" + j + "]");
				mat[i][j] = sc.nextInt();
				
			}
			
		}
	}
	
	public static int maxSumaPodmatrica(int [][]mat, int m, int n) {
		
		int suma= 0;
		int maximum = 0;
		
		for(int i = 0;i < m-1;i++) {
			for(int j = 0;j < n-1;j ++) {
				
				suma = suma + mat[i][j];
				suma = suma + mat[i][j + 1];
				suma = suma + mat[i + 1][j];
				suma = suma + mat[i + 1][j + 1];
				
				if(suma > maximum) {
					
					maximum = suma;
				}
				suma = 0;
		
			}
			
		}
		return maximum;
	}

}
