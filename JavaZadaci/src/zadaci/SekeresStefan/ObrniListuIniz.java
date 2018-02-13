package zadaci.SekeresStefan;

import java.util.ArrayList;

public class ObrniListuIniz {
	
	
	public static void main(String[] args) {
		
		int [] sequnce = {1,2,3,4,5,6,7};
		ArrayList<String> arrayString = new ArrayList<String>();
		arrayString.add("A");
		arrayString.add("B");
		arrayString.add("C");
		arrayString.add("D");
		arrayString.add("E");
		arrayString.add("F");
		
		
		System.out.println(arrayString);
		revertString(arrayString);
		System.out.println(arrayString);
		
		printSequnce(sequnce);
		revertSequnce(sequnce);
		System.out.println('\n'+"After revert");
		printSequnce(sequnce);
	}
	
	public static void revertSequnce (int [] niz ) {
		for (int i = 0; i < niz.length/2; i++) {
			int tmp = niz[i];
			niz[i] = niz[niz.length-i-1];
			niz[niz.length-i-1] = tmp;
		}
	}
	
	public static void printSequnce(int  []niz ) {
		for (int i = 0; i < niz.length; i++) {
			System.out.print(" "+niz[i]);
		}
	}
	
	public static void revertString(ArrayList<String> arrayString) {
		for (int i = 0; i < arrayString.size()/2; i++) {
			String a = arrayString.get(i);
			arrayString.set(i, arrayString.get(arrayString.size()-i-1));
			arrayString.set(arrayString.size()-i-1, a);
		}
	}

}
