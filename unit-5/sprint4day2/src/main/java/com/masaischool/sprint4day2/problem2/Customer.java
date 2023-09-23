package com.masaischool.sprint4day2.problem2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "FindCustomerById",query="SELECT c FROM Customer c WHERE c.customerId = :id")
})

@NamedNativeQuery(name = "FindAllCustomer",query = "SELECT * FROM customer",resultClass = Customer.class)
public class Customer {

	
	@Id
	private int customerId;
	private String name;
	private String address;
	private int budget;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public Customer(int customerId, String name, String address, int budget) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.budget = budget;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", budget=" + budget
				+ "]";
	}
	
	
	
}
