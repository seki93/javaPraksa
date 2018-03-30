package zadaci.SekeresStefan;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.log4j.Logger;

public class Suma3Elementa {
	
	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		
		int sequnce [] = {1,7,9,10,2,12};
		
		sumThreeElements(sequnce);
	}
	
	public static void sumThreeElements(int [] sequnce) {
		int sum = 0;
		
		for(int i = 0; i < sequnce.length -2 ; i++) {
			int j = i + 1;
			int k = j + 1;
			while(j < sequnce.length - 1) {
				sum+=sequnce[i];
				sum+=sequnce[j];
				sum+=sequnce[k];
				
				if(find(sequnce, sum) != -1) logger.debug(sequnce[find(sequnce, sum)]);
				j++;
				sum = 0;
			}
			j = i +1;
			while(k < sequnce.length) {
				sum+=sequnce[i];
				sum+=sequnce[j];
				sum+=sequnce[k];
				
				if(find(sequnce, sum) != -1) logger.debug(sequnce[find(sequnce, sum)]);
				k++;
				sum = 0;
			}
		}
		
	}
	
	public static int find(int [] sequnce, int a) {
		for(int i = 0; i < sequnce.length; i++) {
			if(sequnce[i] == a) return i;
		}
		
		return -1;
	}

}
