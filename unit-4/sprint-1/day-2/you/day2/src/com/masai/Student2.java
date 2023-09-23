package com.masai;

public class Student {

	
	private int roll;
	private String name;
	private int marks;
	
	Student(){
		
	}
	
	Student(int roll,String name,int marks){
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}
	
	public void setRoll(int roll) {
		this.roll = roll;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public int getRoll() {
		return roll;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMarks() {
		return marks;
	}
}




//Problem Statement: Take your name input, convert the same to the array and then find the total vowels and consonants on your name.
//
//package com.masai.assignment;
//public class NameVowelConsonant {
//  static int getVowelCount(String name) {
//    write code to count vowels and return
//  }
//  public static void main(String[] args) {
//    System.out.println("Total vowel in Rajesh is " + getVowelCount("Rajesh"));
//    System.out.println("Total vowel in Yogita is " + getVowelCount("Yogita"));
//  }
//}
//
//Output
//Total vowel in Rajesh is 2
//Total vowel in Yogita is 3





























