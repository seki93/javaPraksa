package zadaci.SekeresStefan;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		String losPrimer = "asadaffghdfa";
		String dobarPrimer  = "asdfghjk";
		
		System.out.println(""+sekeres1(losPrimer));
		System.out.println(""+sekeres1(dobarPrimer));
		
	}
	
	public static boolean sekeres1(String niz) {
	
		ArrayList<Character> listaKaraktera = new ArrayList<Character>();
		
		for(int i = 0; i < niz.length()-1; i++) {
			listaKaraktera.add(niz.charAt(i));
			
			if(listaKaraktera.contains(niz.charAt(i+1))) return false;
		}
		
		return true;
	}

}
