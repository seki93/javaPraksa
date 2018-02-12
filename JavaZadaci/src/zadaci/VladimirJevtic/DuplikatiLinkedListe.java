package zadaci.VladimirJevtic;

import java.util.*;

public class DuplikatiLinkedListe {

	public static void printList(LinkedList<Integer> lista) {
		
      for (int a: lista) {
    	  System.out.println(a);
      }
	}
	public static void eraseDuplicates (LinkedList<Integer> lista) {
		
		for (int i=0; i < lista.size(); i++) {
			for (int j=i+1; j < lista.size(); j++) {
				if (lista.get(i).equals(lista.get(j))) {
					lista.remove(j);
				}
				
			}
		}
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		lista.addLast(3);
		lista.addLast(4);
		lista.addLast(5);
		lista.addLast(5);
		
	   
       eraseDuplicates(lista);
       printList(lista);
		
		

//      static Node head;
//	public static class Node {  
//	    public int data;  
//	    public Node next;  
//
//	    public Node(int data) {  
//	        this.data = data;    
//	    }  
//	}
	
	
	
	/*public static void briseDuplikate (Node lista){     - zasto ovo ne radi?
		Hashtable table = new Hashtable();
		Node previous = null; 
		while (lista != null) {
			if (table.containsKey(lista.data)) {
				previous.next = lista.next;
			} else {
				table.put(lista.data, true);
				previous = lista;
				System.gc();
			}
			lista = lista.next;
		}
		
	} */
		
	//	Node head = new Node(lista.getLast());
		
		
	//	DuplikatiLinkedListe.briseDuplikate(head);
	//	System.out.println(lista);
          }

}
