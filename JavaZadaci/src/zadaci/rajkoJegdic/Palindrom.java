package zadaci.rajkoJegdic;

public class Palindrom {

	public static void main(String[] args) {

		if(palindrom("Ana voli milovana")) {
			System.out.println("Rec jeste palindrom!");
		} else {
			System.out.println("Rec nije palindrom");
		}
		
	}
	
	public static boolean palindrom(String sb) {
		
		String rec = bezRazmaka(sb);
		
		rec = rec.toLowerCase();
		
		for(int i = 0, j = rec.length()-1; i != j; i++, j--) {
			if(rec.charAt(i) != rec.charAt(j)) {
				return false;
			}
		}
		
		return true;
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
