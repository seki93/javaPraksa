package zadaci.Aleksandar;

import java.util.Scanner;

public class SekvencaSlova {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesi slova: ");
		
		String brojevi = sc.nextLine();
		
		for (int i = 0; i < brojevi.length(); i++) {
		
		   System.out.print(vratiBroj(brojevi.charAt(i)));
		
		}
		sc.close();

	}
	
	public static int vratiBroj(char karakter) {
		
		int broj = 0;
		
		if(karakter == 'a' || karakter == 'b' || karakter == 'c') {
			
			broj = 2;
		} else if((karakter == 'd' || karakter == 'e' || karakter == 'f')) {
			
			broj = 3;
		}
          else if((karakter == 'g' || karakter == 'h' || karakter == 'i')) {
			
			broj = 4;
		}
          else if((karakter == 'j' || karakter == 'k' || karakter == 'l')) {
	
	        broj = 5;
        }
          else if((karakter == 'm' || karakter == 'n' || karakter == '0')) {
  			
  			broj = 6;
  		}
          else if((karakter == 'p' || karakter == 'q' || karakter == 'r') || karakter == 's') {
  			
  			broj = 7;
  		}
          else if((karakter == 't' || karakter == 'u' || karakter == 'v')) {
  			
  			broj = 8;
  		}
          else if((karakter == 'w' || karakter == 'x' || karakter == 'y') || karakter == 'z') {
    			
    		broj = 9;
    	}
		
		return broj;
	}

}
