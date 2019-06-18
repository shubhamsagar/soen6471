/**
 * 
 */
package com.asa.CRP.controller;

import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.CustomerRepresentative;
import com.asa.CRP.service.CustomerRepresentativeService;


/**
 * The Class ViewUserController.
 *
 * @author Chirag Vora
 * @version 1.0
 */

@Controller
public class ViewUserController {

	/** The customer representative service. */
	@Autowired
	private CustomerRepresentativeService customerRepresentativeService;

	/** Properties file loader. */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/** Property. */
	protected Properties property = propertiesLoader.getMiscProperties();

	/**
	 * List C rs.
	 *
	 * @param model the model
	 * @param httpSession the http session
	 * @return the string
	 */
	@RequestMapping(value = "/viewusers", method = RequestMethod.GET)
	public String listCRs(ModelMap model, HttpSession httpSession) {
		if(Utils.validateCRSession(httpSession)){
			List<CustomerRepresentative> list = customerRepresentativeService.listCustomerRepresentatives();
			model.addAttribute("viewusers", list);
			return "viewusers";
		} else {
			return "unauthorized";

		}
	}
}
