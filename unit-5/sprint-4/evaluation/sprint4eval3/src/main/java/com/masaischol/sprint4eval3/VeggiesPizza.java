package com.masaischol.sprint4eval3;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VP")
public class VeggiesPizza extends Pizza {

	
	private int totalVeggies;
	private double totalCalories;
	
	public int getTotalVeggies() {
		return totalVeggies;
	}
	public void setTotalVeggies(int totalVeggies) {
		this.totalVeggies = totalVeggies;
	}
	public double getTotalCalories() {
		return totalCalories;
	}
	public void setTotalCalories(double totalCalories) {
		this.totalCalories = totalCalories;
	}
	public VeggiesPizza() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VeggiesPizza(double price, double rating, double diameter, String type,int totalVeggies, double totalCalories) {
		super(price, rating, diameter, type);
		this.totalVeggies = totalVeggies;
		this.totalCalories = totalCalories;
		// TODO Auto-generated constructor stub
	}
	public VeggiesPizza(int totalVeggies, double totalCalories) {
		super();
		this.totalVeggies = totalVeggies;
		this.totalCalories = totalCalories;
	}
	
	
}
