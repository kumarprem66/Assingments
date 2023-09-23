// package com.masai.day1;
import java.util.*;

public class MyStack<E> {

	private int top;
	List<E> list;
	
	public MyStack() {
		this.top = -1;
		list = new ArrayList<>();
		
	}
	
	E top() {
		if(top==-1) {
			return null;
		}
		return list.get(top);
	}
	
	void push(E ele) {
		if(empty()) {
			top = 0;
			list.add(ele);
		}else {
			top++;
			list.add(ele);
		}
	
	}
	
	E pop() {
		if(empty()) {
			return null;
		}else {
			top--;
			return list.remove(top);
			
		}
	}
	
	public String toString() {
		if(this.empty()) {
			return "";
		}
		String text = "";
		for(int i=top;i>=0;i--) {
			text += list.get(i)+", ";
		}
		return text;
	}
	
	boolean empty() {
		if(top==-1) {
			return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		MyStack<String> st = new MyStack<>();
		Scanner sc = new Scanner(System.in);
		int start = 4;
		while(start>0) {
			System.out.println("Enter string");
			String s = sc.next();
			st.push(s);
			start--;
		}
		System.out.println(st.toString());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
