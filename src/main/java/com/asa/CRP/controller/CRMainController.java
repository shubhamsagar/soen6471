/*
 * 
 */
package com.asa.CRP.controller;

import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;


/**
 * The Class CRMainController.
 */
@Controller
public class CRMainController {
	
/** The logger. */
private Logger logger = Logger.getLogger(CRMainController.class);
	
	/** Properties file loader. */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/** Property. */
	protected Properties property = propertiesLoader.getMiscProperties();
	
	/**
	 * Login.
	 *
	 * @param httpSession the http session
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/crmain", method = RequestMethod.GET)
	public String login(HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)) {
			return "crmain";
		}
		else {
		return "login";
		}
		}
}
