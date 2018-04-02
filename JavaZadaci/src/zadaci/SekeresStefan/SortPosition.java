package zadaci.SekeresStefan;

import java.util.HashMap;

import org.apache.log4j.Logger;

public class SortPosition {
	
	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		
		int [] sequenceNumbers = {20,11,45,32,31,68};
		int [] sequencePositions = {5,0,2,1,4,3};
		
		//int [] sequenceNumbers = {4,2,5};
		//int [] sequencePositions = {2,0,1};
		
		sequenceNumbers = sortPosition(sequenceNumbers, sequencePositions);
		print(sequenceNumbers);
		
	}
	
	public static int[] sortPosition(int [] sequenceNumbers, int [] sequencePositions) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < sequenceNumbers.length; i++) {
			map.put(sequencePositions[i], sequenceNumbers[i]);
		}
		
		for(int i = 0; i < sequenceNumbers.length; i++) {
			sequenceNumbers[i] = map.get(i);
		}
		
		return sequenceNumbers;
	}
	
	public static void print(int [] sequenceNumbers) {
		String result = "";
		for(int i = 0; i < sequenceNumbers.length; i++) {
			result+=sequenceNumbers[i]+" ";
		}
		
		logger.debug(result);
	}

}
