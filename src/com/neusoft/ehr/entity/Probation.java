package com.neusoft.ehr.entity;

import java.sql.Date;

public class Probation {
	private int probationId;
	private int empId;
	private String empSeq;
	private String empName;
	private String depSeq;
	private String depName;
	private String postName;
	private String postSeq;
	private Date startDate;
	private Date endDate;
	private String result;
	private Date checkTime;
	private String reviews;
	private  String remark;
	public int getProbationId() {
		return probationId;
	}
	public void setProbationId(int probationId) {
		this.probationId = probationId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpSeq() {
		return empSeq;
	}
	public void setEmpSeq(String empSeq) {
		this.empSeq = empSeq;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public String getReviews() {
		return reviews;
	}
	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setDepSeq(String depSeq) {
		this.depSeq = depSeq;
	}
	public String getDepSeq() {
		return depSeq;
	}
	public void setPostSeq(String postSeq) {
		this.postSeq = postSeq;
	}
	public String getPostSeq() {
		return postSeq;
	}
}
