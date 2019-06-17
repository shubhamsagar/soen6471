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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Plan;
import com.asa.CRP.service.CustomerService;
import com.asa.CRP.service.PlanService;


/**
 * The Class UpdatePlanController.
 */
@Controller
public class UpdatePlanController {

/** The logger. */
private Logger logger = Logger.getLogger(UpdatePlanController.class);
	
	/** The customer service. */
	@Autowired
	private CustomerService customerService;
	
	/** The plan service. */
	@Autowired
	private PlanService planService;
	
	/** Properties file loader. */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/** Property. */
	protected Properties property = propertiesLoader.getMiscProperties();
	
	/**
	 * Login.
	 *
	 * @param customerID the customer ID
	 * @param model the model
	 * @param httpSession the http session
	 * @return the string
	 */
	@RequestMapping(value = "/updateplan/{customerID}", method = RequestMethod.GET)
	public String login(@PathVariable int customerID, ModelMap model, HttpSession httpSession) {
		if(Utils.validateCRSession(httpSession)) {
			model.addAttribute("customer", customerID);
		List<Plan> list = planService.listPlan();
		model.addAttribute("exploreplans", list);
		return "updateplan";
		}else {
			return "unauthorized";
		}
	}
	
	/**
	 * List C rs.
	 *
	 * @param customerID the customer ID
	 * @param planID the plan ID
	 * @param httpSession the http session
	 * @param model the model
	 * @return the model and view
	 */
	@RequestMapping(value = "/selectupdateplan/{planID}", method = RequestMethod.GET)
	public ModelAndView listCRs(@RequestParam int customerID,@PathVariable int planID, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
			logger.info("I am writing here");
			Customer customer = customerService.getCustomerById(customerID);
			customer.setCustPlan(planID);
			customerService.updateCustomer(customer);
			return new ModelAndView("redirect:/customer/"+customerID);
		} else {
			return new ModelAndView("redirect:/unauthorized");
			
		}
	}
}
