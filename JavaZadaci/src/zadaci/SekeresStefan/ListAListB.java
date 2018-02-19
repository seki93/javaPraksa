package zadaci.SekeresStefan;

import java.awt.List;
import java.util.ArrayList;

public class ListAListB {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> listA = new ArrayList<Integer>();
		ArrayList<Integer> listB = new ArrayList<Integer>();
		ArrayList<Integer> merged = new ArrayList<Integer>();
		
		
		listA.add(2);
		listA.add(3);
		listA.add(4);
		
		listB.add(1);
		listB.add(1);
		listB.add(1);
		
		System.out.println("List A: "+listA);
		System.out.println("List B: "+listB);
	
		mergeList(listA, listB, merged);
		System.out.println("Merged: "+merged);
	
		
		
	}
	
	public static void mergeList(ArrayList<Integer> listA, ArrayList<Integer> listB, ArrayList<Integer> merged) {
		int i = 0,j  = 0 ;
		
		while(i < listA.size() && j < listB.size()) {
			if(listA.get(i) < listB.get(j)) {
				merged.add(listA.get(i));
				i++;
			}else {
				merged.add(listB.get(j));
				j++;
			}
		}
		
		while( i < listA.size()) {
			merged.add(listA.get(i));
			i++;
		}
		
		while(j < listB.size()) {
			merged.add(listB.get(j));
			j++;
		}
	}

}
