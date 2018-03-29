package zadaci.SekeresStefan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.log4j.Logger;

public class MatricIspisVladaZadatak {
	
	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<>();
		//int sequnce[] = {1,3,5,4,7,5,2,6,8,4,1,6,4};
		
//		a.add(1);
//		a.add(3);
//		a.add(5);
//		a.add(4);
//		a.add(7);
//		a.add(5);
//		a.add(2);
//		a.add(6);
//		a.add(8);
		
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		
		printCikCak(a);
	}
	
	
	public static void printCikCak(ArrayList<Integer> sequnce) {
		
		Queue<Integer> q = new LinkedList<>();

		int pom[] = new int [sequnce.size()];
		int j = 0;

		
		for(int i = 0; i < sequnce.size() -1; i = i +2) {
			int a = sequnce.get(i);
			int b = sequnce.get(i+1);
			
			if(a > b) {
				q.add(a);
				q.add(b);
			}
			else {
				q.add(b);
				q.add(a);
			}
		}
		
		q.add(sequnce.get(sequnce.size()-1));

		System.out.println(q);
		
		for(int i = 0; q.size() > 0; i++) {
			pom[j++] = q.remove();
		}
		
		for(int i = 0; i < pom.length; i++) {
			System.out.print(" "+pom[i]);
		}
		
		
		
 }

}
