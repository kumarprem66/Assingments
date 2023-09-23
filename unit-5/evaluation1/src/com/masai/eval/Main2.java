package com.masai.eval;

import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main2 {

	
public static void main(String[] args) {
		
//		problem 1 /////////////////
		
		List<Integer> inlist = Arrays.asList(1,-2,3,4,-5,6);
		List<Double> dlist = Arrays.asList(1.1,-2.3,-3.4,4.2,-5.0,6.0);
		
		List<? super Number> list = new ArrayList<>();
		findNegativeOnly(inlist,dlist,list);
		System.out.println();
		
		
		
		
//		///////preobem 2 /////
		
		StuInter st = (detail)->{
			
			String[] s = detail.split(",");
			Student stu = new Student(Integer.valueOf(s[0]),s[1],s[2],Double.valueOf(s[3]));
			return stu;
		};
		
	
		Student s1 = st.givedetail("1,prem,math,64");
		Student s2 = st.givedetail("1,kumar,math,54");
		Student s3 = st.givedetail("1,kunal,science,74");
		Student s4 = st.givedetail("1,naushed,math,94");
		Student s5 = st.givedetail("1,amar,py=hysics,34");
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		
		Consumer<Student> c = t -> {
				
				System.out.println(t.getName() +" has scored "+t.getMarks() +" in "+t.getSubject());
				
			};
			
		students.forEach(c);
		
		
		Predicate<Student> p = t-> t.getMarks()>90;
		Consumer<Student> c2 = t -> {
			
			
			System.out.println(p.test(t));
			
		};
		students.forEach(c2);
		
		
		Supplier<Integer> supplier = ()->(int) Math.random()*5;
		
		int index = supplier.get();
		System.out.println(students.get(index));
		
		
//		Function<List<Student>,HashMap<String,String>> fun = new Function<List<Student>,HashMap<String,String>>(){
//
//			@Override
//			public HashMap<String, String> apply(List<Student> t) {
//				// TODO Auto-generated method stub
//				HashMap<String,String> map = new HashMap<>();
//				
//				for(int i=0;i<t.size();i++) {
//					map.put(t.get(i).getSubject(), t.get(i).getName());
//				}
//				return map;
//			}
//			
//		};
//			
//		
//		HashMap<String, String> map = fun.apply(students);
			
	
		
		
		
		
	
			
			
		
			
		

	}
	
	public static void findNegativeOnly(List<Integer> inlist,List<Double> dlist,List<? super Number> list) {
		
		List<? super Number> flist = list;
		for(int i=0;i<inlist.size();i++) {
			if(inlist.get(i)<0) {
				flist.add(inlist.get(i));
			}
		}
		for(int i=0;i<inlist.size();i++) {
			if(dlist.get(i)<0) {
				flist.add(dlist.get(i));
			}
		}
		

			
	System.out.print("The Negative elements are : "+flist);
			

		
		
	}

}
