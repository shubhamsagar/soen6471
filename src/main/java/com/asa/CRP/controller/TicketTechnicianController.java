package com.asa.CRP.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.model.Ticket;
import com.asa.CRP.service.TicketService;

@Controller
public class TicketTechnicianController {

    private static final Logger log = Logger.getLogger(CustomerRepresentativeController.class);

	@Autowired
	TicketService ticketService;
	
	
	/**
	 * Properties file loader
	 */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/**
	 * Property	
	 */
	
	@RequestMapping(value="/tickettech", method = RequestMethod.GET)
	public String list(ModelMap model) {
		List<Ticket> ticketss =ticketService.listTicket();
		System.out.println("Ticket count:"+ticketss.size() +"--->"+ticketss.toArray().toString());
		model.addAttribute("tickettech", ticketss);
		return "tickettech";
		
	}
	
	

}

