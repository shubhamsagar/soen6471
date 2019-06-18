/*
 * 
 */
package com.asa.CRP.controller;

import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Ticket;
import com.asa.CRP.service.CustomerService;
import com.asa.CRP.service.TicketService;


/**
 * The Class ViewUserTicketsRaised.
 */
@Controller
public class ViewUserTicketsRaised {

/** The logger. */
private Logger logger = Logger.getLogger(ViewUserTicketsRaised.class);
	
	/** The ticket service. */
	@Autowired
	private TicketService ticketService;
	
	/** The customer service. */
	@Autowired
	private CustomerService customerService;
	
	/** Properties file loader. */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/** Property. */
	protected Properties property = propertiesLoader.getMiscProperties();
		
	/**
	 * List Crs.
	 *
	 * @param customerID the customer ID
	 * @param model the model
	 * @param httpSession the http session
	 * @return the string
	 */
	@RequestMapping(value = "/viewticketsforuser/{customerID}", method = RequestMethod.GET)
	public String listCRs(@PathVariable int customerID, ModelMap model, HttpSession httpSession) {
		if(Utils.validateCRSession(httpSession)){
		Customer cust=customerService.getCustomerById(customerID);
		List<Ticket> list = ticketService.getTickectsRaisedByCustomer(cust);
		model.addAttribute("viewTickets", list);
		return "viewticketsforuser";
		} else {
			return "unauthorized";
			
		}
	}
}
