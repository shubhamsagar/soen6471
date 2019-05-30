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
 * The Class CustomerRepresentative.
 * 
 * @author Shivani Panwar
 * @version 1.0
 */
@Entity
@Table(name = "c_representatives")
public class CustomerRepresentative implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5372010752544109811L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id", unique = true)
	private String id;
	
	/** The cr first name. */
	@Column(name="First_Name", length = 50)
	private String crFirstName;
	
	/** The cr last name. */
	@Column(name="Last_Name", length = 50)
	private String crLastName;
	
	/** The cr user name. */
	@Column(name="User_Name", length = 50, unique = true)
	private String crUserName;
	
	/** The cr password. */
	@Column(name="Password", length = 50)
	private String crPassword;
	
	/** The cr role. */
	@Column(name="cr_Role", length = 30)
	private String crRole;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the cr first name.
	 *
	 * @return the cr first name
	 */
	public String getCrFirstName() {
		return crFirstName;
	}
	
	/**
	 * Sets the cr first name.
	 *
	 * @param crFirstName the new cr first name
	 */
	public void setCrFirstName(String crFirstName) {
		this.crFirstName = crFirstName;
	}
	
	/**
	 * Gets the cr last name.
	 *
	 * @return the cr last name
	 */
	public String getCrLastName() {
		return crLastName;
	}
	
	/**
	 * Sets the cr last name.
	 *
	 * @param crLastName the new cr last name
	 */
	public void setCrLastName(String crLastName) {
		this.crLastName = crLastName;
	}
	
	/**
	 * Gets the cr user name.
	 *
	 * @return the cr user name
	 */
	public String getCrUserName() {
		return crUserName;
	}
	
	/**
	 * Sets the cr user name.
	 *
	 * @param crUserName the new cr user name
	 */
	public void setCrUserName(String crUserName) {
		this.crUserName = crUserName;
	}
	
	/**
	 * Gets the cr password.
	 *
	 * @return the cr password
	 */
	public String getCrPassword() {
		return crPassword;
	}
	
	/**
	 * Sets the cr password.
	 *
	 * @param crPassword the new cr password
	 */
	public void setCrPassword(String crPassword) {
		this.crPassword = crPassword;
	}
	
	/**
	 * Gets the cr role.
	 *
	 * @return the cr role
	 */
	public String getCrRole() {
		return crRole;
	}
	
	/**
	 * Sets the cr role.
	 *
	 * @param crRole the new cr role
	 */
	public void setCrRole(String crRole) {
		this.crRole = crRole;
	} 

}
