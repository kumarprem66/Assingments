package com.masai.school.bean.practice;

public class Car implements Vehicle {

	
	public void drive() {
		System.out.println("riding a bike");
	}

	@Override
	public void go() {
		// TODO Auto-generated method stub
		drive();
		
	}
}
