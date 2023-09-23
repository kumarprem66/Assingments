package problem3;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String studentId;
	private String studentName;
	private String course;
	private String location;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_teacher",joinColumns = {@JoinColumn(referencedColumnName = "studentId")},inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
	private Set<Teacher> teachers;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Student(String studentName, String course, String location, Set<Teacher> teachers) {
		super();
		this.studentName = studentName;
		this.course = course;
		this.location = location;
		this.teachers = teachers;
	}


	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	
}
