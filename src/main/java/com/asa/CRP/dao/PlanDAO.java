package com.asa.CRP.dao;

import java.util.List;

import com.asa.CRP.model.Plan;


public interface PlanDAO {
	
	public void addPlan(Plan plan);
	
	public void updatePlan(Plan plan);
	
	public Plan getPlanById(int id);
	
	public void removePlan(int id);
	
	public List<Plan> listPlan();
	
	public Plan getPlanByName(Plan plan);
	
	public List<Plan> listPlanByAmount(Plan plan);
	
}
