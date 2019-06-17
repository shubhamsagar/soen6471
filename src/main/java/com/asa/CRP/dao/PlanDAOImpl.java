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

import com.asa.CRP.model.Plan;


/**
 * The Class PlanDAOImpl.
 */
@Repository
public class PlanDAOImpl implements PlanDAO{
	
	/** The logger. */
	private Logger logger = Logger.getLogger(PlanDAOImpl.class);

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	

	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.PlanDAO#addPlan(com.asa.CRP.model.Plan)
	 */
	public void addPlan(Plan plan) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(plan);
	}

	
	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.PlanDAO#updatePlan(com.asa.CRP.model.Plan)
	 */
	public void updatePlan(Plan plan) {
		Session session = sessionFactory.getCurrentSession();
		session.update(plan);
	}

	
	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.PlanDAO#getPlanById(int)
	 */
	public Plan getPlanById(int id) {
		Session session = sessionFactory.getCurrentSession();		
		Plan plan = (Plan) session.get(Plan.class, new Integer(id));
		return plan;
	}

	
	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.PlanDAO#removePlan(int)
	 */
	public void removePlan(int id) {
		Session session = sessionFactory.getCurrentSession();
		Plan plan = (Plan) session.get(Plan.class, new Integer(id));
		if(null != plan){
			session.delete(plan);
		}
	}

	
	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.PlanDAO#listPlan()
	 */
	public List<Plan> listPlan() {
		Session session = sessionFactory.getCurrentSession();
		List<Plan> PlanList = session.createQuery("from Plan").list();
		return PlanList;
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.PlanDAO#getPlanByName(com.asa.CRP.model.Plan)
	 */
	public Plan getPlanByName(Plan givenPlan) {
		Plan plan = new Plan();
		System.out.println("Plan is:" + givenPlan.getPlanName());
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Plan> query = builder.createQuery( Plan.class );
		Root<Plan> root = query.from( Plan.class );
		query.select(root).where(
		    builder.and(
		        builder.equal(root.get("planName"), givenPlan.getPlanName())
		    )
		);
		plan = entityManager.createQuery( query ).getSingleResult();
		System.out.println(plan==null);
		return plan;
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.dao.PlanDAO#listPlanByAmount(com.asa.CRP.model.Plan)
	 */
	public List<Plan> listPlanByAmount(Plan givenPlan) {
		
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Plan> query = builder.createQuery( Plan.class );
		Root<Plan> root = query.from( Plan.class );
		query.select(root).where(
		    builder.and(
		        builder.equal(root.get("planAmount"), givenPlan.getPlanAmount())
		    )
		);
		List<Plan> plan = entityManager.createQuery( query ).getResultList();
		return plan;
	}

}
