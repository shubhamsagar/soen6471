/*
 * 
 */
package com.asa.CRP.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Customer.
 * 
 * @author Chirag Vora
 * @version 1.0
 */
@Entity
@Table(name = "c_customer")
public class Customer implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2979276523681580807L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="Customer_Id", length=10, unique = true)
	private int custId;
	
	/** The phone number. */
	@Column(name="Phone", length=10, unique = true)
	private long phoneNumber;
	
	/** The cust first name. */
	@Column(name="First_Name", length = 50)
	private String custFirstName;
	
	/** The cust last name. */
	@Column(name="Last_Name", length = 50)
	private String custLastName;
	
	/** The cust email. */
	@Column(name="Email", length = 30)
	private String custEmail;
	
	/** The cust address. */
	@Column(name="Address", length = 150)
	private String custAddress;
	
	/** The cust plan. */
	@Column(name="Customer_Plan", length = 200)
	private int custPlan;
	
	/** The ticket raised. */
	@Column(name="Tickets_Raised", length = 200)
	private int ticketsRaised;

	/**
	 * Gets the cust id.
	 *
	 * @return the custId
	 */
	public int getCustId() {
		return custId;
	}

	/**
	 * Sets the cust id.
	 *
	 * @param custId the custId to set
	 */
	public void setCustId(int custId) {
		this.custId = custId;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phoneNumber
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the cust first name.
	 *
	 * @return the custFirstName
	 */
	public String getCustFirstName() {
		return custFirstName;
	}

	/**
	 * Sets the cust first name.
	 *
	 * @param custFirstName the custFirstName to set
	 */
	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	/**
	 * Gets the cust last name.
	 *
	 * @return the custLastName
	 */
	public String getCustLastName() {
		return custLastName;
	}

	/**
	 * Sets the cust last name.
	 *
	 * @param custLastName the custLastName to set
	 */
	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	/**
	 * Gets the cust email.
	 *
	 * @return the custEmail
	 */
	public String getCustEmail() {
		return custEmail;
	}

	/**
	 * Sets the cust email.
	 *
	 * @param custEmail the custEmail to set
	 */
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	/**
	 * Gets the cust address.
	 *
	 * @return the custAddress
	 */
	public String getCustAddress() {
		return custAddress;
	}

	/**
	 * Sets the cust address.
	 *
	 * @param custAddress the custAddress to set
	 */
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	/**
	 * Gets the cust plan.
	 *
	 * @return the custPlan
	 */
	public int getCustPlan() {
		return custPlan;
	}

	/**
	 * Sets the cust plan.
	 *
	 * @param custPlan the custPlan to set
	 */
	public void setCustPlan(int custPlan) {
		this.custPlan = custPlan;
	}

	/**
	 * Gets the ticket raised.
	 *
	 * @return the ticketRaised
	 */
	public int getTicketRaised() {
		return ticketsRaised;
	}

	/**
	 * Sets the ticket raised.
	 *
	 * @param ticketRaised the ticketRaised to set
	 */
	public void setTicketRaised(int ticketRaised) {
		this.ticketsRaised = ticketRaised;
	}
}
