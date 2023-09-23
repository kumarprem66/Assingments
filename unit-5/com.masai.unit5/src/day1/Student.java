package day1;

abstract class Student {

	
	public int roll;
	public String name;
	public String state;
	
	public Student(int roll, String name, String state) {
		super();
		this.roll = roll;
		this.name = name;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", state=" + state + "]";
	}
//	public int getRoll() {
//		return roll;
//	}
//	public void setRoll(int roll) {
//		this.roll = roll;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
	
	
	
	
	
}
