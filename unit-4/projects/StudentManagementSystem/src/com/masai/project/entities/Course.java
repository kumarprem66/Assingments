package com.masai.project.entities;

import java.io.Serializable;
import java.util.*;

public class Course implements Serializable{

	private int id;
	private String course_name;
	private String duration_of_course;	
	private int fee;
	private List<Batch> batches;
	
	public Course(int id,String course_name, String duration_of_course, int fee) {
		super();
		this.id = id;
		this.course_name = course_name;
		this.duration_of_course = duration_of_course;
		this.fee = fee;
		this.batches = new ArrayList<>();
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getDuration_of_course() {
		return duration_of_course;
	}

	public void setDuration_of_course(String duration_of_course) {
		this.duration_of_course = duration_of_course;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Batch> getBatches() {
		return batches;
	}

	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}

	public void addBatches(Batch batch) {

		this.batches.add(batch);
		
		
		
	}
	
	public int getBatchSize() {
		if(batches != null) {
			return batches.size();
		}else {
			return 0;
		}
	}



	@Override
	public String toString() {
		return "Course [id=" + id + ", course_name=" + course_name + ", duration_of_course=" + duration_of_course
				+ ", fee=" + fee + ", batches=" + batches + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return id == other.id;
	}


	

	

	
	
	
	
}
