package zadaci.rajkoJegdic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoUniqList {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		List<String> lista = new ArrayList<>();
		
		System.out.println("Unesite broj elemenata liste!");
		int n = scanner.nextInt();
		
		for(int i = 0; i < n + 1 ; i++) {  //Dodao sam +1 jer zbog nextLine uzima jedan red tj string manje
			lista.add(scanner.nextLine());
		}
		
		lista = noUniqElement(lista);
		
		System.out.println(lista);
		
		scanner.close();

	}

	private static List<String> noUniqElement(List<String> lista) {
		
		List<String> pomocnaLista = new ArrayList<>();
		
		for(int i = 0; i < lista.size(); i++) {
			if(pomocnaLista.contains(lista.get(i))) {
				pomocnaLista.add(lista.get(i));
			} else {
				for(int j = i + 1; j < lista.size(); j++) {
					if(lista.get(i).equals(lista.get(j))) {
						pomocnaLista.add(lista.get(i));
						break;
					}
				}
			}
		}
		
		return pomocnaLista;
	}

}
