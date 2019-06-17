/*
 * 
 */
package com.asa.CRP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asa.CRP.dao.TicketDAO;
import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Ticket;

/**
 * The Class TicketServiceImpl.
 */
@Service
public class TicketServiceImpl implements TicketService{
	
	/** The ticket DAO. */
	@Autowired
	private TicketDAO ticketDAO;
	
	/**
	 * Sets the ticket DAO.
	 *
	 * @param ticketDAO the new ticket DAO
	 */
	public void setticketDAO(TicketDAO ticketDAO){
		this.ticketDAO = ticketDAO;
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.TicketService#updateTicket(com.asa.CRP.model.Ticket)
	 */
	@Transactional
	public void updateTicket(Ticket tkt) {
	this.ticketDAO.updateTicket(tkt);	
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.TicketService#getTicketById(int)
	 */
	@Transactional
	public Ticket getTicketById(int id) {
		return this.ticketDAO.getTicketById(id);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.TicketService#createTicket(com.asa.CRP.model.Ticket)
	 */
	@Transactional
	public Ticket createTicket(Ticket tkt) {
		return this.ticketDAO.createTicket(tkt);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.TicketService#removeTicket(int)
	 */
	@Transactional
	public void removeTicket(int id) {
		this.ticketDAO.removeTicket(id);	
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.TicketService#listTicket()
	 */
	@Transactional
	public List<Ticket> listTicket() {
		return this.ticketDAO.listTicket();
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.TicketService#checkStatus(com.asa.CRP.model.Ticket)
	 */
	@Transactional
	public boolean checkStatus(Ticket tkt) {
		return this.ticketDAO.checkStatus(tkt);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.TicketService#getTickectsRaisedByCustomer(com.asa.CRP.model.Customer)
	 */
	@Transactional
	public List<Ticket> getTickectsRaisedByCustomer(Customer cust) {
		return this.ticketDAO.getTickectsRaisedByCustomer(cust);
	}
}
