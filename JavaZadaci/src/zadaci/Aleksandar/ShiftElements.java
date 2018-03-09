package zadaci.Aleksandar;

public class ShiftElements {

	public static void main(String[] args) {
		
		int []niz = {3,2,1,4,5,0,6};
		
		int duzina = niz.length;
		int pozicijaNule = -1;
		for(int i = 0;i < duzina;i++ ) {
			
			if(niz[i] == 0) {
				
				pozicijaNule = i;
			}
		}
		
		int k = duzina-pozicijaNule;
		
		k = k % duzina;
		
		int []pomereniNiz = new int[duzina];
		
		for(int i = 0;i < duzina;i++) {
			
			pomereniNiz[(k + i) % duzina] = niz[i];
		}
		
		System.out.println("Pomeren niz u desno");
		
		for(int i: pomereniNiz) {
			
			System.out.print(i);
		}
		

	}

}
