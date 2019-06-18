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
import com.asa.CRP.model.Plan;
import com.asa.CRP.service.PlanService;

/**
 * The Class AddPlanController.
 *
 * @author Chirag Vora
 * @version 1.0
 */

@Controller
public class AddPlanController {

	/** The logger. */
	private Logger logger = Logger.getLogger(AddPlanController.class);
	
	/** The plan service. */
	@Autowired
	private PlanService planService;
	
	/** Properties file loader. */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/** Property. */
	protected Properties property = propertiesLoader.getMiscProperties();

	/**
	 * Adds the plan.
	 *
	 * @param httpSession the http session
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/addplan", method = RequestMethod.GET)
	public String addPlan( HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){	
		return "addPlans";
		}
		else {
			return "unauthorized";
		}
	}
	
	/**
	 * Creates the plan.
	 *
	 * @param reqPar the req par
	 * @param httpSession the http session
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/addPlanConfirmation", method = RequestMethod.GET)
	public String createPlan(@RequestParam Map<String,String> reqPar, HttpSession httpSession, ModelMap model) {
		if(Utils.validateCRSession(httpSession)){
			logger.info("I am writing in add plans");
			Plan plan = new Plan();
			plan.setPlanName(reqPar.get("planName"));
			plan.setPlanType(reqPar.get("planType"));
			plan.setPlanDuration(reqPar.get("duration"));
			plan.setPlanAmount(Integer.valueOf(reqPar.get("amount")));
			planService.addPlan(plan);
			return "adminmain";
		} else {
			return "unauthorized";
		}
	}
}
