package zadaci.VladimirJevtic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UniqueList {

	public static void neUniqueClanovi(List<String> lista) {
		
		Set<String> pomocna = new HashSet<String>();
		List<String> krajnja = new ArrayList<String>();
			
		for (int i = 0; i< lista.size(); i++) {
		
			String p = lista.get(i);
			if (!pomocna.add(p)) {
				krajnja.add(p);
			}	
		}

		System.out.println(krajnja);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<String> lista = new ArrayList<String>();

		System.out.println(" Unesite koliko lista ima clanova: ");
		int clanovi = sc.nextInt();
	
		for (int i = 0; i < clanovi; i++) {
			System.out.println(" Ispisite " + (i+1) + " clan liste. ");
			lista.add(sc.next());
		}
		neUniqueClanovi(lista);
	}

}
