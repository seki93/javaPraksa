package zadaci.Aleksandar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagram {

	public static void main(String[] args) {
		
		ArrayList<String> anagramLista = new ArrayList<String>();
		anagramLista.add("qwert");
		anagramLista.add("yuiop");
		anagramLista.add("asdfg");
		anagramLista.add("jhgte");
		anagramLista.add("lkmnb");
		anagramLista.add("zxcvb");
		anagramLista.add("trewq");
		anagramLista.add("poiuy");
		anagramLista.add("gfdsa");
		
		
		System.out.println(StringAnagram.nizAnagrama(anagramLista));

	}
	
	public static boolean anagram (String prvi, String drugi) {
		char [] rec1 = prvi.toCharArray();
		char [] rec2 = drugi.toCharArray();
		Arrays.sort(rec1);
		Arrays.sort(rec2);
		return Arrays.equals(rec1, rec2);
	}
	
	public static List<String> nizAnagrama(ArrayList<String> anagramLista) {
		
		List<String> lista = new ArrayList<>();
		for(int i = 0;i < anagramLista.size();i++) {
			
			lista.add(anagramLista.get(i));
			
			for(int j = i + 1;j < anagramLista.size();j++) {
				
				if(anagram(anagramLista.get(i), anagramLista.get(j))) {
					
					lista.add(anagramLista.get(j));
					anagramLista.remove(j);
				}
			}
		}
		return lista;
	}
	

}
