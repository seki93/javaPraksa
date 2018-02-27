package zadaci.VladimirJevtic;

import java.util.ArrayList;
import java.util.List;

public class DveCifre {
	
	public static void sabiranjeCifaraListe(int a, int b) {
		
		List<Integer> prvaLista = new ArrayList<Integer>();
		List<Integer> rezultat = new ArrayList<Integer>();
		List<Integer> drugaLista = new ArrayList<Integer>();
		
		while(true) {
			prvaLista.add(a%10);
			a/= 10;
			
			if(a == 0) 
				break;
			
		}
		
		System.out.println(" Prva Lista : " + prvaLista);
		
		while(true) {
			drugaLista.add(b%10);
			b/= 10;
			
			if(b == 0)
				break;
			
		}
		
		System.out.println(" Druga Lista : " + drugaLista);
			
		
		int broj1 = 0, broj2 = 0, r = 0;
		
		for(int i = prvaLista.size() - 1; i >= 0; i--) {
			broj1 = broj1 *10 + prvaLista.get(i);
		}
		
		System.out.println(" Prva cifra : " + broj1);
		
		for(int i = drugaLista.size() - 1 ; i >= 0; i--) {
			broj2 = broj2 * 10 + drugaLista.get(i);
		}
		
		System.out.println(" Druga cifra : " + broj2);
		
		r = broj1 + broj2;
	
		while(true) {
			rezultat.add(r%10);
			r/=10;
			
			if(r == 0)
				break;
		}
		
		System.out.println(" Rezultujuci broj dve liste : " + rezultat);
		
		}
	
	  public static void main(String[] args) {
		  
		  DveCifre.sabiranjeCifaraListe(1234568, 67890);
	  }
	
}

