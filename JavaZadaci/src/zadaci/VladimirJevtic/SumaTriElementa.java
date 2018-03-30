package zadaci.VladimirJevtic; 

import org.apache.log4j.Logger;

public class SumaTriElementa {
	
	private static final Logger LOGGER = Logger.getLogger( CikCakNiz.class.getName() );
	
	public static void metoda(int niz[]){
		int broj = 0;
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		
		for (int i = 0; i < niz.length-2; i++) {
			for (int j = i + 1; j < niz.length-1; j++) {
				for (int k = j + 1; k < niz.length; k++) {
					broj = niz[i] + niz[j] + niz[k];
					if (niz[i] + niz[j] + niz[k] == broj) {
						for (int p = 0; p < niz.length; p++) {
							if (broj == niz[p]) {
								LOGGER.debug(" Broj " + broj + " u nizu ima zbirove " + niz[i] + " , "+ niz[j] + " , " + niz[k] );
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		
		int niz[] = {1, 10 , 7 , 2 , 9, 12};
		
		metoda(niz);

	}

}
