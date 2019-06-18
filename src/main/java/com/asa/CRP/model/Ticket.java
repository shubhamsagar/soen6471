/**
 * 
 */
package com.asa.CRP.model;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "c_tickets")
public class Ticket implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3376074280614690277L;

	/** The ticket id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="Ticket_Id", length=10, unique = true)
	private int ticketId;
	
	
	/** The date. */
	@Column(name="Date")
	private Date date;
	
	
	/** The issue. */
	@Column(name="Issue", length = 50)
	private String issue;
	
	
	/** The raised by. */
	@Column(name="Raised_By", length = 30)
	private int raisedBy;
	
	
	/** The raised for. */
	@Column(name="Raised_For", length = 50)
	private int raisedFor;
	
	/** The status. */
	@Column(name="Status", length = 30)
	private String status;
	
	/** The Comments. */
	@Column(name="Comments", length = 30)
   private String comments;


	
	/**
	 * Instantiates a new ticket.
	 */
	public Ticket(){
		
	}
	
	/**
	 * Instantiates a new ticket.
	 *
	 * @param date the date
	 * @param issue the issue
	 * @param raisedBy the raised by
	 * @param raisedFor the raised for
	 * @param status the status
	 */
	public Ticket(Date date, String issue, Integer raisedBy, Integer raisedFor, String status){
		this.date = date;
		this.issue = issue;
		this.raisedBy = raisedBy;
		this.raisedFor = raisedFor;
		this.status = status;
	}

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
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the date to set
	 */
	public void setDate(Date date) {
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
	public int getRaisedBy() {
		return raisedBy;
	}

	/**
	 * Sets the raised by.
	 *
	 * @param raisedBy the raisedBy to set
	 */
	public void setRaisedBy(int raisedBy) {
		this.raisedBy = raisedBy;
	}

	/**
	 * Gets the raised for.
	 *
	 * @return the raisedFor
	 */
	public int getRaisedFor() {
		return raisedFor;
	}

	/**
	 * Sets the raised for.
	 *
	 * @param raisedFor the raisedFor to set
	 */
	public void setRaisedFor(int raisedFor) {
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
	
	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Sets the status.
	 *
	 * @param comments the new comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

}
