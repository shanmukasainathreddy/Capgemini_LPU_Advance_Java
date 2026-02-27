package com.CRM;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "support_ticket")
public class SupportTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String issueDescription;
	
	
	
	public SupportTicket() {}



	public SupportTicket(long id, String issueDescription) {
		super();
		this.id = id;
		this.issueDescription = issueDescription;
	}
	
    @ManyToOne
    private Order order;



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getIssueDescription() {
		return issueDescription;
	}



	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}
    
    
    
	
	
}