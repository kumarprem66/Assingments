package com.day16;

import java.io.Serializable;

public class BallOfOver implements Serializable {
	
	private int runs;
	private char isFairDelivery;
	
	
	public BallOfOver(int runs, char isFairDelivery) {
		super();
		this.runs = runs;
		this.isFairDelivery = isFairDelivery;
	}
	
	
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public char getIsFairDelivery() {
		return isFairDelivery;
	}
	public void setIsFairDelivery(char isFairDelivery) {
		this.isFairDelivery = isFairDelivery;
	}
	
	
	
	

}
