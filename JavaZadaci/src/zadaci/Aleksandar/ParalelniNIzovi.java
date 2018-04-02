package zadaci.Aleksandar;


import java.util.Arrays;

import org.apache.log4j.Logger;

public class ParalelniNIzovi {

	public static void main(String[] args) {
		
		int []niz = {2,4,3,5,1};
		
		int []indeksi = {1,3,2,4,0};
		
		logger.debug(Arrays.toString(sortirajNiz(niz, indeksi)));
		

	}
	
	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static int [] sortirajNiz(int []niz, int []indeksi) {
		
		for(int i = 0;i < niz.length; i++) {
		
			for(int j = i + 1;j < niz.length; j++) {
				
				if(indeksi[i] > indeksi[j]) {
					
					int pom = indeksi[i];
					indeksi[i] = indeksi[j];
					indeksi[j] = pom;
					
					int pom1 = niz[i];
					niz[i] = niz[j];
					niz[j] = pom1;
				}
			}
		}
		return niz;
		
	}

}
