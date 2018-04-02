package zadaci.Aleksandar;

import java.util.HashMap;

import org.apache.log4j.Logger;

public class ParalelniNIzovi {

	public static void main(String[] args) {
		
		int []niz = {2,4,3,5,1};
		
		int []indeksi = {1,3,2,4,0};
		
		sortirajNiz(niz, indeksi);

	}
	
	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void sortirajNiz(int []niz, int []indeksi) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0;i < niz.length;i++) {
			
			if(niz != null && indeksi != null) {
				
				map.put(indeksi[i], niz[i]);
			}
		}
		
	   logger.debug(map.values());
		
	}

}
