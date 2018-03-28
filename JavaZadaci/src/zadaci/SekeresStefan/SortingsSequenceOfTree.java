package zadaci.SekeresStefan;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class SortingsSequenceOfTree {
	
	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		
		int [] sequence = {4,5,6,4,1,0,9,8,1,4,0,5};
		//int [] sequence = {1,9,7,5,4,1,0,1,2,4,3,0};
		//int [] sequence = {7,8,1,1,2,3,4,5,6,9};
		
		sortSumOfThree(sequence);
		
		
	}
	
	public static void sortSumOfThree(int [] sequence) {

		int sum = 0;
		int [] sequenceOfSum = new int [sequence.length/3];
		int [] position = new int [sequence.length/3];
		int poz = 0;
		int c = 0;
		int n = sequence.length;
		if( n % 3 != 0 ) {
			n = sequence.length - (sequence.length%3);
		}
		
		// Ovde sam samo sabrao 3 po 3 broja i pisao njihove sume u poseban niz i napravio jos jedan niz koji mi govori njihove pozicije
		for(int i = 0; i < n; i = i +3) {
			sum += sequence[i];
			sum += sequence[i+1];
			sum += sequence[i+2];
			sequenceOfSum[c] = sum;
			position[c] =poz;
			c++;
			poz++;
			sum = 0;
		}
		
		//Sortirao niz suma 
		for(int i = 0; i < sequenceOfSum.length - 1; i++) {
			for( int j = 0; j < sequenceOfSum.length - i - 1; j++) {
				if(sequenceOfSum[j] > sequenceOfSum[j+1]) {
					int tmp = sequenceOfSum[j];
					sequenceOfSum[j] = sequenceOfSum[j+1];
					sequenceOfSum[j+1] = tmp;
					
					int tmp1 = position[j];
					position[j] = position[j+1];
					position[j+1] = tmp1;
				}
			}
		}
           
		
//		for(int i = 0; i < sequenceOfSum.length; i++) {
//			logger.debug("vrednost: "+sequenceOfSum[i]+" pozicia: "+position[i]);
//		}
		
		
		int [] seq = new int [sequence.length];
		int b = 0;
		int numberOfLoop = 0;
		
		//Ovde sam iz originalnog niza pisao u pomocni niz 
		for(int i = 0; i < n; i++) { 
			seq[i] = sequence[position[b] * 3 + numberOfLoop];
			numberOfLoop++;
			 if(numberOfLoop > 2) {
				 b++;
				 numberOfLoop = 0;
			 }
		}
		
		while( n < sequence.length) {
			seq[n] = sequence[n++];
		}
		
		for(int i = 0; i < seq.length; i++) {
			logger.debug(seq[i]);
		}
	}

}
