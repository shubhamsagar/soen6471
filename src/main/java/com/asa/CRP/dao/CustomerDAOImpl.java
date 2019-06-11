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

import com.asa.CRP.model.Customer;
import com.asa.CRP.model.CustomerRepresentative;
import com.asa.CRP.model.Plan;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	private Logger logger = Logger.getLogger(CustomerDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addCustomer(Customer cust) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(cust);
	}

	
	public void updateCustomer(Customer cust) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cust);	
	}

	
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();		
		Customer cust = (Customer) session.get(Customer.class, new Integer(id));
		return cust;
	}

	
	public void removeCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer cust = (Customer) session.get(Customer.class, new Integer(id));
		if(null != cust){
			session.delete(cust);
		}
	}

	
	public List<Customer> listCustomer() {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> CustomerList = session.createQuery("from Customer").list();
		return CustomerList;
	}

	
	public boolean customerExistsCheck(Customer givenCustomer) {
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> query = builder.createQuery( Customer.class );
		Root<Customer> root = query.from( Customer.class );
		query.select(root).where(
		    builder.and(
		        builder.equal(root.get("custFirstName"), givenCustomer.getCustFirstName()),
		        builder.equal(root.get("custLastName"),givenCustomer.getCustLastName())
		    )
		);
		
		Customer cust = entityManager.createQuery( query ).getSingleResult();
		if(cust != null && givenCustomer.getCustFirstName().equals(cust.getCustLastName())){
			
			return true;
		}
		logger.warn("The Customer was not found");
		return false;
	}

	
	public Customer getCustomerByName(Customer givenCustomer) {
		Customer cust = new Customer();
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> query = builder.createQuery( Customer.class );
		Root<Customer> root = query.from( Customer.class );
		query.select(root).where(
		    builder.and(
		    		 builder.equal(root.get("custFirstName"), givenCustomer.getCustFirstName()),
				        builder.equal(root.get("custLastName"),givenCustomer.getCustLastName())
		    )
		);
		cust = entityManager.createQuery( query ).getSingleResult();
		return cust;
	}

	
	public Plan getCustomerActivePlan(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int getTickectsRaisedByCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	public Customer getCustomerByPhone(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Customer getCustomerByEmail(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Customer> searchCustomer(String searchBy, String value) {
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> query = builder.createQuery( Customer.class );
		Root<Customer> root = query.from( Customer.class );
		query.select(root).where(
		    builder.and(
		        builder.equal(root.get(searchBy),value)
		    )
		);
		List<Customer> cust = entityManager.createQuery( query ).getResultList();
		return cust;
	}

}
