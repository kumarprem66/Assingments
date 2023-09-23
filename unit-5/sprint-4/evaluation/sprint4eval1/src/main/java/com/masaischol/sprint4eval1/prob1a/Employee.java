package com.masaischol.sprint4eval1.prob1a;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Employee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	
	@Embedded

	@AttributeOverrides({
		@AttributeOverride(name = "policyName",column=@Column(name="self_policyName")),
		@AttributeOverride(name = "companyName",column=@Column(name="self_companyName")),
		@AttributeOverride(name = "annualPrimium",column=@Column(name="self_annualPrimium")),
		
	})
	private Insurance selfInsurance;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "policyName",column=@Column(name="employer_policyName")),
		@AttributeOverride(name = "companyName",column=@Column(name="employer_companyName")),
		@AttributeOverride(name = "annualPrimium",column=@Column(name="employer_annualPrimium")),
	})
	
	private Insurance employerInsurance;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int age, Insurance selfInsurance, Insurance employerInsurance) {
		super();
	
		this.name = name;
		this.age = age;
		this.selfInsurance = selfInsurance;
		this.employerInsurance = employerInsurance;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Insurance getSelfInsurance() {
		return selfInsurance;
	}

	public void setSelfInsurance(Insurance selfInsurance) {
		this.selfInsurance = selfInsurance;
	}

	public Insurance getEmployerInsurance() {
		return employerInsurance;
	}

	public void setEmployerInsurance(Insurance employerInsurance) {
		this.employerInsurance = employerInsurance;
	}
	
	
	
	
	
	
	
	
	
}
