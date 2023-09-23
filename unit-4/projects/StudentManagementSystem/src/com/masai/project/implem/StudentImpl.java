package com.masai.project.implem;



import java.util.List;
import java.util.Map;


import com.masai.project.interfaces.*;
import com.masai.utility.IDGeneration;
import com.masai.project.exception.*;

import com.masai.project.entities.*;


public class StudentImpl implements StudentInterface{
	


	@Override
	public void changeEmail(String oldEmail, String newEmail, List<Student> students)  throws WrongEmailException{
		// TODO Auto-generated method stub
		
		int temp = 0;
		for(int i=0;i<students.size();i++) {
			if(students.get(i).getEmail().equals(oldEmail)) {
				
				Student updateStu = students.get(i);
				updateStu.setEmail(newEmail);
				
				students.set(i, updateStu);
				break;
				
			}
		
		}
		
		if(temp==0) {
			throw new WrongEmailException("Invalid Email");
		}
	}


	@Override
	public void viewStudentDetails(String email, Map<String, Student> students) throws WrongEmailException, EmptyException {
		// TODO Auto-generated method stub
		
		if(students != null && students.size() > 0) {
			
			if(students.containsKey(email)) {
				System.out.println(students.get(email));
			}else {
				throw new WrongEmailException("This email does not exists...");
			}
		}else {
			throw new EmptyException("Student list is empty..");
		}
	}
	
	@Override
	public void viewStudents(Map<String, Student> students) throws EmptyException {
		// TODO Auto-generated method stub
		
		if(students != null && students.size() > 0) {
			
			for(Map.Entry<String, Student> kv : students.entrySet()) {
				System.out.println(kv.getValue());
			}
		
		}else {
			throw new EmptyException("Student list is empty..");
		}
	}

	@Override
	public void signUp(Student stu, Map<String, Student> students) throws DuplicateDataException{
		// TODO Auto-generated method stub
		
		if(students != null && students.size() > 1) {
			if(students.containsKey(stu.getEmail())) {
				throw new DuplicateDataException("this email is already exist");
			}else {
				students.put(stu.getEmail(), stu);
			}
		}else {
			students.put(stu.getEmail(), stu);
		}
		
		
		
		
	}

	@Override
	public boolean login(String email, String pass, Map<String, Student> students) throws InvalidDetailsException {
		// TODO Auto-generated method stub
		if (students.containsKey(email) ) {
			
			if(students.get(email).getPassword().equals(pass)) {
				return true;
			}
			else {
				throw new InvalidDetailsException("Invalid Credentials");
			}
			
		} else {
			throw new InvalidDetailsException("you have not sign up yet, please signup");
		}
		
	}

	@Override
	public void updateDetails(Student update, Map<String, Student> students)
			throws WrongEmailException, WrongPasswordException {
		// TODO Auto-generated method stub
		
		if(students.containsKey(update.getEmail())) {
			int temp = 0;
			for(Map.Entry<String, Student> kv : students.entrySet()) {
				if(kv.getValue().getPassword().equals(update.getPassword())) {
					students.put(update.getEmail(), update);
					temp = 1;
					break;
				}
			}
			if(temp==0) {
				throw new WrongPasswordException("Your password is not same, so we cant update your details..");
			}
		}else {
			throw new WrongEmailException("Given email is not exist in out database");
		}
		
	}

	@Override
	public void changePassword(String email, String oldPassword, String newPassword, Map<String, Student> students)
			throws WrongEmailException, WrongPasswordException {
		// TODO Auto-generated method stub
		if(students.containsKey(email)) {
			int temp = 0;
			for(Map.Entry<String, Student> kv : students.entrySet()) {
				if(kv.getValue().getPassword().equals(oldPassword)) {
					
					Student update = kv.getValue();
					update.setPassword(newPassword);
					students.put(email, update);
					System.out.println("Your new password is "+ newPassword);
					temp = 1;
					break;
				}
			}
			if(temp==0) {
				throw new WrongPasswordException("Your password is not same, so we cant update your details..");
			}
		}else {
			throw new WrongEmailException("Given email is not exist in out database");
		}
		
	}

	@Override
	public void registerStudent(String email, String cn, Map<String, Student> students, Map<Integer, Course> courses,
			Map<Integer, Batch> batches) throws CourseException ,CourseNotFoundException, WrongEmailException{
		// TODO Auto-generated method stub
		
		
		 if(students.containsKey(email)) {
			 Student stu = students.get(email);
			 int temp = 0;
			 for(Map.Entry<Integer, Course> kv : courses.entrySet()) {
				 Course c = kv.getValue();
				 if(c.getCourse_name().equalsIgnoreCase(cn)) {
					 List<Batch> batch = c.getBatches();
					 if(batch.size()>0) {
						 
						 boolean isstudent = false;
						 for(int i=0;i<batch.size();i++) {
							 List<Student> stulist = batch.get(i).getStudents();
							 if(!stulist.contains(stu)) {
								 boolean b = batch.get(0).addStudent(stu);
								 if(b) {
									 System.out.println("You are successfully registered");
								 }
								 isstudent = true;
								 temp = 1;
								 break;
							 }
//							 if(stulist.get(i).equals(stu)) {
//								 isstudent = true;
//							 }
						 }
						 if(isstudent == false) {
							
							System.out.println("You are already inrolled in this course(you can enroll in different batch if available)");
							
						 }
						 
						
					 }else {
						 Batch defaultBatch = new Batch(IDGeneration.generateId(),"Morning"+c.getCourse_name(),"5-9",5,c.getCourse_name());
						 c.addBatches(defaultBatch);
						 boolean b = batch.get(0).addStudent(stu);
						 if(b) {
							 System.out.println("You are successfully registered");
						 }
						 batches.put(defaultBatch.getId(),defaultBatch);
						 temp = 1;
						 break;
					 }
					
				 }
			 }
			 if(temp==0) {
				 new CourseNotFoundException("This course is not found");
			 }
		 }else {
			 throw new WrongEmailException("Your email is not register with us");
		 }
	}
	
	
	
	
	
	
	
	
	
	

}
