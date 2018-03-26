package zadaci.SekeresStefan;

import java.util.Scanner;

public class SumaVecaOd {
	
	public static void main(String[] args) {
		
		int [] sequnce = {1,9,3,4,5,2,7,8,6};
		
		System.out.println("Enter value: ");
		Scanner sc = new Scanner(System.in);
		
		int result = sc.nextInt();
		
		sumNumbers(sequnce, result);
	}
	
	public static void sumNumbers(int [] sequnce, int result) {
		int numberToAdd = 0;
		int sum = 0;
		boolean exist = false;
		
		for(int i = 0; i < sequnce.length; i++) {
			if(numberToAdd < 3) {
				numberToAdd++;
				sum +=sequnce[i];
			}else {
				if(sum > result) {
					exist = true;
					System.out.println(""+sequnce[i-3]+"+"+sequnce[i-2]+"+"+sequnce[i-1]+"> "+result);
				}
				sum = 0;
				numberToAdd = 0;
				i = i - 2;
			}
		}
		
		if(sum > result) {
			exist = true;
			System.out.println(""+sequnce[sequnce.length - 3]+"+"+sequnce[sequnce.length - 2]+"+"+sequnce[sequnce.length - 1]+"> "+result);
		}
		
		if(!exist) System.out.println("There is no 3 numbers > "+result);
		
	}

}
