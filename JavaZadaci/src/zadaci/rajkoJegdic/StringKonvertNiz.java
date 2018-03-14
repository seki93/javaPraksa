package zadaci.rajkoJegdic;

import java.util.HashMap;
import java.util.Scanner;

public class StringKonvertNiz {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Unesite recenicu!");
		
		String recenica = scanner.nextLine();
		
		String niz = StringKonvertujNiz(recenica);

		System.out.println(niz);
		
		scanner.close();

	}

	private static String StringKonvertujNiz(String recenica) {
		
		String niz = "";
		HashMap<String, String> tastatura = new HashMap<>();
		tastatura.put("a", "2");
		tastatura.put("b", "22");
		tastatura.put("c", "222");
		tastatura.put("d", "3");
		tastatura.put("e", "33");
		tastatura.put("f", "333");
		tastatura.put("g", "4");
		tastatura.put("h", "44");
		tastatura.put("i", "444");
		tastatura.put("j", "5");
		tastatura.put("k", "55");
		tastatura.put("l", "555");
		tastatura.put("m", "6");
		tastatura.put("n", "66");
		tastatura.put("o", "666");
		tastatura.put("p", "7");
		tastatura.put("q", "77");
		tastatura.put("r", "777");
		tastatura.put("s", "777");
		tastatura.put("t", "8");
		tastatura.put("u", "88");
		tastatura.put("v", "888");
		tastatura.put("w", "9");
		tastatura.put("y", "99");
		tastatura.put("x", "999");
		tastatura.put("z", "999");
		tastatura.put(" ", "0");
				
		
		for(int i = 0; i < recenica.length(); i++) {
			String s = String.valueOf(recenica.charAt(i));
			if(tastatura.containsKey(s)) {
				niz = niz + tastatura.get(s) + ";";
			}
		}
		
		return niz;
	}
}
