package zadaci.VladimirJevtic;

public class Palindrom {
	
	public static boolean jestePalindrom(String testString) {
		int n = testString.length();
		
		for ( int i = 0; i < n/2; i++) {
			if (testString.charAt(i) != testString.charAt(n-i-1)) 
				return false;
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		String testString = "ana voli milovana";
		testString = testString.replaceAll("\\s","" );
				
		if ( Palindrom.jestePalindrom(testString) == true) {
			System.out.print(" Jeste Palindrom ");
		}
		else {
			System.out.println(" Nije Palindrom ");
		}
		
	}
	
		
	}
	
	
	
	


