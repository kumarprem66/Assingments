package com.masai.eval;

public class Applicant {

	private String applicantid;
	private String name;
	private double interviewMarks;
	public String getApplicantid() {
		return applicantid;
	}
	public void setApplicantid(String applicantid) {
		this.applicantid = applicantid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getInterviewMarks() {
		return interviewMarks;
	}
	public void setInterviewMarks(double interviewMarks) {
		this.interviewMarks = interviewMarks;
	}
	public Applicant(String applicantid, String name, double interviewMarks) {
		super();
		this.applicantid = applicantid;
		this.name = name;
		this.interviewMarks = interviewMarks;
	}
	@Override
	public String toString() {
		return "Applicant [applicantid=" + applicantid + ", name=" + name + ", interviewMarks=" + interviewMarks + "]";
	}
	
	
}
