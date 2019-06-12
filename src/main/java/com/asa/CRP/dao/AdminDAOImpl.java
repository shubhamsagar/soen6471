/**
 * 
 */
package com.asa.CRP.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asa.CRP.model.CustomerRepresentative;
import com.asa.CRP.model.Plan;


/**
 * The Class AdminDAOImpl.
 *
 * @author Chirag Vora
 * @version 1.0
 */

@Repository
public class AdminDAOImpl implements AdminDAO{

	/** The logger. */
	private Logger logger = Logger.getLogger(AdminDAOImpl.class);

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.AdminDAO#createUser(com.asa.CRP.model.CustomerRepresentative)
	 */
	public void createUser(CustomerRepresentative cr) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(cr);	
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.AdminDAO#deleteUser(int)
	 */
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		CustomerRepresentative cr = (CustomerRepresentative) session.get(CustomerRepresentative.class, new Integer(id));
		if(null != cr){
			session.delete(cr);	
		}	
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.AdminDAO#listCustomerRepresentatives()
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<CustomerRepresentative> listCustomerRepresentatives() {
		Session session = sessionFactory.getCurrentSession();
		List<CustomerRepresentative> crList = session.createQuery("from CustomerRepresentative").list();
		return crList;
	}


	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.AdminDAO#addPlans(com.asa.CRP.model.Plan)
	 */
	public void addPlans(Plan plan) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(plan);
	}
}
