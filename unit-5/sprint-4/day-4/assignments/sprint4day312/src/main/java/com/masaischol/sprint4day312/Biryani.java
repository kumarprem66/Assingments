package com.masaischol.sprint4day312;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Biryani {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int biryaniId;
	
	private double rating;
	
	
	@Override
	public String toString() {
		return "Biryani [biryaniId=" + biryaniId + ", rating=" + rating + "]";
	}
	public Biryani( double rating) {

	
		this.rating = rating;
	}
	public Biryani() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBiryaniId() {
		return biryaniId;
	}
	public void setBiryaniId(int biryaniId) {
		this.biryaniId = biryaniId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
}

