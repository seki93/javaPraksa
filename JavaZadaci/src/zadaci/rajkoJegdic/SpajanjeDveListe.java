package zadaci.rajkoJegdic;

import java.util.LinkedList;

public class SpajanjeDveListe {

	public static void main(String[] args) {
		
		LinkedList<Integer> listaA = new LinkedList<>();
		listaA.add(1);
		listaA.add(3);
		listaA.add(5);
		listaA.add(7);
		listaA.add(9);
		listaA.add(11);
		listaA.add(13);
		listaA.add(15);
		
		LinkedList<Integer> listaB = new LinkedList<>();
		listaB.add(2);
		listaB.add(4);
		listaB.add(6);
		listaB.add(8);
		listaB.add(10);
		listaB.add(12);
		listaB.add(14);
		listaB.add(16);
		
		LinkedList<Integer> listaC = new LinkedList<>();
		listaC = spojiDveListe(listaA, listaB);
		
		System.out.println(listaC);
		

	}

	private static LinkedList<Integer> spojiDveListe(LinkedList<Integer> listaA, LinkedList<Integer> listaB) {
		LinkedList<Integer> listaC = new LinkedList<>();
		
		int i = 0, j = 0;
		while(i < listaA.size() && j < listaB.size()) {
			if(listaA.get(i) < listaB.get(j)) {
				listaC.add(listaA.get(i));
				i++;
			} else {
				listaC.add(listaB.get(j));
				j++;
			}
		}
		
		if(i == listaA.size()-1) {
			while(j < listaB.size()) {
				listaC.add(listaB.get(j));
				j++;
			}
		}
		
		if(j == listaB.size()-1) {
			while(i < listaA.size()) {
				listaC.add(listaA.get(i));
				i++;
			}
		}
		
		return listaC;
	}

}
