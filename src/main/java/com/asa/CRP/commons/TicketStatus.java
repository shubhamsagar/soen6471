/*
 * 
 */
package com.asa.CRP.commons;

// TODO: Auto-generated Javadoc
/**
 * The Enum TicketStatus.
 * @author Shivani Panwar
 * @version 1.0
 */
public enum TicketStatus {
	
	/** The new. */
	NEW("New"),
	
	/** The in progress. */
	IN_PROGRESS("In Progress"),
	
	/** The closed. */
	CLOSED("Closed"),
	
	/** The rejected. */
	REJECTED("Rejected");
	
	/** The dbname. */
	private final String dbname;
	
	/**
	 * Instantiates a new ticket status.
	 *
	 * @param dbname the dbname
	 */
	private TicketStatus(String dbname){
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
