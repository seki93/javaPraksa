package zadaci.Aleksandar;

import java.util.Scanner;

public class SekvencaCifara {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesi cifre ");
		
		String s = sc.nextLine();
		
		String text = vratiString(s);
		
		System.out.println("Cifre su prevedene u " + text);
		
		sc.close();
		

	}
	
	public static String [] slova = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    private static char vratiKarakter(int broj, int brojac) {
    	
        while (brojac > slova[broj].length()) {
        	
            brojac = brojac - slova[broj].length();
        }

        return slova[broj].charAt(brojac - 1);
    }
    
    public static String vratiString(String s) {
    	
    	int poslednjiBroj = 0;
    	
    	int brojac = 1;
    	
    	String rezultat = "";
    	
    	for(int i = 0;i < s.length();i++) {
    		
    		int trenutniBroj = s.charAt(i) - '0';
    		
    		if(trenutniBroj >= 2 && trenutniBroj <= 9) {
    			
    			if(poslednjiBroj == 0) {
    				
    				poslednjiBroj = trenutniBroj;
    			} else if(trenutniBroj == poslednjiBroj) {
    				
    				brojac++;
    			} else {
    				
    				rezultat = rezultat + vratiKarakter(poslednjiBroj, brojac);
    				poslednjiBroj = trenutniBroj;
    				brojac = 1;
    			}
    		}
    	}
    	
    	return rezultat + vratiKarakter(poslednjiBroj, brojac);
    	
    }
}
