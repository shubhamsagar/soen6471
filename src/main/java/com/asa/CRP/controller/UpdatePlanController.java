package com.asa.CRP.controller;

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
import com.asa.CRP.model.Plan;
import com.asa.CRP.service.CustomerService;
import com.asa.CRP.service.PlanService;

@Controller
public class UpdatePlanController {
private Logger logger = Logger.getLogger(CustomerController.class);
	
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
	
	@RequestMapping(value = "/updateplan", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "updateplan";
	}
	
	@RequestMapping(value = "/selectupdateplan/{customerID}", method = RequestMethod.GET)
	public String listCRs(@PathVariable int customerID, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
			logger.info("I am writing here");
			Customer customer = customerService.getCustomerById(customerID);
			Plan plan=new Plan();
			plan.setPlanName("NO PLAN");
			planService.getPlanByName(plan);
			customer.setCustPlan(plan);
			customerService.updateCustomer(customer);
			return "customer";
		} else {
			return "unauthorized";
		}
	}
}
