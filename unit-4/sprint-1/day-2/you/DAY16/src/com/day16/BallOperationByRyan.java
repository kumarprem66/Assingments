package com.day16;
import java.util.*;
import java.io.*;

public class BallOperationByRyan {

	
	static Map<String,List<BallOfOver>> getScoreList() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("score.ser"));
		Map<String,List<BallOfOver>> map = (Map<String,List<BallOfOver>>) ois.readObject();
		

		return map;
		
	}
	
	static String findWinner(Map<String, List<BallOfOver>> map) {
		
		Set<Map.Entry<String,List<BallOfOver>>> keyValue = map.entrySet();
		
		int sumA = 0;
		int sumB = 0;
		for(Map.Entry<String,List<BallOfOver>> b : keyValue) {
			
			List<BallOfOver> ListOfruns =  b.getValue();
			if(b.getKey().equalsIgnoreCase("Nitin")) {
				for(int i=0;i<ListOfruns.size();i++) {
					sumA += ListOfruns.get(i).getRuns();
				}
			}else {
				for(int i=0;i<ListOfruns.size();i++) {
					sumB += ListOfruns.get(i).getRuns();
				}
			}
			
			
		}

		int diff = Math.abs(sumA-sumB);;
		
		if(sumA>sumB) {
			return "Team-A won by "+diff+" runs";
		}else if(sumA==sumB){
			return "Match Tied Finally";
		}else {
			return "Team-B won by "+diff+" runs";
		}
		
		  
	}
}
