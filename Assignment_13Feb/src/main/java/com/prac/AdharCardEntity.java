package com.prac;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdharCardEntity {
	@Id
	private int aadharId;
	private long aadharNumber;
	private String address;
	private Date issuedate;
	
	
	public int getAadharId() {
		return aadharId;
	}
	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}
	
	
	@Override
	public String toString() {
		return "AdharCardEntity [aadharId=" + aadharId + ", aadharNumber=" + aadharNumber + ", address=" + address
				+ ", issuedate=" + issuedate + "]";
	}
	
	
	
	
	
	
	
}
