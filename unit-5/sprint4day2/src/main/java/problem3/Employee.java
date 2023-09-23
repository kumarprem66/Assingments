package problem3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({
	
	@NamedNativeQuery(name="getEMployeeByName",query="SELECT * FROM employee WHERE empname like :name",resultClass=Employee.class),
	@NamedNativeQuery(name="getEMployeeList",query="SELECT * FROM employee",resultClass=Employee.class),
})
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private String address;
	private int salary;
	private String email;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + ", salary=" + salary
				+ ", email=" + email + "]";
	}
	public Employee(String empName, String address, int salary, String email) {
		super();
		
		this.empName = empName;
		this.address = address;
		this.salary = salary;
		this.email = email;
	}
	public Employee() {
		super();
	}
	
	
	
}
