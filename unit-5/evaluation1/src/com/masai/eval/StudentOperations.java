package com.masai.eval;

import java.util.List;

public class StudentOperations {

	
	static String getStudentWithMaximumMarks(List<Student> studentList) {
		
		
		double max = Double.MIN_VALUE;
		String name = "";
		for(int i=0;i<studentList.size();i++) {
			if(studentList.get(i).getMarks()> max) {
				max = studentList.get(i).getMarks();
				name = studentList.get(i).getName();
			}
		}
		return name;
	}
}


@FunctionalInterface
interface firstin{
	
	Student getObj(int roll,String name,String subject,double marks);
	
}

@FunctionalInterface
interface secondin{
	
	String getDetail();
	
}

@FunctionalInterface
interface thirdin{
	
	String getmax();
	
}


