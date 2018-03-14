package zadaci.SekeresStefan;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class OldPhoneRevers {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter sentence");
		
		String sentence = sc.nextLine();
		
		char[] wordSequnce = sentence.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		
		makeHasMap(map);

		System.out.println(makeNumbers(wordSequnce, map));
		
		
	}
	
	public static String makeNumbers(char[] wordSequnce, HashMap<Character, Integer> map) {
		
		String finalNumbers = "";
		
		for(int i = 0; i < wordSequnce.length; i++) {
			for (Entry<Character, Integer> entry : map.entrySet()) {
	            if(entry.getKey().equals(wordSequnce[i])) {
	            	finalNumbers += entry.getValue();
	            	finalNumbers += ";";
	            	break;
	            }
				
			}
		}
		
		return finalNumbers;
	}
	
	public static void makeHasMap(HashMap<Character, Integer> map) {
		map.put('a', 2);
		map.put('b', 22);
		map.put('c', 222);
		map.put('d', 3);
		map.put('e', 33);
		map.put('f', 333);
		map.put('g', 4);
		map.put('h', 44);
		map.put('i', 444);
		map.put('j', 5);
		map.put('k', 55);
		map.put('l', 555);
		map.put('m', 6);
		map.put('n', 66);
		map.put('o', 666);
		map.put('p', 7);
		map.put('q', 77);
		map.put('r', 777);
		map.put('s', 7777);
		map.put('t', 8);
		map.put('u', 88);
		map.put('v', 888);
		map.put('w', 9);
		map.put('x', 99);
		map.put('y', 999);
		map.put('z', 9999);
		map.put(' ', 0);

	}

}
