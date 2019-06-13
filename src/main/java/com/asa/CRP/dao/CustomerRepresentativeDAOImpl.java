package com.asa.CRP.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asa.CRP.model.CustomerRepresentative;

/**
 * 
 * @author Shivani
 *
 */

@Repository
public class CustomerRepresentativeDAOImpl implements CustomerRepresentativeDAO {
	
	private Logger logger = Logger.getLogger(CustomerRepresentativeDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCustomerRepresentative(CustomerRepresentative cr) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(cr);
	}

	public void updateCustomerRepresentative(CustomerRepresentative cr) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cr);	
	}

	public CustomerRepresentative getCustomerRepresentativeById(int id) {
		Session session = sessionFactory.getCurrentSession();		
		CustomerRepresentative cr = (CustomerRepresentative) session.get(CustomerRepresentative.class, new Integer(id));
		return cr;
	}

	public void removeCustomerRepresentative(int id) {
		Session session = sessionFactory.getCurrentSession();
		CustomerRepresentative cr = (CustomerRepresentative) session.get(CustomerRepresentative.class, new Integer(id));
		if(null != cr){
			session.delete(cr);
		}
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<CustomerRepresentative> listCustomerRepresentatives() {
		Session session = sessionFactory.getCurrentSession();
		List<CustomerRepresentative> UsersList = session.createQuery("from CustomerRepresentative").list();
		return UsersList;
	}
	
	public boolean customerRepresentativeLoginCheck(CustomerRepresentative givenCR){
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CustomerRepresentative> query = builder.createQuery( CustomerRepresentative.class );
		Root<CustomerRepresentative> root = query.from( CustomerRepresentative.class );
		query.select(root).where(
		    builder.and(
		        builder.equal(root.get("crUserName"), givenCR.getCrUserName()),
		        builder.equal(root.get("crPassword"), givenCR.getCrPassword())
		    )
		);
		CustomerRepresentative cr = null;
		try {
			cr = entityManager.createQuery( query ).getSingleResult();
		} catch (RuntimeException e){
			logger.error("the following exception occured " + e.getMessage());
		}
		if(cr != null && givenCR.getCrUserName().equals(cr.getCrUserName())){
			
			return true;
		}
		logger.warn("The CR was not found");
		return false;
	}
	
	public CustomerRepresentative getCustomerRepresentativeByUserName(CustomerRepresentative givenCR) {
		CustomerRepresentative cr = new CustomerRepresentative();
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CustomerRepresentative> query = builder.createQuery( CustomerRepresentative.class );
		Root<CustomerRepresentative> root = query.from( CustomerRepresentative.class );
		query.select(root).where(
		    builder.and(
		        builder.equal(root.get("crUserName"), givenCR.getCrUserName())
		    )
		);
		cr = entityManager.createQuery( query ).getSingleResult();
		return cr;
	}
	

}
