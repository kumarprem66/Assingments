package com.masai.school.Miniflix.entity;

public class Movie {

	private int id;
	private String name;
	private String description;
	private int duration;
	private double rating;
	public Movie(int id, String name, String description, int duration, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.rating = rating;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", description=" + description + ", duration=" + duration
				+ ", rating=" + rating + "]";
	}
	
	
}
