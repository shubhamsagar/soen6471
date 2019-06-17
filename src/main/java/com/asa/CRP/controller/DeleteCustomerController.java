/*
 * 
 */
package com.asa.CRP.controller;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.SearchBy;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Ticket;
import com.asa.CRP.service.CustomerService;
import com.asa.CRP.service.TicketService;


/**
 * The Class DeleteCustomerController.
 */
@Controller
public class DeleteCustomerController {
	
	/** The customer service. */
	@Autowired
	private CustomerService customerService;
	
	/** The ticket service. */
	@Autowired
	private TicketService ticketService;
	
	/** Properties file loader. */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/** Property. */
	protected Properties property = propertiesLoader.getMiscProperties();
	
	
	/**
	 * Searh customer.
	 *
	 * @param model the model
	 * @param httpSession the http session
	 * @return the string
	 */
	@RequestMapping(value = "/deletecustomer", method = RequestMethod.GET)
	public String searhCustomer(ModelMap model,HttpSession httpSession) {
		if(Utils.validateCRSession(httpSession)){
		return "deletecustomer";
		}else {
			return "unauthorized";
		}
	}
	
	/**
	 * Find customer.
	 *
	 * @param reqPar the req par
	 * @param model the model
	 * @param httpSession the http session
	 * @return the string
	 */
	@RequestMapping(value = "/searchdeletecustomer", method = RequestMethod.POST)
	public String findCustomer(@RequestParam Map<String,String> reqPar, ModelMap model,HttpSession httpSession) {
		if(Utils.validateCRSession(httpSession)){
			
		if(reqPar.get("phoneno").length()==10) {
		List<Customer> cust=customerService.searchCustomer(SearchBy.PHONE.getDbName(),reqPar.get("phoneno"));
		if(cust!=null) {
			model.addAttribute("searchdeletecustomer", "RESULT_FOUND"); 
			model.addAttribute("searchdeleteResult", cust);
		  }
		else {
			model.addAttribute("searchdeletecustomer", "RESULTS_NOT_FOUND"); 
			model.addAttribute("searchdeleteResult", "NO CUSTOMER WITH GIVEN PHONE FOUND!");
		}}
		else {
		model.addAttribute("InvalidNumber", "Enter a valid number");
		}
		  return "deletecustomer";
		}else {
			return "unauthorized";
		}
	}

	/**
	 * Delete customer.
	 *
	 * @param customerID the customer ID
	 * @param httpSession the http session
	 * @param model the model
	 * @return the model and view
	 */
	@RequestMapping(value = "/deletecustomerconfirmation/{customerID}", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@PathVariable int customerID, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
			Customer cust= customerService.getCustomerById(customerID);
			List<Ticket> tickList= ticketService.getTickectsRaisedByCustomer(cust);
			for(int i=0;i<tickList.size();i++){
					ticketService.removeTicket(tickList.get(i).getTicketId());
				}
		customerService.removeCustomer(customerID);
		
	  return new ModelAndView("redirect:/crmain");
		//return "crmain";  
		}else {
			return new ModelAndView("redirect:/unauthorized");
			//return "unauthorized";
		}
	}
	
}
