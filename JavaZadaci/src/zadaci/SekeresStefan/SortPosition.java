package zadaci.SekeresStefan;

import java.util.HashMap;

import org.apache.log4j.Logger;

public class SortPosition {
	
	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		
		int [] sequenceNumbers = {20,11,45,32,31,68};
		int [] sequencePositions = {5,0,2,1,4,3};
		
		sortPosition(sequenceNumbers, sequencePositions);
	}
	
	public static void sortPosition(int [] sequenceNumbers, int [] sequencePositions) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		String result = "";
		
		for(int i = 0; i < sequenceNumbers.length; i++) {
			map.put(sequencePositions[i], sequenceNumbers[i]);
		}
		
		for(int i = 0; i < map.size(); i++) {
			result+=map.get(i)+" ";
		}
		
		logger.debug(result);
	}

}
