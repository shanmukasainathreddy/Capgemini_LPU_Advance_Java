package com.practice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "Student_info") // to rename table name   | delete table and again it will create
public class Student {
	@Id
	@Column(name="Student_id")
	private int id;
	@Column(name = "student_name")
	private String name;
	@Column(name = "student_percentage")
	private double percentage;
	@Column(name = "student_DOB")
	private  String DOB;
	
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
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public void setDOB(String DOB) {
		this.DOB = DOB;
	}
	public String getDOB() {
		return DOB;
	}
	
}

