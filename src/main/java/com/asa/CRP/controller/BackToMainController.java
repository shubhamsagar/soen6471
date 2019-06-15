package com.asa.CRP.controller;

import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asa.CRP.commons.CRRoles;
import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.Customer;
import com.asa.CRP.model.CustomerRepresentative;
import com.asa.CRP.service.CustomerRepresentativeService;
import com.asa.CRP.service.CustomerService;
import com.asa.CRP.service.PlanService;

@Controller
public class BackToMainController {

private Logger logger = Logger.getLogger(BackToMainController.class);
	
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
	
	@RequestMapping(value = "/backtomain", method = RequestMethod.GET)
	public ModelAndView toMain(HttpSession httpSession, ModelMap model) {
		
		CustomerRepresentative cr = customerRepresentativeService.getCustomerRepresentativeById(Integer.valueOf(httpSession.getAttribute("crId").toString()));
		if(Utils.validateCRSession(httpSession)){
			
		if(cr.getCrRole().equals(CRRoles.CUSTOMER_REPRESENTATIVE.name())) {
			return new ModelAndView("redirect:/crmain");
				}
		else if(cr.getCrRole().equals(CRRoles.TECHNICIAN.name())) {	
			return new ModelAndView("redirect:/technicianmain");
			
		}else {
			return new ModelAndView("redirect:/adminmain");
			
		}
	}else {
		return new ModelAndView("redirect:/unauthorized");
		}
	}
	
}
