package zadaci.SekeresStefan;

import java.util.ArrayList;

public class SabiranjeBrojeva {
	
	public static void main(String[] args) {
		
		
		
		retrunResult(1234, 356);
	}
	
	public static void retrunResult(int a, int b) {
		
		ArrayList<Integer> number1 = new ArrayList<Integer>();
		ArrayList<Integer> number2 = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while(true) {
			number1.add(a%10);
			a/=10;
			
			if(a == 0) break;
		}
		
		System.out.println("Frist list: "+number1);
		
		while(true) {
			number2.add(b%10);
			b/=10;
			
			if(b == 0) break;
		}
		System.out.println("Second list: "+number2);
		
		int n1 = 0, n2 = 0, r = 0;
		
		for(int i = number1.size() - 1; i >= 0; i--) {
			n1 = n1 *10 + number1.get(i);
		}
		System.out.println("First number: "+n1);
		
		for(int i = number2.size() - 1 ; i >= 0; i--) {
			n2 = n2 * 10 + number2.get(i);
		}
		System.out.println("Second number: "+n2);
		
		r = n1 + n2;
		System.out.println("Result: "+r);
		
		while(true) {
			result.add(r%10);
			r/=10;
			
			if(r == 0) break;
		}
		System.out.println("Result list: "+result);
		
	}

}
