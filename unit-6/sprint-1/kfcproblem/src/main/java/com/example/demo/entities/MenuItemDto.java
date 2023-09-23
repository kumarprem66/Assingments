package com.example.demo.entities;

public class MenuItemDto {

	private String name;
	private int price;
	public MenuItemDto(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "MenuItemDto [name=" + name + ", price=" + price + "]";
	}
	
	
}
