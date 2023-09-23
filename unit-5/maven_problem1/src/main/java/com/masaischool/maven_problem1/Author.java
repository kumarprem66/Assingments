package com.masaischool.maven_problem1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Author {

	
	@Id
	private int id;
	private String name;
	private double rating;
	public Author(int id, String name, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
	}
	public Author() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", rating=" + rating + "]";
	}
	
	
}
