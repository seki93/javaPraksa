package zadaci.Aleksandar;

import org.apache.log4j.Logger;

public class CikCakNiz {

	public static void main(String[] args) {
		
		
		int []niz = {1,3,5,4,7,5,2,6,8,4,1,6};
		
		ispisiNiz(niz);
		String s = "";
		for(int i = 0;i < niz.length;i++) {
			
			s = s + niz[i] + " ";
		}
		logger.debug(s);
		

	}
	
	
	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void ispisiNiz(int []niz) {
		
		for(int i = 0;i < niz.length-2;i++) {
			
				if(niz[i] < niz[i + 1]) {
					
					if(niz[i + 1] < niz[i + 2]) {
						
						int pom = niz[i + 1];
						
						niz[i + 1] = niz[i];
						
						niz[i] = pom;
		
					}
			} 
		}
		
	}
	

}
