/*
 * 
 */
package com.asa.CRP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asa.CRP.dao.CustomerRepresentativeDAO;
import com.asa.CRP.model.CustomerRepresentative;


/**
 * The Class CustomerRepresentativeServiceImpl.
 *
 * @author Shivani
 */

@Service
public class CustomerRepresentativeServiceImpl implements CustomerRepresentativeService {

	/** The customer representative DAO. */
	@Autowired
	private CustomerRepresentativeDAO customerRepresentativeDAO;
	
	/**
	 * Sets the user DAO.
	 *
	 * @param customerRepresentativeDAO the new user DAO
	 */
	public void setUserDAO(CustomerRepresentativeDAO customerRepresentativeDAO){
		this.customerRepresentativeDAO = customerRepresentativeDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerRepresentativeService#addCustomerRepresentative(com.asa.CRP.model.CustomerRepresentative)
	 */
	@Transactional
	public void addCustomerRepresentative(CustomerRepresentative cr) {
		this.customerRepresentativeDAO.addCustomerRepresentative(cr);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerRepresentativeService#updateCustomerRepresentative(com.asa.CRP.model.CustomerRepresentative)
	 */
	@Transactional
	public void updateCustomerRepresentative(CustomerRepresentative cr) {
		this.customerRepresentativeDAO.updateCustomerRepresentative(cr);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerRepresentativeService#getCustomerRepresentativeById(int)
	 */
	@Transactional
	public CustomerRepresentative getCustomerRepresentativeById(int id) {
		return this.customerRepresentativeDAO.getCustomerRepresentativeById(id);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerRepresentativeService#removeCustomerRepresentative(int)
	 */
	@Transactional
	public void removeCustomerRepresentative(int id) {
		this.customerRepresentativeDAO.removeCustomerRepresentative(id);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerRepresentativeService#listCustomerRepresentatives()
	 */
	@Transactional
	public List<CustomerRepresentative> listCustomerRepresentatives() {
		return this.customerRepresentativeDAO.listCustomerRepresentatives();
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerRepresentativeService#customerRepresentativeLoginCheck(com.asa.CRP.model.CustomerRepresentative)
	 */
	@Transactional
	public boolean customerRepresentativeLoginCheck(CustomerRepresentative cr) {
		return this.customerRepresentativeDAO.customerRepresentativeLoginCheck(cr);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.CustomerRepresentativeService#getCustomerRepresentativeByUserName(com.asa.CRP.model.CustomerRepresentative)
	 */
	@Transactional
	public CustomerRepresentative getCustomerRepresentativeByUserName(CustomerRepresentative cr) {
		return this.customerRepresentativeDAO.getCustomerRepresentativeByUserName(cr);
	}

}
