package com.day16;
import java.io.IOException;
import java.util.*;

public class StartMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<BallOfOver> runlist = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		BallOperationByNitin.recordScores(runlist, sc);
		
		
		try {
			Map<String,List<BallOfOver>> map = BallOperationByRyan.getScoreList();
			String s = BallOperationByRyan.findWinner(map);
			System.out.println(s);
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
