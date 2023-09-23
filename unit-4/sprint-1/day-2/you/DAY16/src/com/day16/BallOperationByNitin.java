package com.day16;

import java.io.*;
import java.util.*;
 

public class BallOperationByNitin {
	
	
	
	static void recordScores(List<BallOfOver> scoreList, Scanner sc) {
		
	
		Map<String,List<BallOfOver>> map = new HashMap<>();

		for(int i=0;i<2;i++) {
			if(i==0) {
				System.out.println("Enter ball by ball score for Team-A");
			}else {
				System.out.println("Enter ball by ball score for Team-B");
			}
			int ballCount = 0;
			List<BallOfOver> scorel = new ArrayList<>();
			while(ballCount<6) {
				System.out.println("Enter run scored on this ball ");
				int runsScored = sc.nextInt();
				System.out.println("It is a valid ball (y/n)");
				String yesOrNo = sc.next();
				
				if(yesOrNo.equalsIgnoreCase("y")) {
					
					ballCount++; // counting the number of ball
				} 
				
				scorel.add(new BallOfOver(runsScored,yesOrNo.charAt(0)));
				
			}
			
			if(i==0) {
				map.put("Nitin", scorel);
				
			}else {
				map.put("Ryan", scorel);
			}

			
		}
		System.out.println("Match completed wait for result..........");

		try {
			saveScores(map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	static void saveScores(Map<String,List<BallOfOver>> over) throws FileNotFoundException, IOException{
			
			ObjectOutputStream out = new 
					ObjectOutputStream(new FileOutputStream("score.ser"));
			
			out.writeObject(over);
			out.flush();
			out.close();
			
		}

}
