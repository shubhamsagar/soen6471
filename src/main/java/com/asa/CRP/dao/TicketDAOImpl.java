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

@Repository
public class TicketDAOImpl implements TicketDAO{
	

	private Logger logger = Logger.getLogger(TicketDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void updateTicket(Ticket tkt) {
		Session session = sessionFactory.getCurrentSession();
		session.update(tkt);
	}

	public Ticket getTicketById(int id) {
		Session session = sessionFactory.getCurrentSession();		
		Ticket plan = (Ticket) session.get(Ticket.class, new Integer(id));
		return plan;
	}

	public Ticket createTicket(Ticket tkt) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(tkt);
		return tkt;
	}

	
	public void removeTicket(int id) {
		Session session = sessionFactory.getCurrentSession();
		Ticket tkt = (Ticket) session.get(Ticket.class, new Integer(id));
		if(null != tkt){
			session.delete(tkt);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Ticket> listTicket() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Ticket> TicketList = session.createQuery("from Plan").list();
		return TicketList;
	}

	@Override
	public boolean checkStatus(Ticket givenTkt) {
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ticket> query = builder.createQuery( Ticket.class );
		Root<Ticket> root = query.from( Ticket.class );
		query.select(root).where(
		    builder.and(
		        builder.equal(root.get("Status"), "Open"))
		);
		Ticket tkt = entityManager.createQuery( query ).getSingleResult();
		if(tkt != null && givenTkt.equals(tkt.getStatus())){
			return true;
		}
		logger.warn("Ticket has been closed");
		return false;
	}

	@Override
	public List<Ticket> getTickectsRaisedByCustomer(Customer givenCustomer) {
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ticket> query = builder.createQuery( Ticket.class );
		Root<Ticket> root = query.from( Ticket.class );
		query.select(root).where(
		    builder.and(
		        builder.equal(root.get("Raised_By"), givenCustomer.getCustId() ))
		    
		);
		List<Ticket> tkt = entityManager.createQuery( query ).getResultList();
		return tkt;
		
		
	}

}
