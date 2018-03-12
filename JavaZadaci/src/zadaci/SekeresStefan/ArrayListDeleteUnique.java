package zadaci.SekeresStefan;

import java.util.ArrayList;

public class ArrayListDeleteUnique {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("1");
		list.add("x");
		list.add("b");
		list.add("b");
		list.add("a");
		list.add("c");
		list.add("c");
		list.add("a");
		list.add("2");
		list.add("1");
		list.add("c");
		list.add("4");
		list.add("5");
		list.add("5");
		list.add("4");
		list.add("4");
		
		System.out.println("List before method:");
		System.out.println(list);
		
		deleteUnq(list);
		//list = deleteUnique(list);
		System.out.println("After: ");
		System.out.println(list);
		
		
	}
	
	
	public static ArrayList<String> deleteUnique(ArrayList<String> list) {
		ArrayList<String> sec = new ArrayList<>();
		
		boolean exists = false;
		
		for( int i = 0; i < list.size(); i++) {
			int j = i + 1;
			
			while( j < list.size()) {
				if( list.get(i) == list.get(j)) {
					exists = true;
					sec.add(list.get(j));
					list.remove(j);
					j--;
				}
				j++;
			}
			
			if(exists) {
				sec.add(list.get(i));
			}
			
			exists = false;
		}
		
		return  sec;
	}
	
	public static void deleteUnq(ArrayList<String> list){
		
		boolean exists = false;
		
		int numberOfMovedSstring = 0;
		
		for(int i = 0; i < list.size(); i++){
			int j = i + 1;
			while( j < list.size()){
				if(list.get(i) == list.get(j)){
					exists = true;
					String tmp = list.get(j);
					list.remove(j);
					list.add(i+1,tmp);
					numberOfMovedSstring++;
				}
				j++;
			}
			
			if(!exists) {
				list.remove(i);
				i--;
			}else{
				i = i + numberOfMovedSstring;
			}
			exists = false;
			numberOfMovedSstring = 0;
		}
	}
}
