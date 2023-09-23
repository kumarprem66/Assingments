package com.masai.project.entities;

import java.util.*;

public class Administration {

	
	private List<Course> courseList;
	
	public Administration() {
		this.courseList = new ArrayList<>();
	}
	
	
	public void addNewCourses(Course course) {
		
		this.courseList.add(course);
		
	}
}
