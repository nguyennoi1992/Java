package com.management.action;

import com.management.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User user = new User();
	
	public String baseLayout() {
		return "baseLayout";
	}
		


}
