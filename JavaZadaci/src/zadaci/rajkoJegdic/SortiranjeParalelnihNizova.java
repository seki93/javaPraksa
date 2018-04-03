package zadaci.rajkoJegdic;

import org.apache.log4j.Logger;

public class SortiranjeParalelnihNizova {

	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		
		int[] sequence = {20, 11, 45, 32, 31, 68};
		int[] index = {5, 0, 2, 1, 4, 3};
		
		sequence = method(sequence, index);
		
		printSequence(sequence);

	}

	private static int[] method(int[] sequence, int[] index) {
		
		for (int i = 0; i < index.length; i++) {
			for (int j = i+1; j < index.length; j++) {
				if(index[i] > index[j]) {
					swap(index, i, j);
					swap(sequence, i, j);
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

	private static void printSequence(int[] sequence) {
		
		String buffer = "";
		for (int i = 0; i < sequence.length; i++) {
			buffer += sequence[i] + " ";
		}
		
		logger.debug(buffer);
	}

}
