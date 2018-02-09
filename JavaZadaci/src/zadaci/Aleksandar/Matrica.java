package zadaci.Aleksandar;

import java.util.Scanner;

public class Matrica 
{

	private static Scanner sc;
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Ubaci broj redova ");
		int m = sc.nextInt();
		System.out.print("Ubaci broj kolona ");
		int n = sc.nextInt();
		int [][]mat = new int[m][n];
		int vrednost;
			
		for(int i = 0;i < m;i++) 
		{
			for(int j = 0;j < n;j ++) 
			{
				System.out.print("Ubaci element: "+"Pozicija: [" + i + "][" + j + "]");
				vrednost = sc.nextInt();
				mat[i][j] = vrednost;
				if(vrednost == 1) 
				{
					j = 0;
					
					while(j < n) 
					{
						mat[i][j] = vrednost;
						j++;
					}
				}
			}
			
		}
		
		for(int i = 0;i < m;i++) 
		{
			for(int j = 0;j < n;j ++) 
			{
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
