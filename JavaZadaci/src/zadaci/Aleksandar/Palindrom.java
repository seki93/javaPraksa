package zadaci.Aleksandar;

public class Palindrom {

	public static void main(String[] args) 
	{
		String s = "ana voli milovana";
		s = s.replaceAll("\\s", "");
		System.out.println(jePalindrom(s));

	}
	
	public static boolean jePalindrom(String str) 
	{
		int duzina = str.length();
		for(int i = 0; i < duzina/2; i++) 
		{
			if(str.charAt(i) != str.charAt(duzina - i - 1)) 
			{
				return false;
			}
		}
		return true;
	}


}
