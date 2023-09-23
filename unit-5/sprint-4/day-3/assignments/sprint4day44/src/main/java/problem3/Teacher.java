package problem3;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Teacher {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String suject;
	
	
	@ManyToMany(mappedBy = "teacher")
	private Set<Student> set;

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String name, String suject, Set<Student> set) {
		super();
		this.name = name;
		this.suject = suject;
		this.set = set;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuject() {
		return suject;
	}

	public void setSuject(String suject) {
		this.suject = suject;
	}

	public Set<Student> getSet() {
		return set;
	}

	public void setSet(Set<Student> set) {
		this.set = set;
	}
	
	
	
	
}
