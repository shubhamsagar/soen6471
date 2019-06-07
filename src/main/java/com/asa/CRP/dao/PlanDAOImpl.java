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
import com.asa.CRP.model.Plan;

@Repository
public class PlanDAOImpl implements PlanDAO{
	
	private Logger logger = Logger.getLogger(PlanDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	

	public void addPlan(Plan plan) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(plan);
	}

	
	public void updatePlan(Plan plan) {
		Session session = sessionFactory.getCurrentSession();
		session.update(plan);
	}

	
	public Plan getPlanById(int id) {
		Session session = sessionFactory.getCurrentSession();		
		Plan plan = (Plan) session.get(Plan.class, new Integer(id));
		return plan;
	}

	
	public void removePlan(int id) {
		Session session = sessionFactory.getCurrentSession();
		Plan plan = (Plan) session.get(Plan.class, new Integer(id));
		if(null != plan){
			session.delete(plan);
		}
	}

	
	public List<Plan> listPlan() {
		Session session = sessionFactory.getCurrentSession();
		List<Plan> PlanList = session.createQuery("from Plan").list();
		return PlanList;
	}

	public Plan getPlanByName(Plan givenPlan) {
		Plan plan = new Plan();
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Plan> query = builder.createQuery( Plan.class );
		Root<Plan> root = query.from( Plan.class );
		query.select(root).where(
		    builder.and(
		        builder.equal(root.get("Plan_Name"), givenPlan.getPlanName())
		    )
		);
		plan = entityManager.createQuery( query ).getSingleResult();
		return plan;
	}

	public List<Plan> listPlanByAmount(Plan givenPlan) {
		
		EntityManager entityManager = sessionFactory.createEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Plan> query = builder.createQuery( Plan.class );
		Root<Plan> root = query.from( Plan.class );
		query.select(root).where(
		    builder.and(
		        builder.equal(root.get("Plan_Amount"), givenPlan.getPlanAmount())
		    )
		);
		List<Plan> plan = entityManager.createQuery( query ).getResultList();
		return plan;
	}

}
