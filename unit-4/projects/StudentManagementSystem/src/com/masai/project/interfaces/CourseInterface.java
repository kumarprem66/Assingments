package com.masai.project.interfaces;

import java.util.*;
import com.masai.project.interfaces.*;
import com.masai.project.exception.*;
import com.masai.utility.*;
import com.masai.project.implem.*;
import com.masai.project.entities.*;

public interface CourseInterface{
	
	
	String addCourse(Course course,Map<Integer,Course> courses);
	void viiewAllCourses(Map<Integer, Course> courses) throws CourseNotFoundException;
	
	String updateCourse(int id,Course course,Map<Integer,Course> courses) throws CourseNotFoundException,CourseException;
	
	String deleteCourse(int id,Map<Integer,Course> courses, Map<Integer, Batch> batches) throws CourseNotFoundException,CourseException;
	
	void searchCourse(String courseName, Map<Integer,Course> courses) throws CourseNotFoundException;
	
	void searchCourse(int fee, Map<Integer,Course> courses) throws CourseNotFoundException;
	
	void showConsolidatedDetails(Map<Integer, Course> courses) throws EmptyException;
	
	void showCourses(Map<Integer, Course> courses) throws EmptyException;
	void createBatchinCourse(Batch newBatch, Map<Integer, Course> courses,Map<Integer, Batch> batches) throws CourseNotFoundException;
}
