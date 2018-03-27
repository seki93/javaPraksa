package zadaci.VladimirJevtic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class SortiranNizPoTriClana {
	
	static Scanner sc = new Scanner(System.in);
	
	private static final Logger LOGGER = Logger.getLogger( SortiranNizPoTriClana.class.getName() );

	
	public static int[] sort(int[] niz) {

		int pomocniniz[] = new int[niz.length];
		HashMap<Integer, int[]> map = new HashMap<>();
		
		int duzniza;
		if(niz.length%3 != 0) {
			duzniza = niz.length - niz.length%3;
		} else {
			duzniza = niz.length;
		}
		
		int i = 0;
		while(i < duzniza) {
			int k = niz[i] + niz[i+1] + niz[i+2];
			int[] niz1= {niz[i], niz[i+1], niz[i+2]};
			map.put(k, niz1);
			i += 3;
		}
		int zbirNiz[] = new int[duzniza/3];
		int m = 0;
		for(int key: map.keySet()) {
			zbirNiz[m] = key;
			m++;
		}
		
		zbirNiz = sortiraj(zbirNiz);
		
		for(int f = 0; f < duzniza/3; f++) {
			int[] pomoc = new int[duzniza/3];
			pomoc = map.get(zbirNiz[f]);
			
			for(int j = 0; j < 3; j++) {
				pomocniniz[f*3+j] = pomoc[j];
			}
		}
		
		while(duzniza < niz.length) {
			pomocniniz[duzniza] = niz[duzniza];
			duzniza++;
		}
		
		
		return pomocniniz;
	}
	
	private static int[] sortiraj(int[] zbirNiz) {
		int duzina = zbirNiz.length;
		for(int i = 0; i < duzina; i++) {
			for (int j = 1; j < duzina; j++) {
				if (zbirNiz[j-1] > zbirNiz[j]) {
					int pom = zbirNiz[j];
					zbirNiz[j] = zbirNiz[j-1];
					zbirNiz[j-1] = pom;
				}
			}
		}
		
		return zbirNiz;
	}
		
	
	

	
	public static void main(String[] args) {
		
		
		
		LOGGER.debug("Unesite duzinu niza");
		int duzina = sc.nextInt();
		int niz[] = new int[duzina];
		
		for (int i = 0; i < duzina; i++) {
			LOGGER.debug("Unesi clan niza : " );
			niz[i] = sc.nextInt();
		}
		
		List<Integer> lista = new ArrayList<>();
		
		sc.close();
		
		niz = sort(niz);
		
		for (int i = 0; i < niz.length; i ++) {
			lista.add(niz[i]);
			
			
		}
		LOGGER.debug(lista);
		
	}

}
