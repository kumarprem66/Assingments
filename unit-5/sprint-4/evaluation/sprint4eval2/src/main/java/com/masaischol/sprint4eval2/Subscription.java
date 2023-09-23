package com.masaischol.sprint4eval2;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;


@Entity
@NamedNativeQueries({
	
	@NamedNativeQuery(name="findSubsByName",query="SELECT * FROM subscription WHERE plan_name like :name",resultClass=Subscription.class),
	@NamedNativeQuery(name="getEMployeeList",query="SELECT * FROM subscription Where start_date between :start and :end",resultClass=Subscription.class)
	
})

public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String plan_name;
	private int number_of_channel;
	private double monthly_charges;
	private Date start_date;
	private Date end_date;
	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subscription(String plan_name, int number_of_channel, double monthly_charges, Date start_date,
			Date end_date) {
		super();
		this.plan_name = plan_name;
		this.number_of_channel = number_of_channel;
		this.monthly_charges = monthly_charges;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Subscription [id=" + id + ", plan_name=" + plan_name + ", number_of_channel=" + number_of_channel
				+ ", monthly_charges=" + monthly_charges + ", start_date=" + start_date + ", end_date=" + end_date
				+ "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public int getNumber_of_channel() {
		return number_of_channel;
	}
	public void setNumber_of_channel(int number_of_channel) {
		this.number_of_channel = number_of_channel;
	}
	public double getMonthly_charges() {
		return monthly_charges;
	}
	public void setMonthly_charges(double monthly_charges) {
		this.monthly_charges = monthly_charges;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	
	
	
}
