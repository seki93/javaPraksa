package zadaci.VladimirJevtic;

import java.util.*;
import java.util.ArrayList;

public class StringAnagram {

	
	public static boolean isAnagram(String string1, String string2){
	    int[] brojSlova = new int[26];
	    for(int i = 0; i < string1.length(); i++){
	        brojSlova[string1.charAt(i)]++;
	    }
	    for(int i = 0; i< string2.length(); i++){
	    	brojSlova[string2.charAt(i)]--;
	    }
	    for(int i = 0; i<brojSlova.length; i++){
	        if(brojSlova[i] != 0) return false;
	    }
	    return true;
	}
	
	
	public static List<String> nizAnagrama(ArrayList<String> listaAnagrama){
		
		List<String> lista = new ArrayList<>();
		
		for (int i=0; i < listaAnagrama.size(); i++) {
			lista.add(listaAnagrama.get(i));
			
			for (int j=i+1; j< listaAnagrama.size(); j++) {
				
				if (isAnagram(listaAnagrama.get(i), listaAnagrama.get(j))) {
					
					lista.add(listaAnagrama.get(j));
					listaAnagrama.remove(j);
				}
			}
			
		}
		return lista;
	}

	
	
	
	public static void main(String[] args) {
		
		ArrayList<String> listaAnagrama = new ArrayList<String>();
		
		listaAnagrama.add("asdgsdgds");
		listaAnagrama.add("asdas");
		listaAnagrama.add("hdfhdf");
		listaAnagrama.add("tqew");
		listaAnagrama.add("judfh");
		listaAnagrama.add("asdas");
		
		System.out.println(StringAnagram.nizAnagrama(listaAnagrama));
}




}
