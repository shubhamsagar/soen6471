package com.asa.CRP.controller;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Plan;
import com.asa.CRP.model.Ticket;
import com.asa.CRP.service.CustomerService;
import com.asa.CRP.service.PlanService;
import com.asa.CRP.service.TicketService;

@Controller
public class ViewUserTicketsRaised {

private Logger logger = Logger.getLogger(CustomerRepresentativeController.class);
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private CustomerService customerService;
	/**
	 * Properties file loader 
	 */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/**
	 * Property	
	 */
	protected Properties property = propertiesLoader.getMiscProperties();
		
	@RequestMapping(value = "/viewticketsforuser/{customerID}", method = RequestMethod.GET)
	public String listCRs(@PathVariable int customerID, ModelMap model) {
		Customer cust=customerService.getCustomerById(customerID);
		List<Ticket> list = ticketService.getTickectsRaisedByCustomer(cust);
		model.addAttribute("viewTickets", list);
		return "viewticketsforuser";
	}
}
