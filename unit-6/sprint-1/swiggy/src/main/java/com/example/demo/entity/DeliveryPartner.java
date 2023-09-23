package com.example.demo.entity;

public class DeliveryPartner {

	
	private String deliveryPartnerId;
	private String name;
	private String phoneNumber;
	
	public DeliveryPartner(String deliveryPartnerId, String name, String phoneNumber) {
		super();
		this.deliveryPartnerId = deliveryPartnerId;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getDeliveryPartnerId() {
		return deliveryPartnerId;
	}

	public void setDeliveryPartnerId(String deliveryPartnerId) {
		this.deliveryPartnerId = deliveryPartnerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
