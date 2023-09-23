package com.masai.school.bean.practice;

public class Travel {

	Vehicle vehicle;
	int numberOfPerson;
	
	public Travel() {
		
	}
	
	public Travel(Vehicle v,int n) {
		this.vehicle = v;
		this.numberOfPerson = n;
	}
	
//	setter injection
//	public void setVehicle(Vehicle v) {
//		this.vehicle = v;
//	}
//	
//	public void setNumberOfPerson(int numberOfPerson) {
//		this.numberOfPerson = numberOfPerson;
//	}
	

	public void journey() {
		vehicle.go();
		System.out.println("Journey started");
	}
}
//<bean id="t" class="com.masai.school.bean.practice.Travel">
//<property name="vehicle" ref="b"></property>
//<property name="numberOfPerson" value="8"></property>
//</bean> 