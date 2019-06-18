/*
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
import org.springframework.web.servlet.ModelAndView;

import com.asa.CRP.commons.CRRoles;
import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.model.CustomerRepresentative;
import com.asa.CRP.service.CustomerRepresentativeService;
import com.asa.CRP.service.TicketService;


/**
 * The Class LoginController.
 */
@Controller
public class LoginController {
	
	/** The logger. */
	private Logger logger = Logger.getLogger(LoginController.class);
	
	/** The customer representative service. */
	@Autowired
	private CustomerRepresentativeService customerRepresentativeService;
	
	/** The ticket service. */
	@Autowired
	private TicketService ticketService;
	
	/** Properties file loader. */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/** Property. */
	protected Properties property = propertiesLoader.getMiscProperties();
	
	

	/**
	 * Login.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Main(ModelMap model) {
		return new ModelAndView("redirect:/login");
	}
	
	/**
	 * Login.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
	
	/**
	 * Login CR.
	 *
	 * @param reqPar the req par
	 * @param httpSession the http session
	 * @param map the map
	 * @return the string
	 */
	@RequestMapping(value = "/customerRepresentativeLoginCheck", method = RequestMethod.POST)
	public String loginCR(@RequestParam Map<String,String> reqPar, HttpSession httpSession, ModelMap map) {	
		CustomerRepresentative cr=new CustomerRepresentative();
		cr.setCrUserName(reqPar.get("login"));
		cr.setCrPassword(reqPar.get("password"));
		
		if(customerRepresentativeService.customerRepresentativeLoginCheck(cr)==true) {
			cr = customerRepresentativeService.getCustomerRepresentativeByUserName(cr);
			httpSession.setAttribute("crLoggedIn", 1);
			httpSession.setAttribute("crId", cr.getId());
			System.out.println("Role is" + cr.getCrRole() + CRRoles.CUSTOMER_REPRESENTATIVE.getDbName());
			if(cr.getCrRole().equals(CRRoles.CUSTOMER_REPRESENTATIVE.getDbName())) {
				return "crmain";
			}
			else if(cr.getCrRole().equals(CRRoles.TECHNICIAN.getDbName())) {
				System.out.println("Ticket is" + ticketService.listTicket().size() +" ---- "+ ticketService.listTicket().toString());
				
				return "technicianmain";
			}else {
				return "adminmain";
			}
		}else {
			map.addAttribute("userNotFoundError", "true");
			return "login";
		}
	}
}
