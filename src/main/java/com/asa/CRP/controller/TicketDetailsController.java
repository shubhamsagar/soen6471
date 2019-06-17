/*
 * 
 */
package com.asa.CRP.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.Ticket;
import com.asa.CRP.service.CustomerRepresentativeService;
import com.asa.CRP.service.CustomerService;
import com.asa.CRP.service.TicketService;



/**
 * The Class TicketDetailsController.
 */
@Controller
public class TicketDetailsController {
	
	    /** The ticket service. */
    	@Autowired
     	private TicketService ticketService;
	    
	    /** The customer service. */
    	@Autowired
	    private CustomerService customerService;
	    

	    /** The customer representative service. */
    	@Autowired
	    private CustomerRepresentativeService customerRepresentativeService;
	
	    /** The Constant log. */
    	private static final Logger log = Logger.getLogger(TicketDetailsController.class);	
		
		/** Properties file loader. */
		protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

		/**
		 * Property.
		 *
		 * @param ticketId the ticket id
		 * @param model the model
		 * @param httpSession the http session
		 * @return the string
		 */
		
		@RequestMapping(value="/ticketdetails/{ticketId}", method=RequestMethod.GET)
		public String list(@PathVariable int ticketId, ModelMap model,HttpSession httpSession) {
			if(Utils.validateCRSession(httpSession)) {
				Ticket tkt=ticketService.getTicketById(ticketId);
			log.info("ticketdetail"+tkt.toString());
			model.addAttribute("ticketId",tkt.getTicketId());
			model.addAttribute("raisedBy",customerRepresentativeService.getCustomerRepresentativeById(tkt.getRaisedBy()).getCrFirstName()+" "+customerRepresentativeService.getCustomerRepresentativeById(tkt.getRaisedBy()).getCrLastName());
			model.addAttribute("raisedFor",customerService.getCustomerById(tkt.getRaisedFor()).getCustFirstName()+" "+customerService.getCustomerById(tkt.getRaisedFor()).getCustLastName());
			model.addAttribute("issue",tkt.getIssue());
			model.addAttribute("comments",tkt.getComments());
			model.addAttribute("status",tkt.getStatus());
			return "ticketdetails";
			}
			else {
				return "login";
			}
		}
		
		/**
		 * Edits the comment.
		 *
		 * @param ticketId the ticket id
		 * @param reqParam the req param
		 * @param model the model
		 * @param httpSession the http session
		 * @return the string
		 */
		@RequestMapping(value="/updateticketcomment/{ticketId}", method=RequestMethod.GET)
		public String editComment(@PathVariable int ticketId,@RequestParam Map<String,String> reqParam, ModelMap model,HttpSession httpSession) {
			if(Utils.validateCRSession(httpSession)) {
				Ticket tkt=ticketService.getTicketById(ticketId);
			tkt.setComments(reqParam.get("comments"));
			tkt.setStatus(reqParam.get("status"));
			ticketService.updateTicket(tkt);
			return "technicianmain";
			}
			else {
				return "login";
			}
			
		}
				
}
