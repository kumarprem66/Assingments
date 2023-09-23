package com.example.demo.exception;

public class InvalidEmailException extends RuntimeException{

	public InvalidEmailException(String msg) {
		super(msg);
	}
	
}
