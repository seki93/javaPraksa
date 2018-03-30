package zadaci.rajkoJegdic;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class CikCakNeki {

	private static Scanner scanner = new Scanner(System.in);
	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		
		logger.debug("Unesite broj elemenata niza!");
		int n = scanner.nextInt();
		
		logger.debug("Unesite " + n + " clanova niza!");
		int[] sequence = new int[n];
		for(int i = 0; i < n; i++) {
			sequence[i] = scanner.nextInt();
		}
		
		sequence = metoda(sequence, n);
		
		printSequence(sequence, n);
		
		scanner.close();

	}

	private static int[] metoda(int[] sequence, int n) {
		
		if(sequence[0] > sequence[1] && sequence[1] > sequence[2]) {
			swap(sequence, 1, 2);
		}
		if((sequence[0] < sequence[1] && sequence[1] < sequence[2]) || (sequence[0] < sequence[1])){
			swap(sequence, 0, 1);
		}
		
		int pokazivac = 1;		
		for(int i = 3; i < n; i++) {
			int j = i;
			if(pokazivac == 1) {
				while(j < n) {
					if(sequence[i-1] > sequence[j]) {
						swap(sequence, i, j);
						pokazivac = 0;
						break;
					}
					j++;
				}
 			} else if (pokazivac == 0) {
 				while(j < n) {
					if(sequence[i-1] < sequence[j]) {
						swap(sequence, i, j);
						pokazivac = 1;
					}
					j++;
				}
			}
		}
		
		return sequence;
	}

	private static void swap(int[] sequence, int i, int j) {
		
		int tmp = sequence[i];
		sequence[i] = sequence[j];
		sequence[j] = tmp;
		
	}

	private static void printSequence(int[] sequence, int n) {
		
		String row = "";
		for(int i = 0; i < n; i++) {
			row += sequence[i] + " ";
		}
		
		logger.debug(row);
		
	}

	

}
