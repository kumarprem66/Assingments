 package com.masai.project;
import java.io.*;
import java.util.*;

import com.masai.project.interfaces.*;
import com.masai.project.exception.*;
import com.masai.utility.*;
import com.masai.project.implem.*;
import com.masai.project.entities.*;



public class Main {

	
	private static void administrationFunctionality(Scanner sc, Map<Integer,Course> courses,Map<Integer,Batch> batches, Map<String, Student> students) throws InvalidDetailsException 
	{
		adminLogin(sc);
		
		CourseInterface courseService = new CourseImpl();
		StudentInterface stuService = new StudentImpl();
		BatchInterface batchService = new BatchImpl();
		int choice = 0;
		 
		try {
			do {
				System.out.println("Press 1 to add the COURSE");
				System.out.println("Press 2 to know about COURSE");
				System.out.println("Press 3 to update the COURSE");
				System.out.println("Press 4 to create branch under COURSE");
				System.out.println("Press 5 to search course");
				System.out.println("Press 6 to update BATCH");
				System.out.println("Press 7 to view STUDENT DETAILS");
				System.out.println("Press 8 to view CONSOLIDATED DETAILS");
				System.out.println("Press 9 to know about BATCH");
				System.out.println("Press 10 to delete course..");
				System.out.println("Press 11 to View Students.");
				System.out.println("Press 0 to exit");
				
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					String added = adminCourseAdded(sc, courses, courseService); 
					System.out.println(added);
					break;
					
				case 2:
					adminViewAllCourses(courses,courseService);
					break;
					
				case 3:
					String upt = adminUpdateCourses(sc,courses,courseService);
					System.out.println(upt);
					break;
				
				case 4:
					adminCreateBranchInCourse(sc,courses,batches,courseService);
					
					break;
					
				case 5:
					adminSearchCourse(sc,courses,courseService);
					break;
				case 6:
					adminUpdateBatch(sc,courses,batchService,batches);
					break;
				
				case 7:
					adminViewStudentDetails(sc,students,stuService);
					break;
				case 8:
					
					adminViewConsolidatedDetails(courses,courseService);
					break;
				case 9:
					showAllBatches(sc,batches,batchService);
					
					break;
				case 10:
					adminDeleteCourse(sc,courses,batches,courseService);
					System.out.println("Course deleted successfully");
					break;
				case 11:
					adminViewStudents(students,stuService);
					break;
				case 0:
					System.out.println("Successfully existed from the system");
					choice = 0;
//					System.exit(0);
					break;
				default:
					throw new IllegalArgumentException("Invalid selection");
				
				}
				
					
			}while(choice != 0);
		}catch(Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
	}
	

	private static void adminViewStudents(Map<String, Student> students, StudentInterface stuService) throws EmptyException{
		// TODO Auto-generated method stub
		
		stuService.viewStudents(students);
	}


	private static void showAllBatches(Scanner sc, Map<Integer, Batch> batches, BatchInterface batchService) 
	throws EmptyException{
		// TODO Auto-generated method stub
		
		batchService.showAllBatches(batches);
	}


	private static void adminCreateBranchInCourse(Scanner sc, Map<Integer, Course> courses, Map<Integer, Batch> batches,
			CourseInterface courseService) throws CourseNotFoundException{
		// TODO Auto-generated method stub
		System.out.println("Enter the course name");
		String cn = sc.next();
		System.out.println("Enter the branch name");
		String bname = sc.next();
		System.out.println("Enter the branch timimg");
		String timing = sc.next();
		System.out.println("Enter the number of seats");
		int seats = sc.nextInt();
		
		Batch newBatch = new Batch(IDGeneration.generateId(),bname,timing,seats,cn);
//		batches.put(IDGeneration.generateId(), newBatch);
		courseService.createBatchinCourse(newBatch,courses,batches);
		
		
	}


	private static void adminUpdateBatch(Scanner sc, Map<Integer,Course> courses,BatchInterface batchService ,Map<Integer,Batch> batches) throws BatchNotFoundException , EmptyException, CourseNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the Batch ID first");
		int bid = sc.nextInt();
		
		System.out.println("Enter the course name first");
		String courseName = sc.next();
		
		System.out.println("Enter the Batch name");
		
		String name = sc.next();
		
		System.out.println("Enter the New Timing..");
		
		String timing = sc.next();
		
		System.out.println("Enter the New number of seats");
		
		int seats = sc.nextInt();
		
		Batch update = new Batch(bid,name,timing,seats,courseName);
		
