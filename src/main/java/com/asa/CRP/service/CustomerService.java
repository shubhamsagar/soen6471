package com.asa.CRP.service;

import java.util.List;


import com.asa.CRP.model.Customer;
import com.asa.CRP.model.Plan;

public interface CustomerService {

public void updateCustomer(Customer cust);
	
	public Customer getCustomerById(int id);
	
	public void removeCustomer(int id);
	
	public List<Customer> listCustomer();
	
	public boolean customerExistsCheck(Customer cust);
	
	public Customer getCustomerByName(Customer cust);
	
	public Customer getCustomerByPhone(Customer cust);
	
	public Customer getCustomerByEmail(Customer cust);
	
	public Plan getCustomerActivePlan(Customer cust);
	
	public int getTickectsRaisedByCustomer(Customer cust);
	
	public List<Customer> searchCustomer(String searchBy, String value);
	
	
}
