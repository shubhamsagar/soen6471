/**
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
 * The Class Tickets.
 *
 * @author Chirag Vora
 * @version 1.0
 */

@Entity
@Table(name = "tickets")
public class Tickets implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3376074280614690277L;

	/** The ticket id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="ticketId", length=10, unique = true)
	private int ticketId;
	
	
	/** The date. */
	@Column(name="date", length=10)
	private String date;
	
	
	/** The issue. */
	@Column(name="issue", length = 50)
	private String issue;
	
	
	/** The raised by. */
	@Column(name="raisedBy", length = 30)
	private String raisedBy;
	
	
	/** The raised for. */
	@Column(name="raisedFor", length = 50)
	private String raisedFor;
	
	/** The status. */
	@Column(name="status", length = 30)
	private String status;

	/**
	 * Gets the ticket id.
	 *
	 * @return the ticketId
	 */
	public int getTicketId() {
		return ticketId;
	}

	/**
	 * Sets the ticket id.
	 *
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the issue.
	 *
	 * @return the issue
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * Sets the issue.
	 *
	 * @param issue the issue to set
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * Gets the raised by.
	 *
	 * @return the raisedBy
	 */
	public String getRaisedBy() {
		return raisedBy;
	}

	/**
	 * Sets the raised by.
	 *
	 * @param raisedBy the raisedBy to set
	 */
	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}

	/**
	 * Gets the raised for.
	 *
	 * @return the raisedFor
	 */
	public String getRaisedFor() {
		return raisedFor;
	}

	/**
	 * Sets the raised for.
	 *
	 * @param raisedFor the raisedFor to set
	 */
	public void setRaisedFor(String raisedFor) {
		this.raisedFor = raisedFor;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
