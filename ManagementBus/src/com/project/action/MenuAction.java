package com.project.action;

import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.User;

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
