package zadaci.rajkoJegdic;

import java.util.Scanner;

public class SiftovanjeNiza {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Unesite broj elementata niza!");
		int n = scanner.nextInt();
		
		int[] niz = ucitajNiz(n);
		
		int indeksNule = postojiNula(niz, n);
		
		if(indeksNule != -1) {
			niz = siftovanNizNMesta(niz, n, indeksNule);
			ispisiNiz(niz, n);
		} else {
			System.out.println("U vasem nizu nema nula!");
		}
		
	}

	private static int[] siftovanNizNMesta(int[] niz, int n, int indeksNule) {
		
		int i = n - indeksNule;
		
		while(i > 0) {
			niz = siftovaniNizJednoMesto(niz, n, indeksNule);
			i--;
		}
		
		return niz;
	}

	private static void ispisiNiz(int[] niz, int n) {
		
		for(int i = 0; i < n; i++) {
			System.out.print(niz[i] + " ");
		}
		System.out.println();
		
	}

	private static int[] siftovaniNizJednoMesto(int[] niz, int n, int indeksNule) {
		
		int[] pomocniNiz = new int[n];
		
		for(int j = 1; j < n; j++) {
			pomocniNiz[j] = niz[j-1];
		}
		pomocniNiz[0] = niz[n-1];
		
		return pomocniNiz;
	}

	private static int postojiNula(int[] niz, int n) {
		
		int indeksNule = -1;
		
		for(int i = 0; i < n; i++) {
			if(niz[i] == 0) {
				indeksNule = i;
			}
		}
		
		return indeksNule;
	}

	private static int[] ucitajNiz(int n) {
		
		int[] niz = new int[n];
		System.out.println("Unesite lemente niza!");
		for(int i = 0; i < n; i++) {
			niz[i] = scanner.nextInt();
		}
 		
		return niz;
		
	}

}
