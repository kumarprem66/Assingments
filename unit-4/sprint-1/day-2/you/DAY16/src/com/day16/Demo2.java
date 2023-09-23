package com.day16;

import java.io.*;
import java.util.*;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ObjectInputStream ois = new
					ObjectInputStream(new FileInputStream("file2.ser"));
			Object obj = ois.readObject();
			
			List<Student> list = (List<Student>) obj;
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
