package zadaci.Aleksandar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveUniqueElements {

	public static void main(String[] args) {
		
		List<String> lista = new ArrayList<String>();
		Set<String> hs = new HashSet<String>();
		List<String> listaDuplikata = new ArrayList<String>();
		
		lista.add("ana");
		lista.add("aca");
		lista.add("ana");
		lista.add("coa");
		lista.add("pera");
		lista.add("aca");
		lista.add("aki");
		lista.add("mika");
		
		
		for(int i = 0;i < lista.size();i++) {
			
			if(!hs.add(lista.get(i))) {
				
				listaDuplikata.add(lista.get(i));
			}
			
		}
		
		System.out.println(listaDuplikata);

	}

}
