package com.prac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class StudentEntity {
	@Id
	private int studentid;
	private String name;
	private String gmail;
	private String branch;
	
	@OneToOne
	private AdharCardEntity ac;
	
	@OneToOne
	private HostelRoomEntity HostelRo;
	
	
	public AdharCardEntity getAc() {
		return ac;
	}
	public void setAc(AdharCardEntity ac) {
		this.ac = ac;
	}
	public HostelRoomEntity getHostelRo() {
		return HostelRo;
	}
	public void setHostelRo(HostelRoomEntity hostelRo) {
		HostelRo = hostelRo;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
	@Override
	public String toString() {
		return "StudentEntity [studentid=" + studentid + ", name=" + name + ", gmail=" + gmail + ", branch=" + branch
				+ ", ac=" + ac + ", HostelRo=" + HostelRo + "]";
	}
	
}
