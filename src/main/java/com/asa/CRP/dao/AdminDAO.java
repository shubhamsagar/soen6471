/**
 * 
 */
package com.asa.CRP.dao;

import java.util.List;

import com.asa.CRP.model.CustomerRepresentative;
import com.asa.CRP.model.Plan;

/**
 * @author Chirag
 *
 */
public interface AdminDAO {

	public void createUser(CustomerRepresentative cr);

	public void deleteUser(int id);
	
	public List<CustomerRepresentative> listCustomerRepresentatives();
	
	public void addPlans(Plan plan);
	
	
}
