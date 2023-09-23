package com.example.demo.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String customerName;
	private int menuItemId;
	private String customerPhone;
	private Date orderDate;
	private int totalPrice;
	public Order(int id, String customerName, int menuItemId, String customerPhone, Date orderDate, int totalPrice) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.menuItemId = menuItemId;
		this.customerPhone = customerPhone;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getMenuItemId() {
		return menuItemId;
	}
	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", customerName=" + customerName + ", menuItemId=" + menuItemId + ", customerPhone="
				+ customerPhone + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
}
