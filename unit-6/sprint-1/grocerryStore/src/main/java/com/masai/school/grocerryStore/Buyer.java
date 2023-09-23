package com.masai.school.grocerryStore;



import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Buyer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int buyer_id;
	private String name;
	private String email;
	private String mobile;
	
	
	@ManyToMany()
	private Set<Store> store;
	
	
	
	
	
	
	
}
