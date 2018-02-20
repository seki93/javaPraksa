package zadaci.VladimirJevtic;

import java.util.*;

import zadaci.Aleksandar.LinkedLista;



public class DveSortedListe {
	
	  public static void merge (List<Integer> lista1, List<Integer> lista2) {

		  for (int i = 0, j = 0; j < lista2.size(); i++) {
		            if ( i == lista1.size() || lista1.get(i) > lista2.get(j) )
		  {
		           lista1.add(i, lista2.get(j++));

		  }
		            }
		 
	  }

	  public static void main(String[] args) 
		{
		  
		  List<Integer> l1 = new ArrayList<Integer>();
		  
		  l1.add(1);
		  l1.add(2);
		  l1.add(3);
		  l1.add(4);
		  l1.add(5);
		  l1.add(6);
		  
		  List<Integer> l2 = new ArrayList<Integer>();
		  l2.add(5);
		  l2.add(6);
		  l2.add(7);
		  l2.add(8);
		  l2.add(9);
		  l2.add(10);
		  
		  DveSortedListe.merge(l1, l2);
		  System.out.println(l1);
		  
		}		
    
}