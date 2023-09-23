package com.masai;

public class Dsa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dsa d1 = new Dsa();
		d1.fun1(5); 
		

	}
	
	void fun1(int n) {
		
		if(n==0) {
			return;
		}
 		System.out.println(n);
		fun2(n-2);
		System.out.println(n);
		
	}
	
	void fun2(int n) {
		
		if(n==0) {
			return;
		}
		
		System.out.println(n);
		fun1(++n);
		System.out.println(n);
		
	}

}
