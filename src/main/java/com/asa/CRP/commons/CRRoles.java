package com.asa.CRP.commons;

public enum CRRoles {
	CUSTOMER_REPRESENTATIVE("Customer Representative"),
	ADMIN("Admin"),
	TECHNICIAN("Technician");
	
	private final String dbname;
	
	private CRRoles(String dbname){
		this.dbname = dbname;
	}
	
	public String getDbName(){
		return dbname;
	}
}
