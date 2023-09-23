package com.day15;
import java.io.*;


public class FileWrite {

	public static void main(String[] args) {
		
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File("abc.txt"));
			writer.write("1234567890"+"\n");
			writer.write("2234567890"+"\n");
			writer.write("3234567890"+"\n");
			writer.write("4234567890"+"\n");
			writer.write("5234567890"+"\n");
			writer.write("6234567890"+"\n");
			writer.write("7234567890"+"\n");
			writer.write("8234567890"+"\n");
			writer.write("9234567890"+"\n");
			writer.write("0234567890"+"\n");
			writer.flush();
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("abc.txt"));
			String s = reader.readLine();
			writer = new PrintWriter(new File("abcd.txt"));
			while(s != null) {
				if(s.startsWith("6") || s.startsWith("7") || s.startsWith("8") || s.startsWith("9")) {
					writer.write(s+"\n");
				}
				System.out.println(s);
				s = reader.readLine();
				
			}
			writer.flush(); 
			writer.close();
			System.out.println("filtered number.............");
			BufferedReader reader1 = new BufferedReader(new FileReader("abcd.txt"));
			String s1 = reader1.readLine();
			while(s1 != null) {
				System.out.println(s1);
				s1 = reader1.readLine();
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
