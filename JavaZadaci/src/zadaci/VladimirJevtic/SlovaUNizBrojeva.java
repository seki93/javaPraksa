package zadaci.VladimirJevtic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class SlovaUNizBrojeva {

	public static String slovaUBrojeve(String s) {

		String pom = "";
		
		HashMap<String, String> mapa = new HashMap<>();
		
		mapa.put("0", "0" );
		mapa.put("A", "2");
		mapa.put("B", "22");
		mapa.put("C", "222");
		mapa.put("D", "3");
		mapa.put("E", "33");
		mapa.put("F", "333");
		mapa.put("G", "4");
		mapa.put("H", "44");
		mapa.put("I", "444");
		mapa.put("J", "5");
		mapa.put("K", "55");
		mapa.put("L", "555");
		mapa.put("M", "6");
		mapa.put("N", "66");
		mapa.put("O", "666");
		mapa.put("P", "7");
		mapa.put("Q", "77");
		mapa.put("R", "777");
		mapa.put("S", "7777");
		mapa.put("T", "8");
		mapa.put("U", "88");
		mapa.put("V", "888");
		mapa.put("W", "9");
		mapa.put("X", "99");
		mapa.put("Y", "999");
		mapa.put("Z", "9999");
		
		for (int i = 0; i < s.length(); i++) {
			String str = String.valueOf(s.toUpperCase().charAt(i));
			if (mapa.containsKey(str)) {
				pom = pom + mapa.get(str)+ ", ";
				}
			}
		
		return pom;
	}
	
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Unesite vasu recenicu: " );
		
		String s = sc.nextLine();
		
		String ispis = slovaUBrojeve(s);
		
		System.out.println(ispis);	
		
		}
		
		
	}	