		batchService.updateBatch(bid,update,courses,batches);
		

	}


	private static void adminViewConsolidatedDetails(Map<Integer, Course> courses,CourseInterface courseService) throws EmptyException{
		// TODO Auto-generated method stub
		courseService.showConsolidatedDetails(courses);
		
	}


	private static void adminViewStudentDetails(Scanner sc, Map<String, Student> students, StudentInterface stuService) throws WrongEmailException, EmptyException {
		// TODO Auto-generated method stub
		System.out.println("Enter Email of students..");
		String email = sc.next();
		stuService.viewStudentDetails(email,students);
		
		
	}


	private static void adminSearchCourse(Scanner sc, Map<Integer, Course> courses, CourseInterface courseService) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("What is your searching criteria...");
		System.out.println("1--> Course Name,   2 --> duration   3 --> Fee(low and High)");
		int choose = 0;
		choose = sc.nextInt();
		switch(choose) {
		case 1:
			System.out.println("Enter the Course Name");
			String name = sc.next();
			courseService.searchCourse(name, courses);
			break;
		
		case 2:
			System.out.println("Enter the maximum Month period");
			String month = sc.next();
			courseService.searchCourse(month, courses);
			break;
		case 3:
			System.out.println("Enter the maximum Course Fee");
			int fee = sc.nextInt();
			courseService.searchCourse(fee, courses);
			break;
		default:
			System.out.println("Enter the valid input");
			break;
		}
		
	}

	private static String adminDeleteCourse(Scanner sc, Map<Integer, Course> courses,Map<Integer, Batch> batches, CourseInterface courseService) throws CourseNotFoundException, CourseException {
		
		System.out.println("please enter the id of course to be deleted");
		int id = sc.nextInt();
		
		String sr = courseService.deleteCourse(id, courses,batches);
		// TODO Auto-generated method stub
		return sr;
	}

	private static String adminUpdateCourses(Scanner sc, Map<Integer, Course> courses, CourseInterface courseService) throws CourseException, CourseNotFoundException{
		// TODO Auto-generated method stub
		String result = null;
		System.out.println("please enter the id of the Course which is to be updated");
		int id = sc.nextInt();
		
		System.out.println("Enter the Course name");
		String name = sc.next();
		
		System.out.println("Enter the Duration name");
		String duration = sc.next();
		
		System.out.println("Enter the Fee name");
		int fee = sc.nextInt();
		
		
		Course update = new Course(id,name,duration,fee);
		result = courseService.updateCourse(id,update,courses);
		
		return result;
	}

	private static void adminViewAllCourses(Map<Integer, Course> courses, CourseInterface courseService) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		
		courseService.viiewAllCourses(courses);
	}

	private static String adminCourseAdded(Scanner sc,Map<Integer,Course> courses,CourseInterface courseService) {
		
		String str = null;
		System.out.println("please enter the course details");
		System.out.println("Enter the Course name");
		String name = sc.next();
		System.out.println("Enter the Course duration(Format => 5-month)");
		String duration = sc.next();
		System.out.println("Enter the Course Fee..");
		int fee = sc.nextInt();
		
		Course course = new Course(IDGeneration.generateId(),name,duration,fee);
		
		str = courseService.addCourse(course, courses);
		
		return str;
		
	}
	
	private static void adminLogin(Scanner sc) throws InvalidDetailsException {
		
		System.out.println("Enter the user name");
		String userName = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		if(userName.equals(Admin.username) && password.equals(Admin.password)) {
			System.out.println("Successfully login");
		}else {
			throw new InvalidDetailsException("Invalid Admin Credentials");
		}
		
	}
	
	
	private static void studentSignUp(Scanner sc, Map<String, Student> students) throws DuplicateDataException {
		// TODO Auto-generated method stub
		
		System.out.println("please enter the following details to Signup");
		System.out.println("please enter your first name");
		String fn = sc.next();
		System.out.println("Enter the last name");
		String ln = sc.next();
		System.out.println("enter the address");
		String address = sc.next();
		System.out.println("enter the mobile");
		String mobile = sc.next();
		System.out.println("Enter the email id");
		String email = sc.next();
		System.out.println("set the password and remember it for future");
		String pass = sc.next();
		
		
		Student stu = new Student(fn,ln,address,mobile,email,pass);

		StudentInterface stuService = new StudentImpl();
		stuService.signUp(stu,students);
		System.out.println("You are Succefully sign up");
	}


	private static void studentFunctionality(Scanner sc, Map<Integer, Course> courses, Map<Integer, Batch> batches,
			Map<String, Student> students) throws InvalidDetailsException {
	
		
		StudentInterface stuService = new StudentImpl();
		BatchInterface batchService = new BatchImpl();
		CourseInterface courseService = new CourseImpl();
		
//		Student sign-up
		System.out.println("Please enter the following details to login");
		System.out.println("please enter the email");
		String email = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		studentLogin(email,pass, students, stuService);
		
		try {
			int choice = 0;
			do {
				System.out.println("Select the option of your choice");
				System.out.println("Press 1 to update your details");
				System.out.println("Press 2 to change your password");
				System.out.println("Press 3 to see available course list");
				System.out.println("Press 4 view batches course-wise along with available seats");
				System.out.println("Press 5 Register yourself in any course");
				System.out.println("Press 6 to logout");
				choice = sc.nextInt();
				
				switch (choice) {
				case 1:
					studentUpdateDetails(sc,students,stuService);
					System.out.println("Your details has been updated");
					break;
				case 2:
					studentchangePassword(sc,students,stuService);
					break;
				case 3:
					studentSeeAvailableCourses(courses,courseService);
					break;
				case 4:
					batchesWithCourses(courses,courseService,batches,batchService);
					break;
				case 5:
					studentRegister(sc,students,stuService,courses,courseService,batches,batchService);
					
					break;
				case 6:
					System.out.println("You have Successfully logout");
					choice = 0;
					
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			}while(choice != 0);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	

	private static void studentRegister(Scanner sc,Map<String, Student> students, StudentInterface stuService,
			Map<Integer, Course> courses, CourseInterface courseService, Map<Integer, Batch> batches,
			BatchInterface batchService) throws CourseException, CourseNotFoundException, WrongEmailException{
		// TODO Auto-generated method stub
		
		System.out.println("Enter your email");
		String email = sc.next();
		System.out.println("In which course you want to register..");
		String cn = sc.next();
		stuService.registerStudent(email, cn,students,courses,batches);
		
		
	}


	private static void batchesWithCourses(Map<Integer, Course> courses, CourseInterface courseService,
			Map<Integer, Batch> batches, BatchInterface batchService) throws EmptyException {
		// TODO Auto-generated method stub
		
		courseService.showConsolidatedDetails(courses);
		
	}


	private static void studentSeeAvailableCourses(Map<Integer, Course> courses, CourseInterface courseService) throws EmptyException {
		// TODO Auto-generated method stub
		
		courseService.showCourses(courses);
		
		
	}


	private static void studentchangePassword(Scanner sc,Map<String, Student> students, StudentInterface stuService) 
	throws WrongEmailException, WrongPasswordException{
		// TODO Auto-generated method stub
		System.out.println("Enter your Email");
		String email = sc.next();
		System.out.println("Enter the Old password");
		String oldpass = sc.next();
		System.out.println("Enter your new Password");
		String newpass = sc.next();
		stuService.changePassword(email, oldpass, newpass, students);
		
		
	}


	private static void studentUpdateDetails(Scanner sc,Map<String, Student> students, StudentInterface stuService) throws WrongEmailException, WrongPasswordException {
		// TODO Auto-generated method stub
		System.out.println("Enter the details which you want to update..");
		System.out.println("Enter your old Email first");
		String email = sc.next();
		System.out.println("Enter your first name");
		String fn = sc.next();
		System.out.println("Enter your last name");
		String ln = sc.next();
		System.out.println("Enter your address name");
		String addr = sc.next();
		System.out.println("Enter your mobile name");
		String mob = sc.next();
		System.out.println("Enter your old password");
		String pass = sc.next();
		
		Student update = new Student(fn,ln,addr,mob,email,pass);
		stuService.updateDetails(update,students);
		
		
	}


	private static void studentLogin(String email, String pass, Map<String, Student> students,
			StudentInterface stuService) throws InvalidDetailsException {
		// TODO Auto-generated method stub
		stuService.login(email, pass, students);
		System.out.println("Student has Successfully login");
		
		
	}


	
	public static void main(String[] args) {

		Map<Integer,Course> courses = FileExists.courseFile();
		Map<Integer,Batch> batches = FileExists.batchFile();
		Map<String,Student> students = FileExists.studentFile();

		Scanner sc = new Scanner(System.in);
		
		String s = "Welcome, in Automated Student Registration System....";
		Design.design(s);
		
		
		try {
			int preference = 0;
			do {
				System.out.println("Please Enter Your Preference..(NOTE -  WRITE WITHOUT SPACES..) \n 1 --> Administration Login \n 2 --> Student Login  "+ 
			" \n 3 --> For Student SignUp, \n 0 --> For exit");
				
				preference = sc.nextInt();
				switch(preference) {
				
				case 1:
					administrationFunctionality(sc,courses,batches,students);
					break;
					
				case 2:
					studentFunctionality(sc,courses,batches,students);
					break;
				case 3:
					studentSignUp(sc,students);
					break;
				case 0:
					System.out.println("Successfully existed from the system");
					break;
				default:
					throw new IllegalArgumentException("Invalid selection");
				}
				
			}while(preference != 0) ;
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {

				System.out.println("I was called bro in fainally block of main");
				ObjectOutputStream ooss = new ObjectOutputStream(new FileOutputStream("student.ser"));
				ooss.writeObject(students);
				ooss.flush();
				ObjectOutputStream oosc = new ObjectOutputStream(new FileOutputStream("course.ser"));
				oosc.writeObject(courses);
				oosc.flush();
				ObjectOutputStream oosb = new ObjectOutputStream(new FileOutputStream("batch.ser"));
				oosb.writeObject(batches);
				oosb.flush();
				
				
				ooss.close();
				oosc.close();
				oosb.close();
				
			
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		}
		
	
	}
	


}
