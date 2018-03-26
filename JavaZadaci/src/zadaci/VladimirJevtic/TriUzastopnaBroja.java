package zadaci.VladimirJevtic;

import java.util.Scanner;

public class TriUzastopnaBroja {
	
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	Integer niz[] = {3, 7, 9 , 2, 11};
	
	System.out.println("Unesite sumu : " );
	
	int broj = sc.nextInt();
	
	for (int i = 0; i < niz.length-2; i++) {
		
		if ((niz[i]+ niz[i+1] + niz[i+2]) > broj){
			
			System.out.println("Tri uzastopna broja veca od " + broj + " su :");
			System.out.println(niz[i]);
			System.out.println(niz[i+1]);
			System.out.println(niz[i+2]);
			
			
			}
		
		}
	}
}
