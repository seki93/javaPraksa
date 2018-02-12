package zadaci.SekeresStefan;

import java.util.LinkedList;

public class Lista {
	
	
	public static void main(String[] args) {
		
		
		LinkedList<Integer> lista = new LinkedList<Integer>();
		
		lista.add(1);
		lista.add(2);
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		lista.add(6);
		lista.add(0);
		lista.add(7);
		lista.add(7);
		lista.add(1);
		
		printList(lista);
		System.out.println("Number of element before delete method: "+lista.size());
		deleteDuplicate(lista);
		System.out.println("After methode");
		printList(lista);
		System.out.println("Nubmer of element: "+lista.size());
	}
	
	
	public static void printList(LinkedList<Integer> list) {
		for(int a : list) {
			System.out.println("Value from list: "+a);
		}
	}
	
	public static void deleteDuplicate(LinkedList<Integer> lista) {
		
		int j = 0;
		
		for( int i = 0; i < lista.size() -1; i++) {
			j = i + 1;
			while(j < lista.size()) {
				if(lista.get(i) == lista.get(j)) lista.remove(j);
				j++;
			}
		}
	}
	
	

}
