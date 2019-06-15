package com.asa.CRP.controller;

import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;

@Controller
public class LogoutController {
/**
	 * Properties file loader
	 */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/**
	 * Property	
	 */
	protected Properties property = propertiesLoader.getMiscProperties();
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession httpSession, ModelMap model) {
		
	 if(Utils.validateCRSession(httpSession)){
		 httpSession.invalidate();
	}else {
		return new ModelAndView("redirect:/login");
		}
	 return new ModelAndView("redirect:/login");
		
	}
}