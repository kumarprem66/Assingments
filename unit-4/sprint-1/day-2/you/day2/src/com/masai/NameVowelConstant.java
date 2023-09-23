package com.masai;

public class NameVowelConstant {
	
	
	
	static int getVowelCount(String name) {

		int count = 0;
		
		for(int i=0;i<name.length();i++) {
			
			char s = name.charAt(i);
			
			if(s=='a' || s=='e' || s=='i' || s=='o' || s=='u') {
				count++;
			}
			
		
		}
		
		return count;
		
	  }
	  public static void main(String[] args) {
	    System.out.println("Total vowel in Rajesh is " + getVowelCount("Rajesh"));
	    System.out.println("Total vowel in Yogita is " + getVowelCount("Yogita"));
		  
		
	  }

}
