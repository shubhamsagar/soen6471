/*
 * 
 */
package com.asa.CRP.commons;

import java.io.IOException;
import java.util.Properties;

/**
 * loader class for the properties files.
 * 
 * @author Shivani Panwar
 * @version 1.0
 *
 */

public final class PropertiesFileLoader {

	/** The web service properties. */
	private static Properties webServiceProperties = new Properties();
	
	/** The misc properties. */
	private static Properties miscProperties = new Properties();


	/** The loader. */
	private static PropertiesFileLoader loader;

    /**
     * Private constructor .
     */
	private PropertiesFileLoader() {
		try {
			webServiceProperties
					.load(PropertiesFileLoader.class.getClassLoader().getResourceAsStream("database.properties"));
			miscProperties.load(PropertiesFileLoader.class.getClassLoader().getResourceAsStream("Misc.properties"));
		} catch (IOException e) {
			//logger.error("Error loading webservices service properties file");
		}
	}

    /**
     * Method to get singlton instance of PropertiesFileLoader Class .
     *
     * @return PropertiesFileLoader
     */
	public static PropertiesFileLoader getInstance() {
		if (loader == null) {
			return new PropertiesFileLoader();
		}
		return loader;
	}

    /**
     * Method to get the instance of the properties file .
     *
     * @return Properties
     */
	
	public Properties getDatabaseProperties() {
		return webServiceProperties;
	}
	
	/**
	 * Gets the misc properties.
	 *
	 * @return the misc properties
	 */
	public Properties getMiscProperties() {
		return miscProperties;
	}

}
