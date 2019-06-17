/*
 * 
 */
package com.asa.CRP.service;

import java.util.List;

import com.asa.CRP.model.CustomerRepresentative;


/**
 * The Interface CustomerRepresentativeService.
 *
 * @author Shivani
 */

public interface CustomerRepresentativeService {

	/**
	 * Adds the customer representative.
	 *
	 * @param cr the cr
	 */
	public void addCustomerRepresentative(CustomerRepresentative cr);
	
	/**
	 * Update customer representative.
	 *
	 * @param cr the cr
	 */
	public void updateCustomerRepresentative(CustomerRepresentative cr);
	
	/**
	 * Gets the customer representative by id.
	 *
	 * @param id the id
	 * @return the customer representative by id
	 */
	public CustomerRepresentative getCustomerRepresentativeById(int id);
	
	/**
	 * Removes the customer representative.
	 *
	 * @param id the id
	 */
	public void removeCustomerRepresentative(int id);
	
	/**
	 * List customer representatives.
	 *
	 * @return the list
	 */
	public List<CustomerRepresentative> listCustomerRepresentatives();
	
	/**
	 * Customer representative login check.
	 *
	 * @param cr the cr
	 * @return true, if successful
	 */
	public boolean customerRepresentativeLoginCheck(CustomerRepresentative cr);
	
	/**
	 * Gets the customer representative by user name.
	 *
	 * @param cr the cr
	 * @return the customer representative by user name
	 */
	public CustomerRepresentative getCustomerRepresentativeByUserName(CustomerRepresentative cr);
	
}
