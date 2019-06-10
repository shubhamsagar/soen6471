package com.asa.CRP.controller;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asa.CRP.commons.PropertiesFileLoader;
import com.asa.CRP.model.Plan;
import com.asa.CRP.service.CustomerRepresentativeService;
import com.asa.CRP.service.PlanService;

@Controller
public class ExplorePlanController {

	private Logger logger = Logger.getLogger(CustomerRepresentativeController.class);
	
	@Autowired
	private PlanService planService;
	
	/**
	 * Properties file loader
	 */
	protected PropertiesFileLoader propertiesLoader = PropertiesFileLoader.getInstance();

	/**
	 * Property	
	 */
	protected Properties property = propertiesLoader.getMiscProperties();

		
	@RequestMapping(value = "/exploreplans", method = RequestMethod.GET)
	public String listCRs(ModelMap model) {
		List<Plan> list = planService.listPlan();
		model.addAttribute("exploreplans", list);
		return "exploreplans";
	}
	
}
