package com.day16;

import java.io.Serializable;

public class Student implements Serializable{

	private int roll;
	private String name;
	private int marks;
	private transient String password;
	private Address address;
	
	
	public Student() {
		
	}
	public Student(int roll, String name, int marks, String password, Address address) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		this.password = password;
		this.address = address;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", password"+ password+ ", marks=" + marks + ", address=" + address.getState() + "]";
	}
	
	
	
	
	
}
