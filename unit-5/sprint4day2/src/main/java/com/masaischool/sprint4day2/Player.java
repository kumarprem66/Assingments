package com.masaischool.sprint4day2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Player {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String name;
	private String sportName;
	private int age;
	
	
	public Player() {
		
	}
	
	public Player(int pid, String name, String sportName, int age) {
		super();
		this.pid = pid;
		this.name = name;
		this.sportName = sportName;
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Player [pid=" + pid + ", name=" + name + ", sportName=" + sportName + ", age=" + age + "]";
	}


	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
