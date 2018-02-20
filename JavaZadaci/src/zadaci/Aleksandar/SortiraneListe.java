package zadaci.Aleksandar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortiraneListe {

	public static void main(String[] args) {
		
		List<Integer> lista1 = new ArrayList<Integer>();
		lista1.add(1);
		lista1.add(3);
		lista1.add(5);
		lista1.add(7);
		lista1.add(9);
		
		List<Integer> lista2 = new ArrayList<Integer>();
		lista2.add(2);
		lista2.add(4);
		lista2.add(6);
		lista2.add(8);
		lista2.add(10);
		
		
		spojiDveListe(lista1, lista2);
		
		System.out.println(lista1);
		
	}
	
	    /*public static List<Integer> merge(List<Integer> lista1, List<Integer> lista2) {
	    	

	        List<Integer> rezultat = new ArrayList<Integer>(lista1.size() + lista2.size());
	        rezultat.addAll(lista1);
	        rezultat.addAll(lista2);

	        Collections.sort(rezultat);

	        return rezultat;
	    }*/
	    
	public static void spojiDveListe(List<Integer> lista1, List<Integer> lista2) {
		
		 for(int i = 0, j = 0; j < lista2.size();i++) {
			 
			 if(i == lista1.size() || lista1.get(i) > lista2.get(j)){
				 
				 lista1.add(i, lista2.get(j++));
			 }
		 }
	    
	}
}


