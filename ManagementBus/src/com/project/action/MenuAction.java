package com.project.action;

import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.UserBean;

public class MenuAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserBean user = new UserBean();
	
	public String baseLayout() {
		return "baseLayout";
	}
		


}
