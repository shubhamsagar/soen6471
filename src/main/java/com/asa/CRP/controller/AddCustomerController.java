
package com.asa.CRP.controller;

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
import com.asa.CRP.service.CustomerService;
import com.asa.CRP.service.PlanService;

@Controller
public class AddCustomerController {

private Logger logger = Logger.getLogger(AddCustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PlanService planService;
	
	/**
	 * Properties file loader
	 */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/**
	 * Property	
	 */
	protected Properties property = propertiesLoader.getMiscProperties();
	
	@RequestMapping(value = "/addcustomer", method = RequestMethod.GET)
	public String addCust(ModelMap model) {
		return "addcustomer";
	}

	@RequestMapping(value = "/addcustomerconfirmation", method = RequestMethod.GET)
	public String addCustomer(@RequestParam Map<String,String> reqPar, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
			logger.info("I am writing here");
			Customer customer = new Customer();
			customer.setCustAddress(reqPar.get("address"));
			customer.setCustEmail(reqPar.get("email"));
			customer.setCustFirstName(reqPar.get("firstname"));
			customer.setCustLastName(reqPar.get("lastname"));
			customer.setCustPlan(Integer.valueOf(reqPar.get("plan")));
			customer.setPhoneNumber(Integer.valueOf(reqPar.get("phoneno")));
			customer.setTicketRaised(0);
			customerService.addCustomer(customer);
			return "crmain";
		} else {
			return "unauthorized";
		}
	}
}
