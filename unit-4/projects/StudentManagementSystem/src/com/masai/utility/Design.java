package com.masai.utility;

public class Design {

	
	public static void design(String s) {
		
		int count = 0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<140;j++) {
				if(i==0 || i==4) {
					if((i==0 && j==0)  || (i==0 && j==139) || (i==4 && j==0) || (i==4 && j==139)) {
						System.out.print("#");
					}else {
						System.out.print("*");
					}
					
				}else if(i==2){
				
					if(j==0 || j==139) {
						System.out.print("*");
					}else {
						if(count<s.length() && j>((140-s.length())/2)) {
							System.out.print(s.charAt(count));
							count++;
						}else {
							System.out.print(" ");
						}
						
					}
					
				}else {
					if(j==0 || j==139) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}

				
			}
			System.out.println();
		}
	}

}
