package com.masai.project.interfaces;

import java.util.*;

import com.masai.project.exception.*;

import com.masai.project.entities.*;



public interface StudentInterface {

	
	public void changePassword(String email,String oldPassword,String newPassword,Map<String, Student> students) throws WrongEmailException,WrongPasswordException;
	
	
	
	public void changeEmail(String oldEmail,String newEmail,List<Student> students) throws WrongEmailException , WrongPasswordException;
	
	public void viewStudents(Map<String, Student> students) throws EmptyException;

	public void viewStudentDetails(String email, Map<String, Student> students) throws WrongEmailException,EmptyException;

	public void signUp(Student stu, Map<String, Student> students) throws DuplicateDataException;
	
	public boolean login(String email,String pass,Map<String,Student> students) throws InvalidDetailsException;

	public void updateDetails(Student update, Map<String, Student> students) throws WrongEmailException,WrongPasswordException;



	public void registerStudent(String email, String cn, Map<String, Student> students, Map<Integer, Course> courses,
			Map<Integer, Batch> batches) throws CourseException, CourseNotFoundException, WrongEmailException;
	
	
}
