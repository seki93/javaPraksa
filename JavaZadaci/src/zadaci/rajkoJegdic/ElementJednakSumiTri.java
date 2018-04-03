package zadaci.rajkoJegdic;

import org.apache.log4j.Logger;

public class ElementJednakSumiTri {

	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		
		int[] sequence = {3, 7, 8, 4, 12, 2};
		
		method(sequence);
	}

	private static void method(int[] sequence) {
		
		for (int i = 0; i < sequence.length; i++) {
			for (int j = i+1; j < sequence.length; j++) {
				for (int k = j+1; k < sequence.length; k++) {
					int sum = sequence[i] + sequence[j] + sequence[k];
					
					for (int l = 0; l < sequence.length; l++) {
						if(sum == sequence[l]) {
							logger.debug(sum);
						}
					}
				}
			}
		}
		
	}

}
