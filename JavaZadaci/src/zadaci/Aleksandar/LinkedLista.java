package zadaci.Aleksandar;

public class LinkedLista {

	public static void main(String[] args) 
	{
		LinkedLista lista = new LinkedLista();
		lista.head = new Node(6);
		lista.head.sledeci = new Node(5);
		lista.head.sledeci.sledeci = new Node(5);
		lista.head.sledeci.sledeci.sledeci = new Node(7);
		lista.head.sledeci.sledeci.sledeci.sledeci = new Node(7);
		lista.head.sledeci.sledeci.sledeci.sledeci.sledeci = new Node(8);
		lista.head.sledeci.sledeci.sledeci.sledeci.sledeci.sledeci = new Node(6);
		
		System.out.println("Lista pre brisanja duplikata: \n ");
		lista.stampajListu(head);
		lista.brisiDuplikate();
		System.out.println("");
		System.out.println("Lista posle brisanja duplikata: \n ");
		lista.stampajListu(head);

	}
	
	static Node head;
	
	static class Node
	{
		int broj;
		Node sledeci;
		public Node(int b) 
		{
			broj = b;
			sledeci = null;
		}
	}
	
	public void stampajListu(Node node) 
	{
		while(node != null) 
		{
			System.out.print(node.broj + " ");
			node = node.sledeci;
		}
		System.out.println();
	}
	
	public void brisiDuplikate() 
	{
		Node node1 = null;
		Node node2 = null;
		Node duplikat = null;
		node1 = head;
		while(node1 != null && node1.sledeci != null) 
		{
	       node2 = node1;
		   while(node2.sledeci != null) 
		   {
			  if(node1.broj == node2.sledeci.broj) 
			  {
				  duplikat = node2.sledeci;
				  node2.sledeci = node2.sledeci.sledeci;
				  System.gc();
			  }
			  else 
			  {
				  node2 = node2.sledeci;
			  }
		   }
		     node1 = node1.sledeci;
		}
	}

}
