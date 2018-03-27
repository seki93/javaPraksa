package zadaci.rajkoJegdic;

public class SumaTriBroja {

	public static void main(String[] args) {
		
		int[] niz = {1,9,3,4,5,2,7,8,6};
		int broj = 10;
		
		sumaTriBroja(niz, broj);

	}

	private static void sumaTriBroja(int[] niz, int broj) {
		
		for(int i = 0; i < niz.length - 2; i++) {
			if((niz[i] + niz[i+1] + niz[i+2]) > 10) {
				System.out.println(niz[i] + " " + niz[i+1] + " "+ niz[i+2]);
			}
		}
		
	}

}
