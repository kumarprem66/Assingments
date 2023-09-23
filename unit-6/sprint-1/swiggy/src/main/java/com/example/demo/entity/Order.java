package com.example.demo.entity;

import java.util.List;

public class Order {

	
	private String orderId;
	private String customerId;
	private String restaurantId;
	private String deliveryPartnerId;
	private List<String> items;
	private OrderStatus orderStatus;
	
	public Order(String orderId, String customerId, String restaurantId, String deliveryPartnerId, List<String> items,
			OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.deliveryPartnerId = deliveryPartnerId;
		this.items = items;
		this.orderStatus = orderStatus;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getDeliveryPartnerId() {
		return deliveryPartnerId;
	}
	public void setDeliveryPartnerId(String deliveryPartnerId) {
		this.deliveryPartnerId = deliveryPartnerId;
	}
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", restaurantId=" + restaurantId
				+ ", deliveryPartnerId=" + deliveryPartnerId + ", items=" + items + ", orderStatus=" + orderStatus
				+ "]";
	}
	
	
	
	
}
