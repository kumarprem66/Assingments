package com.example.demo.exception;

public class MenuItemException extends RuntimeException{

	
	public MenuItemException(){

	}
	
	public MenuItemException(String msg){
		super(msg);
	}
}
