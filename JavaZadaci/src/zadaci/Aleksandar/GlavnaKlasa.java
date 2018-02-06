
public class GlavnaKlasa {

	public static void main(String[] args)
	{
		
		String dobarPrimer = "asadaffghdfa";
		String losPrimer  = "asdfghjk";
		
		
		System.out.println(imaDuplikate(dobarPrimer));
		System.out.println(imaDuplikate(losPrimer));
  		
	}
	
	public static boolean imaDuplikate(String str) 
	{
		for(int i = 0;i < str.length();i++) 
		{
			for(int j = i + 1;j < str.length();j++) 
			{
				if(str.charAt(i) == str.charAt(j))
				{
					return true;
				}
		    }
		}
		return false;
	}

}
