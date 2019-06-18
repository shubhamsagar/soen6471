/*
 * 
 */
package com.asa.CRP.dao;

import java.util.List;

import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Plan;


/**
 * The Interface CustomerDAO.
 */
public interface CustomerDAO {

/**
 * Adds the customer.
 *
 * @param cust the cust
 */
public void addCustomer(Customer cust);
	
	/**
	 * Update customer.
	 *
	 * @param cust the cust
	 */
	public void updateCustomer(Customer cust);
	
	/**
	 * Gets the customer by id.
	 *
	 * @param id the id
	 * @return the customer by id
	 */
	public Customer getCustomerById(int id);
	
	/**
	 * Removes the customer.
	 *
	 * @param id the id
	 */
	public void removeCustomer(int id);
	
	/**
	 * List customer.
	 *
	 * @return the list
	 */
	public List<Customer> listCustomer();
	
	/**
	 * Customer exists check.
	 *
	 * @param cust the cust
	 * @return true, if successful
	 */
	public boolean customerExistsCheck(Customer cust);
	
	/**
	 * Gets the customer by name.
	 *
	 * @param cust the cust
	 * @return the customer by name
	 */
	public Customer getCustomerByName(Customer cust);
	
	/**
	 * Gets the customer by phone.
	 *
	 * @param cust the cust
	 * @return the customer by phone
	 */
	public Customer getCustomerByPhone(Customer cust);
	
	/**
	 * Gets the customer by email.
	 *
	 * @param cust the cust
	 * @return the customer by email
	 */
	public Customer getCustomerByEmail(Customer cust);
	
	/**
	 * Gets the customer active plan.
	 *
	 * @param cust the cust
	 * @return the customer active plan
	 */
	public Plan getCustomerActivePlan(Customer cust);
		
	/**
	 * Gets the tickects raised by customer.
	 *
	 * @param cust the cust
	 * @return the tickects raised by customer
	 */
	public int getTickectsRaisedByCustomer(Customer cust);
	
	/**
	 * Search customer.
	 *
	 * @param searchBy the search by
	 * @param value the value
	 * @return the list
	 */
	public List<Customer> searchCustomer(String searchBy, String value);
	
}
