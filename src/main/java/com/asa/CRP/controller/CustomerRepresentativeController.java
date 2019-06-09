package com.asa.CRP.controller;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.model.CustomerRepresentative;
import com.asa.CRP.service.CustomerRepresentativeService;

/**
 * 
 * @author Shivani
 *
 */
@Controller
public class CustomerRepresentativeController {
	
	private Logger logger = Logger.getLogger(CustomerRepresentativeController.class);
	
	@Autowired
	private CustomerRepresentativeService customerRepresentativeService;
	
	/**
	 * Properties file loader
	 */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/**
	 * Property	
	 */
	protected Properties property = propertiesLoader.getMiscProperties();

		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCRs(ModelMap model) {
		logger.info("I am writing here");
		List<CustomerRepresentative> list = customerRepresentativeService.listCustomerRepresentatives();
		model.addAttribute("crs", list);
		return "crs";
	}
	
	
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}*/
}
