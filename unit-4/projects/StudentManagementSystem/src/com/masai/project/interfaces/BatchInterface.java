package com.masai.project.interfaces;



import java.util.Map;

import com.masai.project.exception.*;

import com.masai.project.entities.*;

public interface BatchInterface {

//	void showStudentOfBatches(String course_name,String batchname) throws ClassNotFoundException, IOException,CourseNotFoundException;

	void updateBatch(int id,Batch update, Map<Integer, Course> courses,Map<Integer, Batch> batches) throws BatchNotFoundException,EmptyException, CourseNotFoundException;

	void showAllBatches(Map<Integer, Batch> batches) throws EmptyException;
	
	
	
	
	
	
	
	
	
	
}
