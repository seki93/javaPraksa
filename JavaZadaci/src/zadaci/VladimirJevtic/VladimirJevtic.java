package zadaci.VladimirJevtic;


public class VladimirJevtic {
	

		public static void main(String[] args) {
			
			String dobarPrimer = "asadaffghdfa";
			String losPrimer  = "asdfghjk";
			
			
			System.out.println();
	  		// pokusao sam drugaciji pristup, preko brojaca
			int brojac = 0;
			// Menjamo losPrimer/dobarPrimer
			char [] ulaz = dobarPrimer.toCharArray();
			System.out.println(" Duplikati: ");
			for (int i = 0; i < dobarPrimer.length(); i++) {
				for (int j = i + 1 ; j< dobarPrimer.length(); j++) {
					if (ulaz[i] == ulaz[j]) {
						System.out.println(ulaz[j]);
						brojac++;
						break;
						
					}
					}
					
					}
				
				}
			}
				