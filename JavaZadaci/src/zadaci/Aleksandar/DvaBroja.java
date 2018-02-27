package zadaci.Aleksandar;

import java.util.ArrayList;
import java.util.List;

public class DvaBroja {

	public static void main(String[] args) {
		
		
		saberiDvabroja(12345, 6789);

	}
	
	public static void saberiDvabroja(int broj1, int broj2) {
		
		List<Integer> lista1 = new ArrayList<Integer>();
		List<Integer> lista2 = new ArrayList<Integer>();
		List<Integer> rezultat = new ArrayList<Integer>();
		
		
		while(true) {
			lista1.add(broj1%10);
			broj1 /= 10;
			
			if(broj1 == 0) {
				break;
			}
		}
		
		while(true) {
			lista2.add(broj2%10);
			broj2 /= 10;
			
			if(broj2 == 0) {
				break;
			}
		}
		
        int b1 = 0, b2 = 0, rez = 0;
		
		for(int i = lista1.size() - 1; i >= 0; i--) {
			b1 = b1 *10 + lista1.get(i);
		}
		
		for(int i = lista2.size() - 1; i >= 0; i--) {
			b2 = b2 *10 + lista2.get(i);
		}
		
		rez = b1 + b2;
		
		while(true) {
			rezultat.add(rez%10);
			rez /= 10;
			
			if(rez == 0) {
				break;
			}
		}
		
		System.out.println(rezultat);
	}

}
