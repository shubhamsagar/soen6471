package com.asa.CRP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asa.CRP.dao.TicketDAO;
import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService{
	@Autowired
	private TicketDAO ticketDAO;
	
	public void setticketDAO(TicketDAO ticketDAO){
		this.ticketDAO = ticketDAO;
	}

	@Transactional
	public void updateTicket(Ticket tkt) {
	this.ticketDAO.updateTicket(tkt);	
	}

	@Transactional
	public Ticket getTicketById(int id) {
		return this.ticketDAO.getTicketById(id);
	}

	@Transactional
	public Ticket createTicket(Ticket tkt) {
		return this.ticketDAO.createTicket(tkt);
	}

	@Transactional
	public void removeTicket(int id) {
		this.ticketDAO.removeTicket(id);	
	}

	@Transactional
	public List<Ticket> listTicket() {
		return this.ticketDAO.listTicket();
	}

	@Transactional
	public boolean checkStatus(Ticket tkt) {
		return this.ticketDAO.checkStatus(tkt);
	}

	@Transactional
	public List<Ticket> getTickectsRaisedByCustomer(Customer cust) {
		return this.ticketDAO.getTickectsRaisedByCustomer(cust);
	}
}
