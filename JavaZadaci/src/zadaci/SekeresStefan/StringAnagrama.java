package zadaci.SekeresStefan;

import java.util.ArrayList;
import java.util.HashMap;

public class StringAnagrama {
	
	public static void main(String[] args) {
		
		ArrayList<String> anagramsInOrder = new ArrayList<String>();
		ArrayList<String> newList = new ArrayList<String>();
		anagramsInOrder.add("abc");
		anagramsInOrder.add("cfrtg");
		anagramsInOrder.add("bca");
		anagramsInOrder.add("cba");
		anagramsInOrder.add("sek");
		anagramsInOrder.add("esk");
		anagramsInOrder.add("kse");
		anagramsInOrder.add("rftd");
		
		
		System.out.println(anagramsInOrder);
		changeStringOder(anagramsInOrder, newList);
		System.out.println(newList);
		//System.out.println(""+isAnagram("abc", "cba"));
		
	}
	
	
	public static void changeStringOder(ArrayList<String> anagram, ArrayList<String> newList) {
		
		for( int i = 0; i < anagram.size(); i++) {
			newList.add(anagram.get(i));
			for( int j = i + 1; j < anagram.size(); j++ ) {
				if(isAnagram(anagram.get(i), anagram.get(j))) {
					newList.add(anagram.get(j));
					anagram.remove(anagram.get(j));
					--j;
				}
				
			}
		}
		
	}
	
	public static boolean isAnagram(String a, String b) {
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		if( a.length() != b.length()) return false;
		
		for( int i = 0; i < a.length(); i++) {
			if(map.containsKey(a.charAt(i))) {
				map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
			}else {
				map.put(a.charAt(i), 1);
			}
		}
		
		for( int i = 0; i < b.length(); i++) {
			if(!map.containsKey(b.charAt(i))) return false;
			else {
				map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
			
				if(map.get(b.charAt(i)) == 0)
					map.remove(b.charAt(i));
			}
		}
		
		return map.isEmpty();
	}

}
