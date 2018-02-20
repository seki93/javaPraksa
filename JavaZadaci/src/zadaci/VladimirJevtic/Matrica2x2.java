package zadaci.VladimirJevtic;


import java.util.*;

import org.apache.log4j.Logger;

public class Matrica2x2 {

	public static void printMatricu(int matrica[][], int red, int kolona) {

		for (int i = 0; i < red; i++) {
            for (int j = 0; j < kolona; j++) {
                System.out.print(matrica[i][j] + " ");
            }
            System.out.println();
		}
		
	}

	
	
	 public static int maxSumaPodmatrice (int matrica[][], int red, int kolona) {
	
		 int maxSum = 0;
		 int sumMat =0;
		 
		 for (int i=0; i < red -1; i++) {
			 for (int j=0; j< kolona -1; j++) {
				 
				 sumMat = sumMat + matrica[i][j];
			
				
				 sumMat = sumMat + matrica[i][j+1];
				
				
				 sumMat = sumMat + matrica[i+1][j];
				
				
				 sumMat = sumMat + matrica[i+1][j+1];
				
				 
				 if (sumMat > maxSum) maxSum = sumMat;
				 
				 sumMat = 0;
				 
			 }
		 }
		 
		return  maxSum;
		 

		 
		 
		 
	 }
	private static final Logger Log = Logger.getLogger(LoggerTest.class);
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print(" Unesite broj redova: ");
		int red = sc.nextInt();
		System.out.print("Unesite broj kolona" );
		int kolona = sc.nextInt();
		int niz[][] = new int[red][kolona];
		
		for (int i=0 ; i < red; i++) {
			for (int j=0; j < kolona; j++) {
				System.out.print("X[" +i+ "," +j +"]"+ "-->");

				niz[i][j] = sc.nextInt();
				
			}
			
		}
		int maxSuma = maxSumaPodmatrice(niz, red, kolona); 
		
		Matrica2x2.printMatricu(niz, red, kolona);
		
		System.out.print(" Max suma 2x2: " + maxSuma );
		
		
	
	

		
	
		
		
		

	}

}
