package zadaci.rajkoJegdic;

public class GlavnaKlasa {

	public static void main(String[] args) {
		
		String dobarPrimer = "asadaffghdfa";
		String losPrimer  = "asdfghjk";
		
		
		int i = ponavljanje(dobarPrimer);
		if(i==1) {
			System.out.println("ima ponavljanja");
		} else {
			System.out.println("Nema ponavljanja");
		}
  		
	}
	
	public static int ponavljanje(String rec) {
		int[] niz = new int[27];
		rec.toCharArray();
		for(int i = 0; i < 26; i++) {
			niz[i] = 0;
		}
		
		for(int j=0; j<rec.length(); j++) {
			char c = rec.charAt(j);
			niz[c-'a'] += 1;
		}
		
		int a=0;
		for(int i=0; i<26; i++) {
			if(niz[i]>1)
				a=1;
		}
		
		return a;
		
	}

}