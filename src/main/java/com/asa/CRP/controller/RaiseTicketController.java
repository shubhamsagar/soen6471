package com.asa.CRP.controller;

import java.sql.Date;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Ticket;
import com.asa.CRP.service.CustomerService;
import com.asa.CRP.service.TicketService;

@Controller
public class RaiseTicketController {

	private Logger logger = Logger.getLogger(RaiseTicketController.class);
	
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
	
	@RequestMapping(value = "/raiseTicket", method = RequestMethod.POST)
	public String getRaiseTicketView(@RequestParam Map<String,String> reqPar, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
			Customer customer = null;
			if(model.containsAttribute("customer")){
				try {
					customer = (Customer)model.get("customer");
				} catch (RuntimeException e) {
					logger.error("EXception occuerd while finding Customer in model" + e.getMessage());
				}
			}
			if(reqPar.containsKey("customerID")){
				if(customer == null){
					customer = customerService.getCustomerById(Integer.valueOf(reqPar.get("customerID")));
					System.out.println("id found " + customer.getCustId());
				}
				System.out.println("id in request " + Integer.valueOf(reqPar.get("customerID")));
				if(customer.getCustId() == Integer.valueOf(reqPar.get("customerID"))) {
					model.addAttribute("customer", customer);
					return "RaiseTicket";
				}
			} 
			model.addAttribute("NoUserFoundInREQUEST", 1);
			return "customer";
		} else {
			return "unauthorized";
		}
	}
	
	@RequestMapping(value = "/raiseNewTicket", method = RequestMethod.POST)
	public String raiseTicket(@RequestParam Map<String,String> reqPar, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
			if(reqPar.containsKey("customerID") && reqPar.containsKey("issue")){
				Ticket t = ticketService.createTicket(
						new Ticket(new Date(System.currentTimeMillis()), reqPar.get("issue"), (Integer)httpSession.getAttribute("crId"), Integer.valueOf(reqPar.get("customerID")), "open"));
				model.addAttribute("ticket", t);
				return "crmain";
			}
			return "error";
		} else {
			return "unauthorized";
		}
	}
	
	

		
	
}
