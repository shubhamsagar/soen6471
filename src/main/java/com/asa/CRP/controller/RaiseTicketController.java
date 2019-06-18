/*
 * 
 */
package com.asa.CRP.controller;

import java.sql.Date;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.TicketStatus;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Ticket;
import com.asa.CRP.service.CustomerService;
import com.asa.CRP.service.TicketService;

/**
 * The Class RaiseTicketController.
 */
@Controller
public class RaiseTicketController {

	/** The logger. */
	private Logger logger = Logger.getLogger(RaiseTicketController.class);
	
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
	 * Gets the raise ticket view.
	 *
	 * @param customerId the customer id
	 * @param reqPar the req par
	 * @param httpSession the http session
	 * @param model the model
	 * @return the raise ticket view
	 */
	@RequestMapping(value = "/raiseTicket/{customerId}", method = RequestMethod.POST)
	public String getRaiseTicketView(@PathVariable int customerId, @RequestParam Map<String,String> reqPar, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
			Customer customer = customerService.getCustomerById(customerId);
				System.out.println("id in request " + customerId);
				if(customer.getCustId() == customerId) {
					model.addAttribute("customer", customer);
					return "RaiseTicket";
				}
			model.addAttribute("NoUserFoundInREQUEST", 1);
			return "customer";
		} else {
			return "unauthorized";
		}
	}
	
	/**
	 * Raise ticket.
	 *
	 * @param custId the cust id
	 * @param reqPar the req par
	 * @param httpSession the http session
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/raiseNewTicket/{custId}", method = RequestMethod.POST)
	public String raiseTicket(@PathVariable int custId, @RequestParam Map<String,String> reqPar, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
			if(reqPar.containsKey("issue")){
				Ticket t = ticketService.createTicket(
						new Ticket(new Date(System.currentTimeMillis()), reqPar.get("issue"), (Integer)httpSession.getAttribute("crId"), custId, TicketStatus.NEW.getDbName()));
				model.addAttribute("ticket", t);
				return "crmain";
			}
			return "RaiseTicket";
		} else {
			return "unauthorized";
		}
	}	
}
