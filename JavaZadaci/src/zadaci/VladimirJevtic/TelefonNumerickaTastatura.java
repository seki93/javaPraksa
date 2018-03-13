package zadaci.VladimirJevtic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class TelefonNumerickaTastatura {

	public static String izbaciSlovo(int a) {

		HashMap<Character, Integer> mapa = new HashMap<>();
		mapa.put('0', 0 );
		mapa.put('A', 2);
		mapa.put('B', 22);
		mapa.put('C', 222);
		mapa.put('D', 3);
		mapa.put('E', 33);
		mapa.put('F', 333);
		mapa.put('G', 4);
		mapa.put('H', 44);
		mapa.put('I', 444);
		mapa.put('J', 5);
		mapa.put('K', 55);
		mapa.put('L', 555);
		mapa.put('M', 6);
		mapa.put('N', 66);
		mapa.put('O', 666);
		mapa.put('P', 7);
		mapa.put('Q', 77);
		mapa.put('R', 777);
		mapa.put('S', 7777);
		mapa.put('T', 8);
		mapa.put('U', 88);
		mapa.put('V', 888);
		mapa.put('W', 9);
		mapa.put('X', 99);
		mapa.put('Y', 999);
		mapa.put('Z', 9999);
	
			String str = new String();

			for (Entry<Character, Integer> entry : mapa.entrySet()) {
	            if (entry.getValue().equals(a)) {
	                //System.out.println(entry.getKey());
	            	str = entry.getKey().toString();
	            }
		 }
		 return str;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Unesite koliko cifara ima vasa sifra: " );
		int duzina = sc.nextInt();
		List<String> listaSlova = new ArrayList<>();
		
		for (int j = 0; j < duzina; j++) {
			System.out.println("Unesite brojeve " + j + " cifre ");
			int sifra = sc.nextInt();
			listaSlova.add(izbaciSlovo(sifra));
		}
		
		System.out.println(" Sifra u slovima je : " );
		System.out.println(listaSlova);
		
	
	}

}
