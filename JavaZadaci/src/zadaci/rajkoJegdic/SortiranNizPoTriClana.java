package zadaci.rajkoJegdic;

import java.util.HashMap;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class SortiranNizPoTriClana {

	static Scanner sc = new Scanner(System.in);
	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		
		logger.debug("Unesite broj elemenata niza!");
		int n = sc.nextInt();
		
		int[] niz = new int[n];
		for(int i = 0; i < n; i++) {
			niz[i] = sc.nextInt();
		}
		
		niz = metoda(niz);
		
		ispisiNiz(niz);
		
		sc.close();
		
	}

	private static void ispisiNiz(int[] niz) {
		
		for(int i = 0; i < niz.length; i++) {
			logger.debug(niz[i]);
		}
		
	}

	private static int[] metoda(int[] niz) {
		int[] pomNiz = new int[niz.length];
		
		HashMap<Integer, int[]> mapa = new HashMap<>();
		
		//da broj el. niza bude deljiv a tri ako nije dodati kasnije
		int n;
		if(niz.length%3 != 0) {
			n = niz.length - niz.length%3;
		} else {
			n = niz.length;
		}
		
		//popunjavam mapu
		int i = 0;
		while(i < n) {
			int s = niz[i] + niz[i+1] + niz[i+2];
			int[] podNiz = {niz[i], niz[i+1], niz[i+2]};
			mapa.put(s, podNiz);
			i += 3;
		}
		
		int[] nizZbirova = new int[n/3];
		int j = 0;
		for(int kljuc: mapa.keySet()) {
			nizZbirova[j] = kljuc;
			j++;
		}
		
		nizZbirova = sortirajNiz(nizZbirova);		
		for( i = 0; i < nizZbirova.length; i++) {
		}
		
		
		for(i = 0; i < n/3; i++) {
			int[] tmp = new int[n/3];
			tmp = mapa.get(nizZbirova[i]);
			
			for(j = 0; j < 3; j++) {
				pomNiz[i*3+j] = tmp[j];
			}
		}
		
		//dodati brojeve ako broj elemenata niza nije deljiv sa tri
		while(n < niz.length) {
			pomNiz[n] = niz[n];
			n++;
		}
		
		return pomNiz;
	}

	private static int[] sortirajNiz(int[] nizZbirova) {
		int n = nizZbirova.length;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < n; j++) {
				if(nizZbirova[j-1] > nizZbirova[j]) {
					int tmp = nizZbirova[j];
					nizZbirova[j] = nizZbirova[j-1];
					nizZbirova[j-1] = tmp;
				}
			}
		}
		
		return nizZbirova;
	}

}
