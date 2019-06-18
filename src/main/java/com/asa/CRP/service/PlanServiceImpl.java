/*
 * 
 */
package com.asa.CRP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asa.CRP.dao.PlanDAO;
import com.asa.CRP.model.Plan;


/**
 * The Class PlanServiceImpl.
 */
@Service
public class PlanServiceImpl implements PlanService{

	/** The plan DAO. */
	@Autowired
	private PlanDAO planDAO;
	
	/**
	 * Sets the plan DAO.
	 *
	 * @param PlanDAO the new plan DAO
	 */
	public void setPlanDAO(PlanDAO PlanDAO){
		this.planDAO = PlanDAO;
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.PlanService#addPlan(com.asa.CRP.model.Plan)
	 */
	@Transactional
	public void addPlan(Plan plan) {
		this.planDAO.addPlan(plan);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.PlanService#updatePlan(com.asa.CRP.model.Plan)
	 */
	@Transactional
	public void updatePlan(Plan plan) {
		this.planDAO.updatePlan(plan);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.PlanService#getPlanById(int)
	 */
	@Transactional
	public Plan getPlanById(int id) {
		this.planDAO.getPlanById(id);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.PlanService#removePlan(int)
	 */
	@Transactional
	public void removePlan(int id) {
	this.planDAO.removePlan(id);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.PlanService#listPlan()
	 */
	@Transactional
	public List<Plan> listPlan() {
		return this.planDAO.listPlan();
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.PlanService#getPlanByName(com.asa.CRP.model.Plan)
	 */
	@Transactional
	public Plan getPlanByName(Plan plan) {
		return this.planDAO.getPlanByName(plan);
	}

	/* (non-Javadoc)
	 * @see com.asa.CRP.service.PlanService#listPlanByAmount(com.asa.CRP.model.Plan)
	 */
	@Transactional
	public List<Plan> listPlanByAmount(Plan plan) {
		return this.planDAO.listPlanByAmount(plan);
	}
	
}
