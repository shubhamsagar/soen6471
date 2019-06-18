/*
 * 
 */
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
import com.asa.CRP.model.Ticket;


/**
 * The Class TicketDAOImpl.
 */
@Repository("TicketDAO")
public class TicketDAOImpl implements TicketDAO{
	

	/** The logger. */
	private Logger logger = Logger.getLogger(TicketDAOImpl.class);

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.TicketDAO#updateTicket(com.asa.CRP.model.Ticket)
	 */
	public void updateTicket(Ticket tkt) {
		Session session = sessionFactory.getCurrentSession();
		session.update(tkt);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.TicketDAO#getTicketById(int)
	 */
	public Ticket getTicketById(int id) {
		Session session = sessionFactory.getCurrentSession();		
		Ticket plan = (Ticket) session.get(Ticket.class, new Integer(id));
		return plan;
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.TicketDAO#createTicket(com.asa.CRP.model.Ticket)
	 */
	public Ticket createTicket(Ticket tkt) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(tkt);
		return tkt;
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.TicketDAO#removeTicket(int)
	 */
	public void removeTicket(int id) {
		Session session = sessionFactory.getCurrentSession();
		Ticket tkt = (Ticket) session.get(Ticket.class, new Integer(id));
		if(null != tkt){
			session.delete(tkt);
		}
	}
	

	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.TicketDAO#listTicket()
	 */
	@SuppressWarnings("deprecation")
	public List<Ticket> listTicket() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Ticket> TicketList = session.createQuery("from Ticket").list();
		return TicketList;
	}

	
	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.TicketDAO#checkStatus(com.asa.CRP.model.Ticket)
	 */
	public boolean checkStatus(Ticket givenTkt) {
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ticket> query = builder.createQuery( Ticket.class );
		Root<Ticket> root = query.from( Ticket.class );
		query.select(root).where(
		    builder.and(
		        builder.equal(root.get("status"), "Open"))
		);
		Ticket tkt = entityManager.createQuery( query ).getSingleResult();
		if(tkt != null && givenTkt.equals(tkt.getStatus())){
			return true;
		}
		logger.warn("Ticket has been closed");
		return false;
	}

	
	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.TicketDAO#getTickectsRaisedByCustomer(com.asa.CRP.model.Customer)
	 */
	public List<Ticket> getTickectsRaisedByCustomer(Customer givenCustomer) {
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ticket> query = builder.createQuery( Ticket.class );
		Root<Ticket> root = query.from( Ticket.class );
		query.select(root).where(
		    builder.and(
		        builder.equal(root.get("raisedFor"), givenCustomer.getCustId() ))
		    
		);
		List<Ticket> tkt = entityManager.createQuery( query ).getResultList();
		return tkt;
		
		
	}

}
