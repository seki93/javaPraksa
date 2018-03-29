package zadaci.VladimirJevtic;

import org.apache.log4j.Logger;

public class CikCakNiz {
	
	private static final Logger LOGGER = Logger.getLogger( CikCakNiz.class.getName() );
	
	
	public static int[] cikCakMetoda(int niz[]) {
		int pom = 0;
		boolean znak = true;
		for (int i = 0; i < niz.length-1; i++) {
			if (znak) { // 1 < 2 < 3 - swap 1 < 3 > 2
					if (niz[i] < niz[i+1]) { 
						pom = niz[i];
						niz[i] = niz[i+1];
						niz[i+1] = pom; 
						} 
				} else if (niz[i] > niz[i+1]) { // 3 > 2 > 1 - swap 3 > 1 < 2
						pom = niz[i];
						niz[i] = niz[i+1];
						niz[i+1] = pom;
						}
					znak = !znak;
				}	
			return niz;
		}
	
	public static void main(String[] args) {
		
		int niz[] = {1, 2, 3, 4, 5, 6, 7, 8, 2, 3}; 
		int pom[] = cikCakMetoda(niz);
		String s = "";
		
		for (int i = 0; i < pom.length; i++) {
			s = s + " " + pom[i];
			}
		
		LOGGER.debug(s);
		
		}
}
