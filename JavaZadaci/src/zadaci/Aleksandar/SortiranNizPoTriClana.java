package zadaci.Aleksandar;

import org.apache.log4j.Logger;

public class SortiranNizPoTriClana {

	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		
		int []niz = {4,5,6,4,1,0,9,8,1,4,0,5};
		//int []niz1 = {4,0,5,9,8,1,4,1,1,4,5,6};
		
		sortirajSumuOdTri(niz);

	}
	
	public static void sortirajSumuOdTri(int []niz) {
		
		int suma = 0;
		
		int [] nizSuma = new int[niz.length/3];
		
		int [] pozicije = new int[niz.length/3];
		
		int pozicija = 0;
		
		int k = 0;
		
		for(int i = 0;i < niz.length;i = i + 3) {
			
			suma = suma + niz[i];
			suma = suma + niz[i + 1];
			suma = suma + niz[i + 2];
			
			nizSuma[k] = suma;
			
			pozicije[k] = pozicija;
			
			pozicija++;
			k++;
			suma = 0;
		}
		
		for(int i = 0;i < nizSuma.length;i++) {
			
			for(int j = i + 1;j < nizSuma.length - i;j++) {
				
				if(nizSuma[j - 1] > nizSuma[j]) {
					
					int pom = nizSuma[j - 1];
					nizSuma[j - 1] = nizSuma[j];
					nizSuma[j] = pom;
					
					int pom1 = pozicije[j - 1];
					pozicije[j - 1] = pozicije[j];
					pozicije[j] = pom1;
				}
			}
		}
		
		int [] pomNiz = new int[niz.length];
		
		int n = 0;
		
		int broj = 0;
		
		for(int i = 0;i < niz.length;i++) {
			
			pomNiz[i] = niz[pozicije[n] * 3 + broj];
			broj++;
			
			if(broj > 2) {
				
				n++;
				broj = 0;
			}
		}
		
		for(int i = 0;i < pomNiz.length;i++) {
			
			logger.debug(pomNiz[i]);
		}
		
	}	

}
