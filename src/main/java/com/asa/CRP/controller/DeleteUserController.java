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
import com.asa.CRP.service.AdminService;

/**
 * @author Chirag Vora
 * @version 1.0
 */

@Controller
public class DeleteUserController {
	
	private Logger logger = Logger.getLogger(DeleteUserController.class);
	
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


	@RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
	public String deleteUser(ModelMap model,HttpSession httpSession) {
		if(Utils.validateCRSession(httpSession)){			
		return "deleteUser";
		}else {
			return "unauthorized";
		}
	}
	
	@RequestMapping(value = "/deleteUserConfirmation", method = RequestMethod.GET)
	public String deleteCR(@RequestParam Map<String,String> reqPar, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
		adminService.deleteUser( Integer.valueOf(reqPar.get("cid")));
	    return "adminmain";  
		}else {
			return "unauthorized";
		}
	}
	
	
}
