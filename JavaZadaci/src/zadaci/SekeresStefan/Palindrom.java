package zadaci.SekeresStefan;

public class Palindrom {
	
	public static void main(String[] args) {
		
		String palindrom = "ana voli milovana";
		
		System.out.println("Palindrom: "+pali(palindrom));
		
	}
	
	public static boolean pali(String niz) {
		int i,j;

		String bezRazmaka = niz.replaceAll("\\s", "");
		
		j = bezRazmaka.length()-1;
		i = 0;
		
		while(i != j) {
			
			if(bezRazmaka.charAt(i) != bezRazmaka.charAt(j)) return false;
			i++;
			j--;
			
		}
		
		
		return true;
	}

}
