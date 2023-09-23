package com.masai.project.entities;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable{

	private String first_name;
	private String last_name;
	private String address;
	private String mobile;
	private String email;
	private String password;
	
	public Student(String first_name, String last_name, String address, String mobile, String email, String password) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}

	public Student(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Student() {
		super();
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "                         Student [first_name=" + first_name + ", last_name=" + last_name + ", address=" + address + ", mobile="
				+ mobile + ", email=" + email + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return  Objects.equals(email, other.email);
	}

	
	
	
}
