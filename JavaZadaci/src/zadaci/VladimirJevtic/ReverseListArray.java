package zadaci.VladimirJevtic;
import java.util.*;

public class ReverseListArray {
	
	public static void Rev(int array[]) {
		
		for (int i=0; i< array.length; i++) {
		int pomocniClan= array[i];
		array[i] = array[array.length - i - 1];
		array[array.length - i - 1] = pomocniClan;
		
	     
		
		}
		
	}	
	
	public static void ispisiNiz(int array[]) {
		for (int i=0; i< array.length; i++) {
			System.out.print(array[i]);
			
		}
		System.out.println();
	}
	
	public static void obrniListu (ArrayList<String> list) {
		
		for(int i = 0, j = list.size() - 1; i < j; i++) {
	        list.add(i, list.remove(j));
	        
		}
		
	}

	
	
	
	public static void main(String args[]) {
		
		int array[] = {1, 2, 3, 4, 5};
		
		
	   
	    ReverseListArray.ispisiNiz(array);
	
	    ReverseListArray.Rev(array);
	    
	    ReverseListArray.ispisiNiz(array);

	
		
		
		
		ArrayList<String> string = new ArrayList<String>();
		string.add("test 1");
		string.add("test 2");
		string.add("test 3");
		string.add("test 4");
		
		System.out.println(string);
		ReverseListArray.obrniListu(string);
		
//		Collections.reverse(string);
		
		System.out.println(string);
		
		
		
	}

}
