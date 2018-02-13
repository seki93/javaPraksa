package zadaci.rajkoJegdic;

import java.util.LinkedList;


public class ListaDuplikati {

	public static void main(String[] args) {
		
		LinkedList<String> lista = new LinkedList<>();
		
		lista.add("marko");
		lista.add("asd");
		lista.add("rajko");
		lista.add("asd");
		lista.add("djole");
		
		
		lista = bezDuplikata(lista);
		
		stampaj(lista);	
		
	}

	private static void stampaj(LinkedList<String> lista) {
			
		for(String a: lista) {
			System.out.println(a);
		}
		
	}

	private static LinkedList<String> bezDuplikata(LinkedList<String> lista) {
		
		//FIXME: zanima me sto nece da radi
		/*for(String a: lista) {
			int br = 0;
			for(String b: lista) {
				if(a.equals(b)) {
					br++;
				}
			}
			if(br>1) {
				for(int i = br; i>1; i--) {
					int c = lista.lastIndexOf(a);
					System.out.println(c);
					//lista.remove(c);
				}
			}
		}*/
			
		for(int i = 0; i < lista.size(); i++) {
			for(int j = i+1; j < lista.size(); j++) {
				if(lista.get(i).equals(lista.get(j))) {
					lista.remove(j);
				}
			}
		}		
		
		return lista;
	}

}
