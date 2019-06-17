/*
 * 
 */
package com.asa.CRP.commons;

/**
 * The Enum SearchBy.
 * @author Shivani Panwar
 * @version 1.0
 */
public enum SearchBy {

	/** The firstname. */
	FIRSTNAME("custFirstName"),
	
	/** The lastname. */
	LASTNAME("custLastName"),
	
	/** The phone. */
	PHONE("phoneNumber"),
	
	/** The email. */
	EMAIL("custEmail"),
	
	/** The id. */
	ID("custId");
	
	/** The dbname. */
	private final String dbname;
	
	/**
	 * Instantiates a new search by.
	 *
	 * @param dbname the dbname
	 */
	private SearchBy(String dbname){
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
