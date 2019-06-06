package com.asa.CRP.controller;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.SearchBy;
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
	
	@RequestMapping(value = "/deletecustomer", method = RequestMethod.POST)
	public String findCustomer(@RequestParam String delReq, ModelMap model) {

		List<Customer> cust=customerService.searchCustomer(SearchBy.PHONE.toString(), delReq);
		if(cust!=null) {
			model.addAttribute("deletecustomer", cust);
		  }
		else {
			model.addAttribute("deletecustomer", "NO CUSTOMER WITH GIVEN PHONE FOUND!");
		}
		  return "deletecustomer";
	}
	
	@RequestMapping(value = "/deletecustomer", method = RequestMethod.POST)
	public String deleteCustomer(@RequestParam Customer custDet, ModelMap model) {

		customerService.removeCustomer(custDet.getCustId());
	    return "deletecustomer";
		  
	}
	
}
