package zadaci.Aleksandar;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) 
	{
		String s = "a b c";
		String s1 = "c a b";
		
		System.out.println(jeAnagram(s, s1));

	}
	
	public static boolean jeAnagram (String prvi, String drugi) 
	{
		char [] rec1 = prvi.replaceAll("\\s", "").toCharArray();
		char [] rec2 = drugi.replaceAll("\\s", "").toCharArray();
		Arrays.sort(rec1);
		Arrays.sort(rec2);
		return Arrays.equals(rec1, rec2);
	}

}
