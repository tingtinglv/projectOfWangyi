package com.neusoft.ehr.entity;

import java.sql.Date;

public class Career {
	private int careerId;
	private Date startDate;
	private Date endDate;
	private String compName;
	private String postName;
	private String details;
	private double salary;
	private String reterence;
	private String reterPost;
	private String reterTel;
	private String reviews;
	private int empId;
	public int getCareerId() {
		return careerId;
	}
	public void setCareerId(int careerId) {
		this.careerId = careerId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getReterence() {
		return reterence;
	}
	public void setReterence(String reterence) {
		this.reterence = reterence;
	}
	public String getReterPost() {
		return reterPost;
	}
	public void setReterPost(String reterPost) {
		this.reterPost = reterPost;
	}
	public String getReterTel() {
		return reterTel;
	}
	public void setReterTel(String reterTel) {
		this.reterTel = reterTel;
	}
	public String getReviews() {
		return reviews;
	}
	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
}
