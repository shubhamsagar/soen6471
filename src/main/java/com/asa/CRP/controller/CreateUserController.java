/**
 * 
 */
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
import com.asa.CRP.model.CustomerRepresentative;
import com.asa.CRP.service.CustomerRepresentativeService;

/**
 * The Class CreateUserController.
 *
 * @author Chirag Vora
 * @version 1.0
 */

@Controller
public class CreateUserController {
	
	/** The logger. */
	private Logger logger = Logger.getLogger(CreateUserController.class);
	
	/** The customer representative service. */
	@Autowired
	private CustomerRepresentativeService customerRepresentativeService;
	
	/** Properties file loader. */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/** Property. */
	protected Properties property = propertiesLoader.getMiscProperties();

	/**
	 * Creates the user.
	 *
	 * @param model the model
	 * @param httpSession the http session
	 * @return the string
	 */
	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	public String createUser(ModelMap model,HttpSession httpSession) {
		if(Utils.validateCRSession(httpSession)){
		return "createUser";
		}else {
			return "unauthorized";
			}
	}

	/**
	 * Creates the CR.
	 *
	 * @param reqPar the req par
	 * @param httpSession the http session
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/createCustomerRepresentative", method = RequestMethod.GET)
	public String createCR(@RequestParam Map<String,String> reqPar, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
			logger.info("I am writing here");
			CustomerRepresentative customerRepresentative = new CustomerRepresentative();
			customerRepresentative.setCrFirstName(reqPar.get("firstName"));
			customerRepresentative.setCrLastName(reqPar.get("lastName"));
			customerRepresentative.setCrUserName(reqPar.get("userName"));
			customerRepresentative.setCrPassword(reqPar.get("password"));
			customerRepresentative.setCrRole(reqPar.get("role"));
			customerRepresentativeService.addCustomerRepresentative(customerRepresentative);
			return "adminmain";
		} else {
			return "unauthorized";
		}
	}
}
