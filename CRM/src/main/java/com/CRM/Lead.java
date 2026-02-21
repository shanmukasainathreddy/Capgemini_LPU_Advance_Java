package com.CRM;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lead {
	@Id
	private long id;
	private String source;
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private SalesEmployee se;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SalesEmployee getSe() {
		return se;
	}

	public void setSe(SalesEmployee se) {
		this.se = se;
	}
	

	@Override
	public String toString() {
		return "Lead [id=" + id + ", source=" + source + ", status=" + status + ", se=" + se + "]";
	}
	
	
}
