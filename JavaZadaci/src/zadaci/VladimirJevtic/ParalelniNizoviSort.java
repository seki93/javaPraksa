package zadaci.VladimirJevtic;

import java.util.HashMap;

import org.apache.log4j.Logger;

public class ParalelniNizoviSort {
	
	private static final Logger LOGGER = Logger.getLogger(ParalelniNizoviSort.class.getName() );
	
	public static void metoda(int vrednost[], int indeksi[]){
		
		HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < vrednost.length; i++) {
			if (vrednost != null && indeksi != null)
				mapa.put(indeksi[i], vrednost[i]);
		}
		
		LOGGER.debug(mapa.values());
		
	}

	public static void main(String[] args) {
		
		int vrednosti[] = {20, 11, 45, 32, 31, 68};
		int indeksi[] = {5, 0, 2, 1, 4, 3};
		
		metoda(vrednosti, indeksi);
		

	}

}
