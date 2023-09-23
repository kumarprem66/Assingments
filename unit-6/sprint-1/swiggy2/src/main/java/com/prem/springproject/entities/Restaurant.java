package com.prem.springproject.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantId;
	@NotNull(message="value can not be null")
	private String name;
	@NotNull(message="value can not be null")
	private String address;
	
	@OneToMany(mappedBy = "restaurant" , cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Orders> orders;
	
	@ManyToMany
	private List<DeliveryPartner> deliveryList = new ArrayList<>();

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
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

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<DeliveryPartner> getDeliveryList() {
		return deliveryList;
	}

	public void setDeliveryList(List<DeliveryPartner> deliveryList) {
		this.deliveryList = deliveryList;
	}
	
	
	
	
}
