package com.asa.CRP.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "c_representatives")
public class CustomerRepresentative implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5372010752544109811L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private int id;
	
	@Column(name="First_Name", length = 100)
	private String crFirstName;
	
	@Column(name="Last_Name", length = 100)
	private String crLastName;
	
	@Column(name="User_Name", length = 100, unique = true)
	private String crUserName;
	
	@Column(name="Password", length = 100)
	private String crPassword;
	
	@Column(name="cr_Role", length = 100)
	private String crRole;
	
	public String getCrFirstName() {
		return crFirstName;
	}
	public void setCrFirstName(String crFirstName) {
		this.crFirstName = crFirstName;
	}
	public String getCrLastName() {
		return crLastName;
	}
	public void setCrLastName(String crLastName) {
		this.crLastName = crLastName;
	}
	public String getCrUserName() {
		return crUserName;
	}
	public void setCrUserName(String crUserName) {
		this.crUserName = crUserName;
	}
	public String getCrPassword() {
		return crPassword;
	}
	public void setCrPassword(String crPassword) {
		this.crPassword = crPassword;
	}
	public String getCrRole() {
		return crRole;
	}
	public void setCrRole(String crRole) {
		this.crRole = crRole;
	} 

}
