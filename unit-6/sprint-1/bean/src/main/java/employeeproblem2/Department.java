package employeeproblem2;

public class Department {

	private String deptid;
	private String deptName;
	private String location;
	public String getDeptid() {
		return deptid;
	}
	public String getDeptName() {
		return deptName;
	}
	public String getLocation() {
		return location;
	}
	public Department(String deptid, String deptName, String location) {
		super();
		this.deptid = deptid;
		this.deptName = deptName;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", deptName=" + deptName + ", location=" + location + "]";
	}
	
	
	
	
	
}
