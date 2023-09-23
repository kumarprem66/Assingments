package com.day15;
import java.io.*;
import java.util.*;

public class ReadWriteCenter {

	private File file;
	private String contentToWrite;
	
	private String contentToAppend;
	private PrintWriter writer;
	
	public ReadWriteCenter(String fileName, String contentToWrite, String contentToAppend) throws FileNotFoundException {
		super();
		this.file = new File(fileName);
		this.contentToWrite = contentToWrite;
		this.contentToAppend = contentToAppend;
		this.writer = new PrintWriter(file);
	}
	
	public void writeToFile() {
			writer.write(contentToWrite+"\n");
			writer.flush();
		
	}
	
	public void appendToFile() {
			
			writer.append(contentToAppend);
			writer.flush();
			writer.close();

		
	}
	
	public List<Integer> getAnalysis() {
		
		List<Integer> list = new ArrayList<>();
		
		int digit = 0;
		int letter = 0;
		int specialSym = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			int i = br.read();
		
			while(i != -1) {
				char c = (char)i;
				if(Character.isDigit(c)) {
					
					 digit++;

				}else if(Character.isAlphabetic(c)) {
					
					letter++;
				}else if(!Character.isDigit(c) && !Character.isAlphabetic(c) && !Character.isWhitespace(c)){
					specialSym++;

				}
				
				i = br.read();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.add(digit);
		list.add(letter);
		list.add(specialSym);
		
		return list;
		
		
	}
	
}
