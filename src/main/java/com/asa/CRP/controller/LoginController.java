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

import com.asa.CRP.commons.CRRoles;
import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.model.CustomerRepresentative;
import com.asa.CRP.service.CustomerRepresentativeService;

@Controller
public class LoginController {
	
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
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
	
	
	
	@RequestMapping(value = "/customerRepresentativeLoginCheck", method = RequestMethod.POST)
	public String loginCR(@RequestParam Map<String,String> reqPar, HttpSession httpSession) {
		
		CustomerRepresentative cr=new CustomerRepresentative();
		cr.setCrUserName(reqPar.get("login"));
		cr.setCrPassword(reqPar.get("password"));
		
		if(customerRepresentativeService.customerRepresentativeLoginCheck(cr)==true) {
			cr = customerRepresentativeService.getCustomerRepresentativeByUserName(cr);
			httpSession.setAttribute("crLoggedIn", 1);
			httpSession.setAttribute("crId", cr.getId());
			System.out.println("Role is" + cr.getCrRole() + CRRoles.CUSTOMER_REPRESENTATIVE);
			if(cr.getCrRole().equals(CRRoles.CUSTOMER_REPRESENTATIVE.name())) {
				return "crmain";
			}
			else if(cr.getCrRole().equals(CRRoles.TECHNICIAN)) {
				return "technicianmain";
			}else {
				return "adminmain";
			}
		}else {
		return "login";
		}
	}
	

}
