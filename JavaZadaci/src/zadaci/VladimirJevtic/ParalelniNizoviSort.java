package zadaci.VladimirJevtic;

import java.util.Arrays;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class ParalelniNizoviSort {
	
	private static final Logger LOGGER = Logger.getLogger(ParalelniNizoviSort.class.getName() );
	
	public static int[] metoda(int vrednost[], int indeksi[]){
		
//		HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();
//		
//		for (int i = 0; i < vrednost.length; i++) {
//			if (vrednost != null && indeksi != null)
//				mapa.put(indeksi[i], vrednost[i]);
//		}
//		 
//		LOGGER.debug(mapa.values());
		
		for (int i = 0; i < vrednost.length; i++) {
			for (int j = i +1; j < vrednost.length; j++) {
			
			if (indeksi[i] > indeksi[j]) {
				int temp = indeksi[i];
				indeksi[i] = indeksi[j];
				indeksi[j] = temp;
				
				int temp2 = vrednost[i];
				vrednost[i] = vrednost[j];
				vrednost[j] = temp2;
				
				}
			}
		}
		return vrednost;
		
	}

	public static void main(String[] args) {
		
		int vrednosti[] = {20, 11, 45, 32, 31, 68};
		int indeksi[] = {5, 0, 2, 1, 4, 3};
		LOGGER.debug(Arrays.toString(metoda(vrednosti, indeksi)));
		
		

	}

}
