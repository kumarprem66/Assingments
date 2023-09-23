package com.day15;
import java.util.*;

import java.io.FileNotFoundException;

public class FileOperationsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "Originally formed in 1600 purely to trade with the Mughal Empire, the Company needed to secure its commercial posts at Calcutta, Bombay and Madras. It purchased land from Indian rulers to build its settlements on, and recruited native armed forces to protect them. Eventually, these evolved into the Bengal, Bombay and Madras Armies.";
		String ap = "After successfully battling the French for trading supremacy, and simultaneously involving itself in local politics, the Company became India’s leading power following Robert Clive’s victory at Plassey in 1757. In the years that followed, it expanded its Indian domains.";
		ReadWriteCenter rwc;
		try {
			rwc = new ReadWriteCenter("A.txt",s,ap);
			rwc.writeToFile();
			rwc.appendToFile();
			List<Integer> list = rwc.getAnalysis();
		
			System.out.println("Digit count : "+list.get(0));
			System.out.println("Letter count : "+list.get(1));
			System.out.println("Symbol count : "+list.get(2));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		

	}

}
