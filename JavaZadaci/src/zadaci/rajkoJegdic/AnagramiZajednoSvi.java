package zadaci.rajkoJegdic;

import java.util.ArrayList;
import java.util.List;

public class AnagramiZajednoSvi {

	public static void main(String[] args) {
		
		ArrayList<String> nizStringova = new ArrayList<>();
		nizStringova.add("abcd");
		nizStringova.add("cfrtg");
		nizStringova.add("dcba");
		nizStringova.add("dfrt");
		nizStringova.add("frtd");
		nizStringova.add("amnj");
		nizStringova.add("retulkj");
		nizStringova.add("rftd");
		
		System.out.println(nizAnagramaSortiran(nizStringova));

	}

	private static List<String> nizAnagramaSortiran(ArrayList<String> nizStringova) {
		
		List<String> lista = new ArrayList<>();
		for(int i = 0; i < nizStringova.size(); i++) {
			lista.add(nizStringova.get(i));
			for(int j = i+1; j < nizStringova.size(); j++) {
				int[] p1 = ponavljanje(nizStringova.get(i));
				int[] p2 = ponavljanje(nizStringova.get(j));
				
				if(anagram(p1, p2)) {
					lista.add(nizStringova.get(j));
					nizStringova.remove(j);
				}
			}
		}
		
		return lista;
	}
	
	private static boolean anagram(int[] p1, int[] p2) {
		
		for(int i = 0; i < 26; i++) {
			if(p1[i] != p2[i]) {
				return false;
			}
		}
		
		return true;
	}

	public static int[] ponavljanje(String rec) {
		int[] niz = new int[27];
		rec.toCharArray();
		for(int i = 0; i < 26; i++) {
			niz[i] = 0;
		}
		
		for(int j=0; j<rec.length(); j++) {
			char c = rec.charAt(j);
			niz[c-'a'] += 1;
		}
		
		return niz;
		
	}

}
