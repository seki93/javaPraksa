package zadaci.SekeresStefan;

import java.util.HashMap;

public class Anagram {
	
	public static void main(String[] args) {
		
		String sequence1 = "acb";
		String sequence2 = "abc";
		
		
		System.out.println(""+anagram(sequence1, sequence2));
	}
	
	
	public static boolean anagram(String sequence1, String sequence2) {
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for( int i = 0; i < sequence1.length(); i++) {
			
			if(map.containsKey(sequence1.charAt(i))) {
				map.put(sequence1.charAt(i), map.get(sequence1.charAt(i) +1) );
			}else {
				map.put(sequence1.charAt(i), 1);
			}
		}
		
		//different length -> false
		if(sequence1.length() > sequence2.length() || sequence1.length() < sequence2.length()) return false;
		
		
		for( int i = 0; i < sequence2.length(); i++) {
			
			if(!map.containsKey(sequence2.charAt(i))) {
				return false;
			}
		}
		
		
		return true;
	}

}
