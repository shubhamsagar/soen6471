package com.asa.CRP.dao;

import java.util.List;

import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Ticket;

public interface TicketDAO {

	public void updateTicket(Ticket tkt);
	
	public Ticket getTicketById(int id);
	
	public Ticket createTicket(Ticket tkt);
	
	public void removeTicket(int id);
	
	public List<Ticket> listTicket();
	
	public boolean checkStatus(Ticket tkt);
	
	public List<Ticket> getTickectsRaisedByCustomer(Customer cust);
	
}
