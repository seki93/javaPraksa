package zadaci.SekeresStefan;


import java.util.ArrayList;
import java.util.Scanner;

public class OldPhone {
	
	private static Scanner sc;
	
	public static void main(String[] args) {
		
		System.out.println("Enter sequence: ");
		sc = new Scanner(System.in);
		
		String seq = sc.nextLine();
		
		String[] letters = seq.split(";");
		for(String letter: letters) {
			System.out.println(letter);
		}
		
		makeSentence(letters);
		
	}
	
	public static void makeSentence(String[] letters) {
		ArrayList<Character> finalSting = new ArrayList<>();
		
		for(int i = 0; i < letters.length; i++) {
			int result = Integer.parseInt(letters[i]);
			int number = makeNumber(result);
			
			if(letters[i].contains("2")) {
				if(number %3 == 1) finalSting.add('a');
				if(number %3 == 2) finalSting.add('b');
				if(number %3 == 0) finalSting.add('c');
			}else if(letters[i].contains("3")) {
				if(number %3 == 1) finalSting.add('d');
				if(number %3 == 2) finalSting.add('e');
				if(number %3 == 0) finalSting.add('f');
			}else if(letters[i].contains("4")) {
				if(number %3 == 1) finalSting.add('g');
				if(number %3 == 2) finalSting.add('h');
				if(number %3 == 0) finalSting.add('i');
			}else if(letters[i].contains("5")) {
				if(number %3 == 1) finalSting.add('j');
				if(number %3 == 2) finalSting.add('k');
				if(number %3 == 0) finalSting.add('l');
			}else if(letters[i].contains("6")) {
				if(number %3 == 1) finalSting.add('m');
				if(number %3 == 2) finalSting.add('n');
				if(number %3 == 0) finalSting.add('o');
			}else if(letters[i].contains("7")) {
				if(number %4 == 1) finalSting.add('p');
				if(number %4 == 2) finalSting.add('q');
				if(number %4 == 3) finalSting.add('r');
				if(number %4 == 0) finalSting.add('s');
			}else if(letters[i].contains("8")) {
				if(number %3 == 1) finalSting.add('t');
				if(number %3 == 2) finalSting.add('u');
				if(number %3 == 0) finalSting.add('v');
			}else if(letters[i].contains("9")) {
				if(number %4 == 1) finalSting.add('w');
				if(number %4 == 2) finalSting.add('x');
				if(number %4 == 3) finalSting.add('y');
				if(number %4 == 0) finalSting.add('z');
			}else {
				finalSting.add(' ');
			}
		}
		
		System.out.println(finalSting);
	}
	
	public static int makeNumber(int a) {
		
		int numberOfType = 0;
		
		while(a%10 != 0) {
			a/=10;
			numberOfType++;
		}
		
		return numberOfType;
	}

}
