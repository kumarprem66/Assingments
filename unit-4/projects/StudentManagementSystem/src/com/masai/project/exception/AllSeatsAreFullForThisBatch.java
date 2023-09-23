package com.masai.project.exception;

public class AllSeatsAreFullForThisBatch extends Exception {

	public AllSeatsAreFullForThisBatch(){
		
	}
	
	public AllSeatsAreFullForThisBatch(String msg) {
		super(msg);
	}
}

