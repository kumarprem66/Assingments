package com.masaischol.sprint4day312;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "vegBiryaniId")
//@NamedQueries({
@NamedQuery(name = "getBirById",query = "SELECT v FROM VegBiryani v WHERE v.biryaniId = :id")
//})

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
