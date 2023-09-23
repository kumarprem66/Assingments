package employeeproblem2;

public class Employee {

	private int empid;
	private String name;
	private int salary;
	private String address;
	
	public Employee(int empid, String name, int salary, String address) {
		super();
		this.empid = empid;
		this.name = name;
		this.salary = salary;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary + ", address=" + address + "]";
	}
	
	
}
