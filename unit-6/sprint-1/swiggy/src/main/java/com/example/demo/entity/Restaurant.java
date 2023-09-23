package com.example.demo.entity;

public class Restaurant {

	
	private String restaurantId;
	private String name;
	private String address;
	public Restaurant(String restaurantId, String name, String address) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
