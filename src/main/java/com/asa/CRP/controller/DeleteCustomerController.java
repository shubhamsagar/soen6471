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
	public String searhCustomer(ModelMap model) {
		return "deletecustomer";
	}
	
	@RequestMapping(value = "/searchdeletecustomer", method = RequestMethod.POST)
	public String findCustomer(@RequestParam int phoneno, ModelMap model) {

		List<Customer> cust=customerService.searchCustomer(SearchBy.PHONE.getDbName(), Integer.toString(phoneno));
		if(cust!=null) {
			model.addAttribute("searchdeletecustomer", "RESULT_FOUND"); 
			model.addAttribute("searchdeleteResult", cust);
		  }
		else {
			model.addAttribute("searchdeletecustomer", "RESULTS_NOT_FOUND"); 
			model.addAttribute("searchdeleteResult", "NO CUSTOMER WITH GIVEN PHONE FOUND!");
		}
		  return "deletecustomer";
	}
	
	@RequestMapping(value = "/deletecustomerconfirmation/{customerID}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable int customerID, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
		customerService.removeCustomer(customerID);
	    return "crmain";  
		}else {
			return "aunauthorized";
		}
	}
	
}
