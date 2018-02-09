package zadaci.rajkoJegdic;

public class Anagram {

	public static void main(String[] args) {
		
		String rec1 = "abc";
		rec1 = bezRazmaka(rec1);
		String rec2 = "ab";
		rec2 = bezRazmaka(rec2);		
		
		int[] p1 = ponavljanje(rec1);
		int[] p2 = ponavljanje(rec2);
		
		if(anagram(p1, p2)) {
			System.out.println("Jeste anagram!");
		} else {
			System.out.println("Nije anagram");
		}
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
	
	public static String bezRazmaka(String rec) {
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < rec.length(); i++) {
			if(rec.charAt(i) != ' ') {
				sb.append(rec.charAt(i));
			} else {
				continue;
			}
		}
		
		return sb.toString();
	}

}
