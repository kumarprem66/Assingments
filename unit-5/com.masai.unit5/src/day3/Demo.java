package day3;

import java.util.*;



public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Student> list = new ArrayList<>();
		list.add(new Student(1,"prem",34));
		list.add(new Student(2,"amar",45));
		list.add(new Student(3,"kumar",34));
		list.add(new Student(4,"kunal",10));
		list.add(new Student(5,"naushad",16));
		list.add(new Student(6,"gaurav",37));
		
		try {
			System.out.println(StudentOperation.getOutStandingStudentCount(list));
		} catch (NoStudentPassedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
