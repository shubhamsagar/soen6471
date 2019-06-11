/**
 * 
 */
package com.asa.CRP.service;

import java.util.List;

import com.asa.CRP.model.CustomerRepresentative;
import com.asa.CRP.model.Plan;


/**
 * The Interface AdminService.
 *
 * @author Chirag Vora
 * @version 1.0
 */
public interface AdminService {

	/**
	 * Creates the user.
	 *
	 * @param cr the cr
	 */
	public void createUser(CustomerRepresentative cr);

	/**
	 * Delete user.
	 *
	 * @param id the id
	 */
	public void deleteUser(int id);

	/**
	 * List customer representatives.
	 *
	 * @return the list
	 */
	public List<CustomerRepresentative> listCustomerRepresentatives();

	/**
	 * Adds the plans.
	 *
	 * @param plan the plan
	 */
	public void addPlans(Plan plan);
}
