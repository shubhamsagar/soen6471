/**
 * 
 */
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
import com.asa.CRP.service.AdminService;

/**
 * @author Chirag Vora
 * @version 1.0
 *
 */

@Controller
public class ViewUserController {
	
	private Logger logger = Logger.getLogger(ViewUserController.class);
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * Properties file loader
	 */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/**
	 * Property	
	 */
	protected Properties property = propertiesLoader.getMiscProperties();

		
	@RequestMapping(value = "/viewusers", method = RequestMethod.GET)
	public String listCRs(ModelMap model) {
		List<CustomerRepresentative> list = adminService.listCustomerRepresentatives();
		model.addAttribute("viewusers", list);
		return "viewusers";
	}
}
