package com.asa.CRP.commons;

public enum TicketStatus {
	NEW("New"),
	IN_PROGRESS("In Progress"),
	CLOSED("Closed"),
	REJECTED("Rejected");
	
	private final String dbname;
	
	private TicketStatus(String dbname){
		this.dbname = dbname;
	}
	
	public String getDbName(){
		return dbname;
	}

}
