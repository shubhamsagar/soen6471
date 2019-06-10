package com.asa.CRP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asa.CRP.dao.CustomerDAO;
import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Plan;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDAO customerDAO;
	
	public void setUserDAO(CustomerDAO customerDAO){
		this.customerDAO = customerDAO;
	}

	@Transactional
	public void updateCustomer(Customer cust) {
		this.customerDAO.updateCustomer(cust);
	}

	@Transactional
	public Customer getCustomerById(int id) {
		return this.customerDAO.getCustomerById(id);
	}

	@Transactional
	public void removeCustomer(int id) {
		this.customerDAO.removeCustomer(id);
	}

	@Transactional
	public List<Customer> listCustomer() {
		return this.listCustomer();
	}

	@Transactional
	public boolean customerExistsCheck(Customer cust) {
		return this.customerDAO.customerExistsCheck(cust);
	}

	@Transactional
	public Customer getCustomerByName(Customer cust) {
		return this.getCustomerByName(cust);
		}

	@Transactional
	public Plan getCustomerActivePlan(Customer cust) {
		return this.customerDAO.getCustomerActivePlan(cust);
	}

	@Transactional
	public int getTickectsRaisedByCustomer(Customer cust) {
		return this.customerDAO.getTickectsRaisedByCustomer(cust);
	}

	@Transactional
	public Customer getCustomerByPhone(Customer cust) {
	return this.customerDAO.getCustomerByPhone(cust);
	}

	@Transactional
	public Customer getCustomerByEmail(Customer cust) {
		return this.customerDAO.getCustomerByEmail(cust);
	}

	@Transactional
	public List<Customer> searchCustomer(String searchBy, String value) {
		return this.customerDAO.searchCustomer(searchBy, value);
	}

}
