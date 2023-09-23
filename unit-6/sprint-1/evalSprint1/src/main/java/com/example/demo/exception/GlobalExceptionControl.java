package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionControl {

	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleNotFoundException(NotFoundException ie){
	
		return new ResponseEntity<String>(ie.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<String> handleInvalidEmailException(InvalidEmailException ie){
	
		return new ResponseEntity<String>(ie.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ie){
	
		return new ResponseEntity<String>(ie.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidStateException.class)
	public ResponseEntity<String> handleInvalidState(InvalidStateException ie){
	
		return new ResponseEntity<String>(ie.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	
}
