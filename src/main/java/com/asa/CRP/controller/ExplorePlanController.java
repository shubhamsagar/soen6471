/*
 * 
 */
package com.asa.CRP.controller;

import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.commons.Utils;
import com.asa.CRP.model.Plan;
import com.asa.CRP.service.PlanService;

/**
 * The Class ExplorePlanController.
 */
@Controller
public class ExplorePlanController {

	/** The logger. */
	private Logger logger = Logger.getLogger(ExplorePlanController.class);
	
	/** The plan service. */
	@Autowired
	private PlanService planService;
	
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
	@RequestMapping(value = "/exploreplans", method = RequestMethod.GET)
	public String listCRs(ModelMap model,HttpSession httpSession) {
		if(Utils.validateCRSession(httpSession)) {
		List<Plan> list = planService.listPlan();
		model.addAttribute("exploreplans", list);
		return "exploreplans";
	}
	else {
		return "login";
	}
	}
	}
