package com.example.demo.model;

public class User {

	
	private String usuerId;
	private String name;
	private String email;
	
	public User(String usuerId, String name, String email) {
		super();
		this.usuerId = usuerId;
		this.name = name;
		this.email = email;
	}
	public String getUsuerId() {
		return usuerId;
	}
	public void setUsuerId(String usuerId) {
		this.usuerId = usuerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [usuerId=" + usuerId + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
