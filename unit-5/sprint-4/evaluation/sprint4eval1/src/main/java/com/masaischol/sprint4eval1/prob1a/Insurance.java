package com.masaischol.sprint4eval1.prob1a;

import jakarta.persistence.Embeddable;

@Embeddable
public class Insurance {

	private String policyName;
	private String companyName;
	private int annualPrimium;
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Insurance(String policyName, String companyName, int annualPrimium) {
		super();
		this.policyName = policyName;
		this.companyName = companyName;
		this.annualPrimium = annualPrimium;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getAnnualPrimium() {
		return annualPrimium;
	}
	public void setAnnualPrimium(int annualPrimium) {
		this.annualPrimium = annualPrimium;
	}
	
	
	
}
