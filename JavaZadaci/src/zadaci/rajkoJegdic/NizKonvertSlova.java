package zadaci.rajkoJegdic;

import java.util.Scanner;

public class NizKonvertSlova {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Unesite sifru!");
		
		String sekvenca = scanner.nextLine();
		
		String rec = NizKonvertujString(sekvenca);
		
		System.out.println(rec);
		
		scanner.close();
		
	}

	private static String NizKonvertujString(String sekvenca) {
		
		String rec = "";
		
		String[] tastatura = {" ", null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxzy"};
		
		String[] niz = sekvenca.split(";");

		for(String s: niz) {
			int brojac = 0;
			for(Integer i = 0; i < 10; i++) {				
				if(s.charAt(0) ==  i.toString().charAt(0)) {
					if(i != 7 && i != 9) {
						brojac = s.length()%3;
					} else if(i == 0) {
						brojac = 1;
					}
					else {
						brojac = s.length()%4;
					}
					rec += tastatura[i].charAt(brojac-1);
				}				
			}			
		}	
		return rec;
	}

}
