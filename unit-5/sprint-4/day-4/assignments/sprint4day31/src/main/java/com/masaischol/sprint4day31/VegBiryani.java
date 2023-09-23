package com.masaischol.sprint4day31;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VB")
public class VegBiryani extends Biryani{

	private int price;
	private String description;
	
	public VegBiryani() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VegBiryani(double rating, int price, String desc) {
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
		return "VegBiryani [price=" + price + ", desc=" + description + "]";
	}
	
	
	
}
