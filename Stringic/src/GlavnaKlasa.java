import java.util.ArrayList;

public class GlavnaKlasa {

	public static void main(String[] args) {
		
		String dobarPrimer = "asadaffghdfa";
		String losPrimer  = "asdfghjk";
		
		
		System.out.println(""+seki1(losPrimer));
  		
	}

	
	public static boolean seki1(String niz){
		boolean bezPonavljanje = true;
		
		ArrayList<Character> listaKaraktera = new ArrayList<Character>();
		
		for(int i = 0; i < niz.length()-1; i++) {
			listaKaraktera.add(niz.charAt(i));
			if(listaKaraktera.contains(niz.charAt(i+1))) return false;
		}
		
		
		return bezPonavljanje;
	}
}
