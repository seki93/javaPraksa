package zadaci.Aleksandar;

import java.util.Scanner;

public class SumaTriBroja {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int [] niz = {1,9,3,4,5,2,7,8,6};
		
		System.out.print("Unesi broj: ");
		
		int k = sc.nextInt();
		
		for(int i = 0;i < niz.length-2;i++) {
			
			if(niz[i] + niz[i+1] + niz[i+2] > k) {
				
				System.out.println("Niz tri uzastopna broja ciji je zbir veci od broja " + k + " su "
				                     + niz[i] + ", " + niz[i + 1] + ", " + niz[i + 2]);
				
			} 
		}

	}

}
