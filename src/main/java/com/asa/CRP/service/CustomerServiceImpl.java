/*
 * 
 */
package com.asa.CRP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asa.CRP.dao.CustomerDAO;
import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Plan;


/**
 * The Class CustomerServiceImpl.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
	/** The customer DAO. */
	@Autowired
	private CustomerDAO customerDAO;
	
	/**
	 * Sets the user DAO.
	 *
	 * @param customerDAO the new user DAO
	 */
	public void setUserDAO(CustomerDAO customerDAO){
		this.customerDAO = customerDAO;
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerService#addCustomer(com.asa.CRP.model.Customer)
	 */
	@Transactional
	public void addCustomer(Customer cust) {
	this.customerDAO.addCustomer(cust);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerService#updateCustomer(com.asa.CRP.model.Customer)
	 */
	@Transactional
	public void updateCustomer(Customer cust) {
		this.customerDAO.updateCustomer(cust);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerService#getCustomerById(int)
	 */
	@Transactional
	public Customer getCustomerById(int id) {
		return this.customerDAO.getCustomerById(id);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerService#removeCustomer(int)
	 */
	@Transactional
	public void removeCustomer(int id) {
		this.customerDAO.removeCustomer(id);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerService#listCustomer()
	 */
	@Transactional
	public List<Customer> listCustomer() {
		return this.listCustomer();
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerService#customerExistsCheck(com.asa.CRP.model.Customer)
	 */
	@Transactional
	public boolean customerExistsCheck(Customer cust) {
		return this.customerDAO.customerExistsCheck(cust);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerService#getCustomerByName(com.asa.CRP.model.Customer)
	 */
	@Transactional
	public Customer getCustomerByName(Customer cust) {
		return this.getCustomerByName(cust);
		}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerService#getCustomerActivePlan(com.asa.CRP.model.Customer)
	 */
	@Transactional
	public Plan getCustomerActivePlan(Customer cust) {
		return this.customerDAO.getCustomerActivePlan(cust);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerService#getTickectsRaisedByCustomer(com.asa.CRP.model.Customer)
	 */
	@Transactional
	public int getTickectsRaisedByCustomer(Customer cust) {
		return this.customerDAO.getTickectsRaisedByCustomer(cust);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerService#getCustomerByPhone(com.asa.CRP.model.Customer)
	 */
	@Transactional
	public Customer getCustomerByPhone(Customer cust) {
	return this.customerDAO.getCustomerByPhone(cust);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerService#getCustomerByEmail(com.asa.CRP.model.Customer)
	 */
	@Transactional
	public Customer getCustomerByEmail(Customer cust) {
		return this.customerDAO.getCustomerByEmail(cust);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerService#searchCustomer(java.lang.String, java.lang.String)
	 */
	@Transactional
	public List<Customer> searchCustomer(String searchBy, String value) {
		return this.customerDAO.searchCustomer(searchBy, value);
	}

}
