package com.masai.project.entities;
import java.io.Serializable;
import java.util.*;

public class Batch implements Serializable{

	private int id;
	private String name;
	private String timing;
	private int no_of_seats;
	private String courseName;
	private String courseId;
	private List<Student> students;
	
	
	public Batch(int id,String name, String timing, int no_of_seats, String courseName, String courseId) {
		super();
		this.id = id;
		this.name = name;
		this.timing = timing;
		this.no_of_seats = no_of_seats;
		this.courseName = courseName;
		this.courseId = courseId;
		this.students = new ArrayList<>();
	}
	public Batch(int id,String name, String timing, int no_of_seats, String courseName) {
		super();
		this.id = id;
		this.name = name;
		this.timing = timing;
		this.no_of_seats = no_of_seats;
		this.courseName = courseName;
	
		this.students = new ArrayList<>();
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public int getNo_of_seats() {
		return no_of_seats;
	}

	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	public boolean addStudent(Student student) {
	
		if(getStudentSize()< getNo_of_seats()) {
			this.students.add(student);
			return true;
		}else {
			System.out.println("Choose different batch, this batch is full (Ask Administration to create another batch)");
			return false;
		}
		
	}
	
	public int getStudentSize() {
		
		return students.size();
	}

	@Override
	public String toString() {
		return "Batch [id=" + id + ", name=" + name + ", timing=" + timing + ", no_of_seats=" + no_of_seats
				+ ", courseName=" + courseName + ", Enrolled-students=" + students.size() + "]";
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
		Batch other = (Batch) obj;
		return id == other.id;
	}
	
	
	
	
}
