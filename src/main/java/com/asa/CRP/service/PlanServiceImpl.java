package com.asa.CRP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asa.CRP.dao.PlanDAO;
import com.asa.CRP.model.Plan;


@Service
public class PlanServiceImpl implements PlanService{

	@Autowired
	private PlanDAO planDAO;
	
	public void setPlanDAO(PlanDAO PlanDAO){
		this.planDAO = PlanDAO;
	}

	@Transactional
	public void addPlan(Plan plan) {
		this.planDAO.addPlan(plan);
	}

	@Transactional
	public void updatePlan(Plan plan) {
		this.planDAO.updatePlan(plan);
	}

	@Transactional
	public Plan getPlanById(int id) {
		this.planDAO.getPlanById(id);
		return null;
	}

	@Transactional
	public void removePlan(int id) {
	this.planDAO.removePlan(id);
	}

	@Transactional
	public List<Plan> listPlan() {
		return this.listPlan();
	}

	@Transactional
	public Plan getPlanByName(Plan plan) {
		this.planDAO.getPlanByName(plan);
		return null;
	}

	@Transactional
	public List<Plan> listPlanByAmount(Plan plan) {
		return this.planDAO.listPlanByAmount(plan);
	}
	
}
