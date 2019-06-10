package com.asa.CRP.commons;

import javax.servlet.http.HttpSession;

public class Utils {
	
	public static boolean validateCRSession(HttpSession httpSession){
		if(httpSession.getAttribute(Constants.SESSION_LOGGED_IN_FLAG) != null 
				&& (Integer)httpSession.getAttribute(Constants.SESSION_LOGGED_IN_FLAG) == 1){
			return true;
		}
		return false;
	}

}
