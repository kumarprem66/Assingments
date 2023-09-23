package com.masai.project.exception;

public class WrongPasswordException extends Exception{
	
	
	public WrongPasswordException(){
		
	}

		public WrongPasswordException(String msg){
			super(msg);
		
		}
	
	
}
