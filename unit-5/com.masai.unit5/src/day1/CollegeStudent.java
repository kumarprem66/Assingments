package day1;

public class CollegeStudent extends Student{

	private String universityName;
	
	public CollegeStudent(int roll, String name, String state,String universityName) {
		super(roll, name, state);
		this.universityName = universityName;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CollegeStudent [universityName=" + universityName + ", roll=" + roll + ", name=" + name + ", state="
				+ state + "]";
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	
	

}
