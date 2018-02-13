package zadaci.Aleksandar;

import java.util.ArrayList;

public class Reverse 
{

	public static void main(String[] args) 
	{
		int []niz = {1,2,3,4,5};
		Reverse r = new Reverse();
		System.out.println("Niz pre obrtanja:");
		r.ispisiNiz(niz);
		System.out.println("Niz posle obrtanja:");
		r.obrniNiz(niz);
		r.ispisiNiz(niz);
		
		ArrayList<Integer> list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		
		System.out.println("Lista pre obrtanja" + list);
		r.obrniListu(list);
		System.out.println("Lista posle obrtanja" + list);
		
		/*r.head = new Node(1);
		r.head.sled = new Node(2);
		r.head.sled.sled = new Node(3);
		r.head.sled.sled.sled = new Node(4);
		r.head.sled.sled.sled.sled = new Node(5);
		
		System.out.println("Lista pre obrtanja: ");
		r.ispisiListu(head);
		/*head = r.obrniListu(head);
		System.out.println("");
		System.out.println("Lista posle obrtanja: ");
		r.ispisiListu(head);*/

	}
	
	public void obrniNiz(int []niz) 
	{
		for(int i = 0;i < niz.length / 2;i++) 
		{
			int pomocna = niz[i];
			niz[i] = niz[niz.length - i - 1];
			niz[niz.length - i - 1] = pomocna;
		}
	}
	
	public void ispisiNiz(int []niz) 
	{
		for(int i = 0;i < niz.length;i++)
		{
			System.out.print(niz[i] + " ");
		}
		System.out.println();
	}
	
	public void obrniListu(ArrayList<Integer> list) 
	{
		for(int i = 0;i < list.size() / 2;i++) 
		{
			int pomocna = list.get(i);
			list.set(i, list.get(list.size() - i - 1));
			list.set(list.size() - i - 1, pomocna);
		}
	}
	
	
	//Pokusao sam da napravim listu pa da je obrnem, al sam negde pogresio...
	
	
	/*static Node head;
	
	static class Node
	{
		int vrednost;
		Node sled;
		public Node(int v) 
		{
			v = vrednost;
			sled = null;
		}
	}
	
	public Node obrniListu(Node node) 
	{
		Node prethodni = null;
		Node trenutni = head;
		Node sledeci = null;
		while(trenutni != null) 
		{
			sledeci = trenutni.sled;
			trenutni.sled = prethodni;
			prethodni = trenutni;
			trenutni = sledeci;
		}
		node = prethodni;
		return node;
	}
	
	public void ispisiListu(Node node) 
	{
		while(node != null) 
		{
			System.out.print(node.vrednost + " ");
			node = node.sled;
		}
		System.out.println();
	}*/
	

}
