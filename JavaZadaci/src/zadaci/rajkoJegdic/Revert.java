package zadaci.rajkoJegdic;

import java.util.LinkedList;

public class Revert {

	public static void main(String[] args) {
		
		LinkedList<String> lista = new LinkedList<String>();
		lista.add(" ovo");
		lista.add(" je ");
		lista.add(" primer ");
		
		lista = obrniLista(lista);
		stampajListu(lista);
		
		int[] niz = {1, 2, 3, 4, 5};
		
		niz = obrniNiz(niz);
		stampajNiz(niz);		

	}

	private static void stampajNiz(int[] niz) {
		for(int i = 0; i < niz.length; i++) {
			System.out.print(niz[i] + " ");
		}
		System.out.println();
		
	}

	private static int[] obrniNiz(int[] niz) {
		
		int[] pomocniNiz = new int[niz.length];
		for(int i = 0; i < niz.length; i++) {
			pomocniNiz[i] = niz[niz.length -1 - i];
		}
		
		return pomocniNiz;
	}

	private static LinkedList<String> obrniLista(LinkedList<String> lista) {
		
		LinkedList<String> pomocnaLista = new LinkedList<>();
		
		for(int i = 0; i < lista.size(); i++) {
			pomocnaLista.addFirst(lista.get(i));
		}
		
		return pomocnaLista;
	}
	
	private static void stampajListu(LinkedList<String> lista) {
		
		for(String a: lista) {
			System.out.println(a);
		}
		
	}

}
