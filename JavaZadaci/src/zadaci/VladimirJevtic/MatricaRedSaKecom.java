package zadaci.VladimirJevtic; 
import java.util.*;


public class MatricaRedSaKecom {
	
	public static void main(String[] args) {
		
		Scanner matrica = new Scanner(System.in);
		System.out.println(" Unesite broj redova: ");
		int red = matrica.nextInt();
		System.out.println(" Unesite broj kolona: ");
		int kolona = matrica.nextInt();
		int niz[][] = new int[red][kolona];
		int value;

		
		for (int i=0 ; i < red; i++) {
			for (int j=0; j < kolona; j++) {
				System.out.print("X[" +i+ "," +j +"]"+ "-->");

				niz[i][j] = matrica.nextInt();

				value = niz[i][j];
				    
					if (value == 1) {
						j=0; 
						while(j < kolona) {
							niz[i][j] = value;
							j++;
						                  }
				                    }
		                                    }
	
		
		}

			
		
		for (int i = 0; i < red; i++) {
            for (int j = 0; j < kolona; j++) {
                System.out.print(niz[i][j] + " ");
            }
            System.out.println();
		
				
		
		
	  
	}
	}}	
	
