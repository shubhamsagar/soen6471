/*
 * 
 */
package com.asa.CRP.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The Class Plans.
 * 
 * @author Chirag Vora
 * @version 1.0
 */
@Entity
@Table(name = "c_plans")
public class Plan implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6279182730809596623L;


	/** The plan ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="Plan_ID", length=10, unique = true)
	private int planID;

	/** The plan name. */
	@Column(name="Plan_Name", length=10, unique = true)
	private String planName;
	
	/** The plan type. */
	@Column(name="Plan_Type", length=10)
	private String planType;
	
	
	/** The plan amount. */
	@Column(name="Plan_Amount", length = 20)
	private int planAmount;
	
	
	/** The plan duration. */
	@Column(name="Plan_Duration", length = 15)
	private String planDuration;

	/**
	 * Gets the plan ID.
	 *
	 * @return the planName
	 */
	public int getPlanID() {
		return planID;
	}


	/**
	 * Sets the plan ID.
	 *
	 * @param planID the planID to set
	 */
	public void setPlanID(int planID) {
		this.planID = planID;
	}


	/**
	 * Gets the plan name.
	 *
	 * @return the planName
	 */
	public String getPlanName() {
		return planName;
	}


	/**
	 * Sets the plan name.
	 *
	 * @param planName the planName to set
	 */
	public void setPlanName(String planName) {
		this.planName = planName;
	}


	/**
	 * Gets the plan type.
	 *
	 * @return the planType
	 */
	public String getPlanType() {
		return planType;
	}


	/**
	 * Sets the plan type.
	 *
	 * @param planType the planType to set
	 */
	public void setPlanType(String planType) {
		this.planType = planType;
	}


	/**
	 * Gets the plan amount.
	 *
	 * @return the planAmount
	 */
	public int getPlanAmount() {
		return planAmount;
	}


	/**
	 * Sets the plan amount.
	 *
	 * @param planAmount the planAmount to set
	 */
	public void setPlanAmount(int planAmount) {
		this.planAmount = planAmount;
	}


	/**
	 * Gets the plan duration.
	 *
	 * @return the planDuration
	 */
	public String getPlanDuration() {
		return planDuration;
	}


	/**
	 * Sets the plan duration.
	 *
	 * @param planDuration the planDuration to set
	 */
	public void setPlanDuration(String planDuration) {
		this.planDuration = planDuration;
	}
	
}
