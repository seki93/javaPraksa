package zadaci.VladimirJevtic;
import java.util.*;
import java.io.*;

public class AnagramStringica {
	
	public static boolean isAnagram(String string1, String string2){
	    int[] brojSlova = new int[20];
	    for(int i = 0; i < string1.length(); i++){
	        brojSlova[string1.charAt(i)]++;
	    }
	    for(int i = 0; i< string2.length(); i++){
	    	brojSlova[string2.charAt(i)]--;
	    }
	    for(int i = 0; i<brojSlova.length; i++){
	        if(brojSlova[i] != 0) return false;
	    }
	    return true;
	}
	

	
	
	
	
	public static void main(String[] args) {
		
		String string1 = " abc def78";
		String string2  = "cefdba87";
		string1 = string1.replaceAll("\\s","" );
		string2 = string2.replaceAll("\\s","" );
		
		if (AnagramStringica.isAnagram(string1, string2) == true) {
			System.out.print(" Jeste Anagram ");
		}
		else {
			System.out.println( " Nije Anagram " );
		}
	}
	}
