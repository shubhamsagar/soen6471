/*
 * 
 */
package com.asa.CRP.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.Ticket;
import com.asa.CRP.service.TicketService;


/**
 * The Class TicketTechnicianController.
 */
@Controller
public class TicketTechnicianController {

    /** The Constant log. */
    private static final Logger log = Logger.getLogger(TicketTechnicianController.class);

	/** The ticket service. */
	@Autowired
	TicketService ticketService;
	
	
	/** Properties file loader. */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/**
	 * Property.
	 *
	 * @param httpSession the http session
	 * @param model the model
	 * @return the string
	 */
	
	@RequestMapping(value="/tickettech", method = RequestMethod.GET)
	public String list( HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)) {
		List<Ticket> ticketss =ticketService.listTicket();
		System.out.println("Ticket count:"+ticketss.size() +"--->"+ticketss.toArray().toString());
		model.addAttribute("tickettech", ticketss);
		return "tickettech";
		}else {
			return "unauthorized";
		}
	}
}

