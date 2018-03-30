package zadaci.Aleksandar;

import org.apache.log4j.Logger;

public class ZbirTriElementa {

	public static void main(String[] args) {
		
		int []niz = {1,7,9,2,10,12};
		
		zbirTriBroja(niz);

	}
	
	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void zbirTriBroja(int []niz) {
		
		int suma = 0;
		
		for(int i = 0;i < niz.length-2; i++) {
			
			for(int j = i + 1;j < niz.length-1; j++) {
				
				for(int k = j + 1;k < niz.length; k++) {
					
					suma = niz[i] + niz[j] + niz[k];
					
					if(niz[i] + niz[j] + niz[k] == suma) {
						
						for(int n = 0;n < niz.length; n++) {
							
							if(suma == niz[n]) {
								
								logger.debug("Suma bilo koja 3 elementa iz niza je: " + suma);
							}
						}
					}
				}
			}
		}
		
	}

}
