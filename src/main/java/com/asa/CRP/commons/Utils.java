/*
 * 
 */
package com.asa.CRP.commons;

import javax.servlet.http.HttpSession;

/**
 * The Class Utils.
 * @author Shivani Panwar
 * @version 1.0
 */
public class Utils {
	
	/**
	 * Validate CR session.
	 *
	 * @param httpSession the http session
	 * @return true, if successful
	 */
	public static boolean validateCRSession(HttpSession httpSession){
		if(httpSession.getAttribute(Constants.SESSION_LOGGED_IN_FLAG) != null 
				&& (Integer)httpSession.getAttribute(Constants.SESSION_LOGGED_IN_FLAG) == 1){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if is number.
	 *
	 * @param str the str
	 * @return true, if is number
	 */
	public static boolean isNumber(String str) {
	    return str.matches("-?\\d+(\\.\\d+)?");
	}
}
