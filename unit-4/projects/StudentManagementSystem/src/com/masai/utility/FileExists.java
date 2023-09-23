package com.masai.utility;
import java.util.*;
import java.io.*;

import com.masai.project.entities.*;
public class FileExists {

	
	public static Map<Integer,Course> courseFile(){
		
		Map<Integer,Course> cFile = null;
		
		File f = new File("course.ser");
		boolean flag = false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag = true;
			}
			
			if(flag) {
				cFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(cFile);
				oos.flush();
				return cFile;
			}else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				cFile = (Map<Integer,Course>) ois.readObject();
				
				return cFile;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cFile;
	}
	
	
	public static Map<String,Student> studentFile(){
		
		Map<String,Student> sFile = null;
		
		File f = new File("student.ser");
		boolean flag = false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag = true;
			}
			
			if(flag) {
				sFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(sFile);
				oos.flush();
				return sFile;
			}else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				sFile = (Map<String,Student>) ois.readObject();
				return sFile;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return sFile;
	}
	
	
	
public static Map<Integer,Batch> batchFile(){
		
		Map<Integer,Batch> bFile = null;
		
		File f = new File("batch.ser");
		boolean flag = false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag = true;
			}
			
			if(flag) {
				bFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(bFile);
				oos.flush();
				return bFile;
			}else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				bFile = (Map<Integer,Batch>) ois.readObject();
				return bFile;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return bFile;
	}
	
	
	
	
}




















