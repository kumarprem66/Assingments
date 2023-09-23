package com.masaischool.sprint4day3.problem1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empID;
	private String name;
	private String gender;
	private int salary;
	
	
	@Embedded
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "emp_address",joinColumns = @JoinColumn(name = "emp_id"))
	private Set<Address> empAddress = new HashSet<>();
	
//	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name = "state",column=@Column(name="OFFICE_STATE")),
//		@AttributeOverride(name = "city",column=@Column(name="OFFICE_CITY")),
//		@AttributeOverride(name = "pincode",column=@Column(name="OFFICE_PINCODE")),
//		@AttributeOverride(name = "type",column=@Column(name="OFFICE_TYPE"))
//	})
//	private Address Homeaddre;
//	
//	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name = "state",column=@Column(name="HOME_STATE")),
//		@AttributeOverride(name = "city",column=@Column(name="HOME_CITY")),
//		@AttributeOverride(name = "pincode",column=@Column(name="HOME_PINCODE")),
//		@AttributeOverride(name = "type",column=@Column(name="HOME_TYPE"))
//	})
//	
//	private Address OfficeAddre;


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Set<Address> getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(Set<Address> empAddress) {
		this.empAddress = empAddress;
	}

	public Employee(int empID, String name, String gender, int salary, Set<Address> empAddress) {
		super();
		this.empID = empID;
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", name=" + name + ", gender=" + gender + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gender, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(gender, other.gender) && Objects.equals(name, other.name) && salary == other.salary;
	}


	
	
	
	
	
	
	
	
}
