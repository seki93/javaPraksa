package zadaci.SekeresStefan;

import java.awt.List;
import java.util.ArrayList;

public class ListAListB {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> listA = new ArrayList<Integer>();
		ArrayList<Integer> listB = new ArrayList<Integer>();
		ArrayList<Integer> merged = new ArrayList<Integer>();
		
		
		listA.add(1);
		listA.add(3);
		listA.add(5);
		
		listB.add(1);
		listB.add(5);
		listB.add(6);
		
		System.out.println("List A: "+listA);
		System.out.println("List B: "+listB);
	
		mergeList(listA, listB, merged);
		System.out.println("Merged: "+merged);
	
		
		
	}
	
	public static void mergeList(ArrayList<Integer> listA, ArrayList<Integer> listB, ArrayList<Integer> merged) {
		int j  = 0 ;
		int tmpA = listA.get(0);
		int tmpB = listB.get(0);
		for(int i = 0; i < listA.size(); i++) {
			while( j < listB.size()) {
				if (listA.get(i) <= listB.get(j)) {
					tmpA = listA.get(i);
					tmpB = listB.get(j);
					break;
				}
				else {
					tmpB = listB.get(j);
				}
				j++;
			}
			if(tmpA > tmpB ) {
				merged.add(tmpB);
				merged.add(tmpA);
			}else if( tmpA == tmpB) {
				merged.add(tmpB);
				merged.add(tmpA);
			}else{
				merged.add(tmpA);
				merged.add(tmpB);
			}
			j = i + 1;
		}
	}

}
