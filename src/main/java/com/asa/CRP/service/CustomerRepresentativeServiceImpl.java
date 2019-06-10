package com.asa.CRP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asa.CRP.dao.CustomerRepresentativeDAO;
import com.asa.CRP.model.CustomerRepresentative;

/**
 * 
 * @author Shivani
 *
 */

@Service
public class CustomerRepresentativeServiceImpl implements CustomerRepresentativeService {

	@Autowired
	private CustomerRepresentativeDAO customerRepresentativeDAO;
	
	public void setUserDAO(CustomerRepresentativeDAO customerRepresentativeDAO){
		this.customerRepresentativeDAO = customerRepresentativeDAO;
	}
	
	@Transactional
	public void addCustomerRepresentative(CustomerRepresentative cr) {
		this.customerRepresentativeDAO.addCustomerRepresentative(cr);
	}

	@Transactional
	public void updateCustomerRepresentative(CustomerRepresentative cr) {
		this.customerRepresentativeDAO.updateCustomerRepresentative(cr);
	}

	@Transactional
	public CustomerRepresentative getCustomerRepresentativeById(int id) {
		return this.customerRepresentativeDAO.getCustomerRepresentativeById(id);
	}

	@Transactional
	public void removeCustomerRepresentative(int id) {
		this.customerRepresentativeDAO.removeCustomerRepresentative(id);
	}

	@Transactional
	public List<CustomerRepresentative> listCustomerRepresentatives() {
		return this.customerRepresentativeDAO.listCustomerRepresentatives();
	}

	@Transactional
	public boolean customerRepresentativeLoginCheck(CustomerRepresentative cr) {
		return this.customerRepresentativeDAO.customerRepresentativeLoginCheck(cr);
	}

	@Transactional
	public CustomerRepresentative getCustomerRepresentativeByUserName(CustomerRepresentative cr) {
		return this.customerRepresentativeDAO.getCustomerRepresentativeByUserName(cr);
	}

}
