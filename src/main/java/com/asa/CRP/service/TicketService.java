/*
 * 
 */
package com.asa.CRP.service;

import java.util.List;

import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Ticket;

/**
 * The Interface TicketService.
 */
public interface TicketService {

/**
 * Update ticket.
 *
 * @param tkt the tkt
 */
public void updateTicket(Ticket tkt);
	
	/**
	 * Gets the ticket by id.
	 *
	 * @param id the id
	 * @return the ticket by id
	 */
	public Ticket getTicketById(int id);
	
	/**
	 * Creates the ticket.
	 *
	 * @param tkt the tkt
	 * @return the ticket
	 */
	public Ticket createTicket(Ticket tkt);
	
	/**
	 * Removes the ticket.
	 *
	 * @param id the id
	 */
	public void removeTicket(int id);
	
	/**
	 * List ticket.
	 *
	 * @return the list
	 */
	public List<Ticket> listTicket();
	
	/**
	 * Check status.
	 *
	 * @param tkt the tkt
	 * @return true, if successful
	 */
	public boolean checkStatus(Ticket tkt);
	
	/**
	 * Gets the tickects raised by customer.
	 *
	 * @param cust the cust
	 * @return the tickects raised by customer
	 */
	public List<Ticket> getTickectsRaisedByCustomer(Customer cust);
	
}
