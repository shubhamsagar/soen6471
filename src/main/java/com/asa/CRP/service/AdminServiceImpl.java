/**
 * 
 */
package com.asa.CRP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asa.CRP.dao.AdminDAO;
import com.asa.CRP.model.CustomerRepresentative;
import com.asa.CRP.model.Plan;

/**
 * The Class AdminServiceImpl.
 *
 * @author Chirag Vora
 * @version 1.0
 */

@Service
public class AdminServiceImpl implements AdminService{

	/** The admin dao. */

	@Autowired
	private AdminDAO adminDao;

	/**
	 * Sets the user DAO.
	 *
	 * @param adminDao the new user DAO
	 */
	public void setUserDAO(AdminDAO adminDao){
		this.adminDao = adminDao;
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.AdminService#createUser(com.asa.CRP.model.CustomerRepresentative)
	 */
	@Transactional
	public void createUser(CustomerRepresentative cr) {
		this.adminDao.createUser(cr);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.AdminService#deleteUser(int)
	 */
	@Transactional
	public void deleteUser(int id) {
		this.adminDao.deleteUser(id);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.AdminService#listCustomerRepresentatives()
	 */
	@Transactional
	public List<CustomerRepresentative> listCustomerRepresentatives() {
		return this.adminDao.listCustomerRepresentatives();
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.AdminService#addPlans(com.asa.CRP.model.Plan)
	 */
	@Transactional
	public void addPlans(Plan plan) {
		this.adminDao.addPlans(plan);
	}
}
