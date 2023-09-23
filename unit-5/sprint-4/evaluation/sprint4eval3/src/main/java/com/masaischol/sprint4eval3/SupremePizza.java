package com.masaischol.sprint4eval3;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SP")
public class SupremePizza extends Pizza{

	private int totalSauces;
	private int forNumberOfPeople;

	
	public SupremePizza() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupremePizza(double price, double rating, double diameter, String type,int totalSauces, int forNumberOfPeople) {
		super(price, rating, diameter, type);
		this.totalSauces = totalSauces;
		this.forNumberOfPeople = forNumberOfPeople;
		// TODO Auto-generated constructor stub
	}

	

	public int getTotalSauces() {
		return totalSauces;
	}
	public void setTotalSauces(int totalSauces) {
		this.totalSauces = totalSauces;
	}
	public int getForNumberOfPeople() {
		return forNumberOfPeople;
	}
	public void setForNumberOfPeople(int forNumberOfPeople) {
		this.forNumberOfPeople = forNumberOfPeople;
	}
	
	
	
}
