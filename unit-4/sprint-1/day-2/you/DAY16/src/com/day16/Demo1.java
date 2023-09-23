package com.day16;

import java.io.*;
import java.util.*;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s1 = new Student(10,"Prem",400,"12345",new Address("BIhar","patna",804422));
		Student s2 = new Student(12,"Naushad",500,"83833",new Address("mp","bhopal",343434));
		Student s3 = new Student(13,"Gaurav",660,"34343",new Address("jharkhand","chattisgarh",24424));
		Student s4 = new Student(15,"Kumal",445,"98989",new Address("karnataka","bengaluru",478374));
		Student s5 = new Student(16,"Shubham",600,"37777",new Address("rajsthan","jaipur",373823));
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file2.ser"));
			
			List<Student> list = new ArrayList<>();
			list.add(s1);
			list.add(s2);
			list.add(s3);
			list.add(s4);
			list.add(s5);

			out.writeObject(list);
			out.flush();
			out.close();
			
			System.out.println("Serialised...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
