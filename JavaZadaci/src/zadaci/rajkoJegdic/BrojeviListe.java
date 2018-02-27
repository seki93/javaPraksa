package zadaci.rajkoJegdic;

import java.util.ArrayList;
import java.util.List;

public class BrojeviListe {

	public static void main(String[] args) {
		
		int a = 1234;
		int b = 356;
		
		System.out.println(saberiBrojeve(a, b));

	}

	private static List<Integer> saberiBrojeve(int a, int b) {
		
		List<Integer> lista1 = new ArrayList<>();
		List<Integer> lista2 = new ArrayList<>();
		
//		while(true) {
//			if (a/10!=0 || b/10!=0) {
//				lista1.add(lista1.size(), a%10);
//				a = a/10;
//				
//				lista2.add(lista2.size(), b%10);
//				b = b/10;
//			} else {
//				return lista1;
//			}
//			
//		}
		
		while(a/10 != 0) {
			lista1.add(lista1.size(), a%10);
			a = a/10;
		}
		lista1.add(lista1.size(), a%10);
		
		while(b/10 != 0) {
			lista2.add(lista2.size(), b%10);
			b = b/10;
		}
		lista2.add(lista2.size(), b%10);
		
		
		if(lista1.size() > lista2.size()) {
			int i = lista1.size() - lista2.size();
			while(i > 0) {
				lista2.add(lista2.size(), 0);
				i--;
			}
		} else if(lista1.size() < lista2.size()){
			int i = lista2.size() - lista1.size();
			while(i > 0) {
				i--;
			}
		}
		
		List<Integer> lista = new ArrayList<>();
		int prenosilac = 0;
		for(int i=0; i < lista1.size(); i++) {
			int medjuSabirak = lista1.get(i) + lista2.get(i);
			lista.add(prenosilac + medjuSabirak%10);
			prenosilac = medjuSabirak/10;
		}
		
		return lista;
		
	}

}
