package com.asa.CRP.controller;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.SearchBy;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Plan;
import com.asa.CRP.service.CustomerService;
import com.asa.CRP.service.PlanService;

@Controller
public class CustomerSearchController {
	
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
	
	@RequestMapping(value = "/customersearch", method = RequestMethod.GET)
	public String login(ModelMap model) {
		
		return "customersearch";
	}

	
	@RequestMapping(value = "/customersearch", method = RequestMethod.POST)
	public String findCustomer(@RequestParam Map<String,String> reqPar,HttpSession httpSession, ModelMap model) {
		List<Customer> cust=customerService.searchCustomer(SearchBy.valueOf(reqPar.get("searchBy")).getDbName(), reqPar.get("SearchText"));
		if(Utils.validateCRSession(httpSession)){
		if(cust!=null && cust.size() > 0) {
			model.addAttribute("customerSearchStatus", "RESULT_FOUND"); 
			model.addAttribute("customerSearchResult", cust);
		  }
		else {
			model.addAttribute("customerSearchStatus", "RESULTS_NOT_FOUND"); 
			model.addAttribute("NoUserFoundInREQUEST","No User");
			model.addAttribute("customersearchResult", "NO CUSTOMER WITH GIVEN DETAILS FOUND!");
		}
		return "customersearch";
	}
		else {
			return "unauthorized";
			}
		}
}
