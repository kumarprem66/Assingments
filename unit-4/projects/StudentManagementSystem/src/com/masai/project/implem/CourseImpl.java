package com.masai.project.implem;

import java.util.*;

import com.masai.project.interfaces.*;
import com.masai.project.exception.*;
import com.masai.utility.*;
import com.masai.project.implem.*;
import com.masai.project.entities.*;

import java.io.*;

public class CourseImpl implements CourseInterface{
	
	
	@Override
	public String addCourse(Course course, Map<Integer, Course> courses) {
		// TODO Auto-generated method stub
		courses.put(course.getId(), course);
		return "Course Added successfully..";
	}

	@Override
	public void viiewAllCourses(Map<Integer, Course> courses) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		if(courses != null && courses.size() >0) {
			
			for(Map.Entry<Integer, Course> kv : courses.entrySet()) {
				
				System.out.println(kv.getValue());
			}
			
		}else {
			throw new CourseNotFoundException("Course list is empty.");
		}
		
	}
	
	@Override
	public String updateCourse(int id,Course course,Map<Integer, Course> courses) throws CourseNotFoundException,CourseException {
		
		// TODO Auto-generated method stub
		
		if(courses != null && courses.size() >0) {
			
			if(courses.containsKey(id)) {
				courses.put(id, course);
				return "Course successfully updated";
			}else {
				throw new CourseNotFoundException("The course is not available with this id..");
			}
		}else {
			throw new CourseException("Course list is empty..");
		}
		
	
	}
	
	@Override
	public String deleteCourse(int id,Map<Integer, Course> courses,Map<Integer, Batch> batches) throws CourseNotFoundException,CourseException{
		// TODO Auto-generated method stub
		if(courses != null && courses.size() >0) {
			
			if(courses.containsKey(id)) {
				String cn = courses.get(id).getCourse_name();
				courses.remove(id);
				for(Map.Entry<Integer, Batch> kv : batches.entrySet()) {
					if(kv.getValue().getCourseName().equalsIgnoreCase(cn)) {
						batches.remove(kv.getValue().getId());
					}
				}
				return "Course successfully DELETED";
			}else {
				throw new CourseNotFoundException("The course is not available with this id..");
			}
		}else {
			throw new CourseException("Course list is empty..");
		}
		
	}



	@Override
	public void searchCourse(String courseName, Map<Integer, Course> courses) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		if(courses != null && courses.size() >0) {
				
			int temp = 0;
			
			for(Map.Entry<Integer, Course> kv : courses.entrySet()) {
				if(kv.getValue().getCourse_name().equalsIgnoreCase(courseName)) {
					System.out.println(kv.getValue());
					temp = 1;
					break;
				}
			}
			
				
			if(temp==0) {
				throw new CourseNotFoundException("The course is not available with this name");
			}
			
		}else {
			throw new CourseNotFoundException("Course list is empty..");
		}
		
	}



	@Override
	public void searchCourse(int fee, Map<Integer, Course> courses) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		if(courses != null && courses.size() >0) {
			
			int temp = 0;
//			List<Course> courseValues = (List<Course>) courses.values();
//			for(Course c : courseValues) {
//				if(c.getFee()<= fee) {
//					temp = 1;
//					System.out.println(c);
//				}
//			}
			
			for(Map.Entry<Integer, Course> kv : courses.entrySet()) {
				if(kv.getValue().getFee() <= fee) {
					System.out.println(kv.getValue());
					temp = 1;
					break;
				}
			}
			
				
			if(temp==0) {
				throw new CourseNotFoundException("The course is not available with this name");
			}
			
		}else {
			throw new CourseNotFoundException("Course list is empty..");
		}
	}



	public void showConsolidatedDetails(Map<Integer, Course> courses) throws EmptyException{
		// TODO Auto-generated method stub
		
		if(courses != null && courses.size()>0) {
			
//			List<Course> courseList = (List<Course>)courses.values();
			
			
			for(Map.Entry<Integer, Course> kv : courses.entrySet()) {
				
				List<Batch> batchList = kv.getValue().getBatches();
				
				System.out.println("=========== Course-Name => "+kv.getValue().getCourse_name()+ " , Course-duration => "+ kv.getValue().getDuration_of_course() +" , Fee => "+ kv.getValue().getFee()+"  ==========");
				
				for(Batch b : batchList) {
					
					System.out.println("              Batch-Name - "+b.getName()+" , Timing - " + b.getTiming()+" , Total-Seats - "+b.getNo_of_seats() +" , Students Enrolled - "+b.getStudentSize()+"          ");
					
					List<Student> studentList = b.getStudents();
					
					
					for(Student s : studentList) {
						System.out.println(s);
					}
					System.out.println();
					
				}
				
			}
			
		
			
		}else {
			throw new EmptyException("Course is null or empty");
		}
		
	}

	@Override
	public void showCourses(Map<Integer, Course> courses) throws EmptyException {
		// TODO Auto-generated method stub
		
		if(courses != null && courses.size() >0) {
			for(Map.Entry<Integer, Course> kv : courses.entrySet()) {
				System.out.println(kv.getValue());
			}
		}else {
			throw new EmptyException("Course list is empty");
		}
		
	}

	@Override
	public void createBatchinCourse(Batch newBatch, Map<Integer, Course> courses, Map<Integer, Batch> batches) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		int temp = 0;
		
		for(Map.Entry<Integer, Course> kv : courses.entrySet()) {
			
			if(kv.getValue().getCourse_name().equalsIgnoreCase(newBatch.getCourseName())) {
				
				kv.getValue().addBatches(newBatch);
				courses.put(kv.getValue().getId(), kv.getValue());
				batches.put(newBatch.getId(), newBatch);
				System.out.println("batch created successfully");
				temp = 1;
			}
		}
		if(temp==0) {
			throw new CourseNotFoundException("course is not found");
		}
	}

	
}
