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
import com.asa.CRP.service.CustomerService;

@Controller
public class DeleteCustomerController {
	
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
	
	
	@RequestMapping(value = "/deletecustomer", method = RequestMethod.GET)
	public String searhCustomer(ModelMap model,HttpSession httpSession) {
		if(Utils.validateCRSession(httpSession)){
		return "deletecustomer";
		}else {
			return "unauthorized";
		}
	}
	
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

	@RequestMapping(value = "/deletecustomerconfirmation/{customerID}", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@PathVariable int customerID, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
		customerService.removeCustomer(customerID);
	  return new ModelAndView("redirect:/crmain");
		//return "crmain";  
		}else {
			return new ModelAndView("redirect:/unauthorized");
			//return "unauthorized";
		}
	}
	
}
