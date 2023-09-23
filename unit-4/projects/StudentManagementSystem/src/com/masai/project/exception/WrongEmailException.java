package com.masai.project.exception;

public class WrongEmailException extends Exception{
	
	public WrongEmailException() {
		
	}
	
	public WrongEmailException(String msg) {
		super(msg);
	}

}
