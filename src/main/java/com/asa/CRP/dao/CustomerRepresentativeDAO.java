package com.asa.CRP.dao;

import java.util.List;

import com.asa.CRP.model.CustomerRepresentative;


/**
 * 
 * @author Shivani
 *
 */
public interface CustomerRepresentativeDAO {
	
	public void addCustomerRepresentative(CustomerRepresentative cr);
	
	public void updateCustomerRepresentative(CustomerRepresentative cr);
	
	public CustomerRepresentative getCustomerRepresentativeById(int id);
	
	public void removeCustomerRepresentative(int id);
	
	public List<CustomerRepresentative> listCustomerRepresentatives();
	
	public boolean customerRepresentativeLoginCheck(CustomerRepresentative cr);
	
	public CustomerRepresentative getCustomerRepresentativeByUserName(CustomerRepresentative cr);

}
