package zadaci.VladimirJevtic;

import java.util.Scanner;

public class NizPomeramoNulu {
	
	public static void stampajNiz(int[] niz) {

		for (int i = 0; i< niz.length; i++) {
			System.out.println(niz[i] + " ");
		}
		System.out.println();
	}

	public static int[] pomerajNulu(int[] niz) {     
		
		int[] pomocni = new int[5];

		pomocni[0] = niz[5-1];
		
		for(int i = 1; i < 5 ; i++) {
			pomocni[i] = niz[i - 1];
		}
		return pomocni;
	}
	
	public static void napraviNiz(int[] niz) {
	
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < niz.length; i++) {
			System.out.println(" Unesite " + (i+1) + " clan niza: ");
			niz[i] = input.nextInt();
			if (niz[i] == 0) nula = true;
			 }
	}
	
	private static boolean nula;
	

	public static void main(String[] args) {
	
	int[] niz = new int[5];
	

	napraviNiz(niz);

	System.out.println(" Pocetni niz je : ");
	stampajNiz(niz);
	
	if(nula) {
		while(niz[0] != 0) {
			niz = pomerajNulu(niz);
		}
	}
	System.out.println(" Izvrseni niz je : " );
	stampajNiz(niz);
	
	
	}
}