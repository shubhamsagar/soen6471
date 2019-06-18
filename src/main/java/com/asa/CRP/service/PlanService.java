/*
 * 
 */
package com.asa.CRP.service;

import java.util.List;


import com.asa.CRP.model.Plan;


/**
 * The Interface PlanService.
 */
public interface PlanService {
	
	/**
	 * Adds the plan.
	 *
	 * @param plan the plan
	 */
	public void addPlan(Plan plan);
	
	/**
	 * Update plan.
	 *
	 * @param plan the plan
	 */
	public void updatePlan(Plan plan);
	
	/**
	 * Gets the plan by id.
	 *
	 * @param id the id
	 * @return the plan by id
	 */
	public Plan getPlanById(int id);
	
	/**
	 * Removes the plan.
	 *
	 * @param id the id
	 */
	public void removePlan(int id);
	
	/**
	 * List plan.
	 *
	 * @return the list
	 */
	public List<Plan> listPlan();
	
	/**
	 * Gets the plan by name.
	 *
	 * @param plan the plan
	 * @return the plan by name
	 */
	public Plan getPlanByName(Plan plan);
	
	/**
	 * List plan by amount.
	 *
	 * @param plan the plan
	 * @return the list
	 */
	public List<Plan> listPlanByAmount(Plan plan);

}
