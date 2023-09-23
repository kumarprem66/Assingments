package com.masaischol.sprint4day31;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CB")
public class ChickenBiryani extends Biryani{


	private int price;
	private String description;
	
	public ChickenBiryani() {
		super();
		
	}
	
	

	public ChickenBiryani(double rating, int price, String desc) {
		super(rating);
		this.price = price;
		this.description = desc;
	}


	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return description;
	}
	public void setDesc(String desc) {
		this.description = desc;
	}
	@Override
	public String toString() {
		return "ChickenBiryani [ price=" + price + ", desc=" + description + "]";
	}
	
	
	
}
