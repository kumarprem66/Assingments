package com.prem.springproject.exception;

public class SpotifyException extends RuntimeException{

	public SpotifyException() {
		
	}
	
	public SpotifyException(String msg) {
		super(msg);
	}
	
}
