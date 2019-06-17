/*
 * 
 */
package com.asa.CRP.commons;

/**
 * The Enum CRRoles.
 * @author Shivani Panwar
 * @version 1.0
 */
public enum CRRoles {
	
	/** The customer representative. */
	CUSTOMER_REPRESENTATIVE("Customer Representative"),
	
	/** The admin. */
	ADMIN("Admin"),
	
	/** The technician. */
	TECHNICIAN("Technician");
	
	/** The dbname. */
	private final String dbname;
	
	/**
	 * Instantiates a new CR roles.
	 *
	 * @param dbname the dbname
	 */
	private CRRoles(String dbname){
		this.dbname = dbname;
	}
	
	/**
	 * Gets the db name.
	 *
	 * @return the db name
	 */
	public String getDbName(){
		return dbname;
	}
}
