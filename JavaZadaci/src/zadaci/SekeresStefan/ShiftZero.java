package zadaci.SekeresStefan;

import java.util.Scanner;

public class ShiftZero {
	
	private static Scanner sc;
	private static boolean zero = false;
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		System.out.println("Enter sequence length: ");
		int n = sc.nextInt();
		
		int [] sequence = new int [n];
		
		makeSequence(sequence, n);
		System.out.println("Sequnce before method: ");
		print(sequence, n);
		
		if(zero) {
			while(sequence[0] != 0) {
				sequence = shift(sequence, n);
			}	
		}
		
		System.out.println("After: ");
		print(sequence, n);
	}
	
	public static int[] shift(int [] seq, int n) {
		
		int [] pom = new int [n];
		
		pom[0] = seq[n-1];
		for(int i = 1; i < n ; i++) {
			pom[i] = seq[i -1];
		}
		
		return pom;
	}
	
	public static void makeSequence (int [] seq, int n) {
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter values: ");
			seq[i] = sc.nextInt();
			if(seq[i] == 0) zero = true;
		}
	}
	
	public static void print(int [] seq, int n) {
		
		for(int i = 0; i < n; i++) {
			System.out.print(" "+seq[i]);
		}
	}

}
