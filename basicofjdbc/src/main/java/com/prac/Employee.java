package com.prac;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String branch;
	public Employee(int id,String name,int age,String branch) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.branch = branch;
	}
	
	public boolean isValidAge() {
		if(age > 17) return true;
		else return false;
	}
	
	
	public boolean isValidId() {
		if(id>0) return true;
		else return false;
	}
	
//	public boolean isValidName() {
//		for(char i=0;i<name.length();i++) {
//			if(i.isletter()) return true;
//			else return false;
//		}
//	}
	public boolean isValidBranch() {
		if(branch == "CSE") return true;
		else return false;
	}
}

