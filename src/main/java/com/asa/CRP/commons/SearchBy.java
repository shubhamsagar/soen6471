package com.asa.CRP.commons;

public enum SearchBy {

	FIRSTNAME("custFirstName"),
	LASTNAME("custLastName"),
	PHONE("phoneNumber"),
	EMAIL("custEmail"),
	ID("custId");
	
	private final String dbname;
	
	private SearchBy(String dbname){
		this.dbname = dbname;
	}
	
	public String getDbName(){
		return dbname;
	}
	
}
