package com.project.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.project.bean.User;
import com.project.controller.LoginController;
import com.project.utilities.ProjectConstants;

public class LoginAction extends ActionSupport implements ModelDriven<Object>, ProjectConstants{
	
	private static final long serialVersionUID = 1L;
	private User user = new User();
	
	/*
	 * Model Driven method
	 */
	public Object getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	/**
	 * Try to login user into system. First it validates username
	 * and password then look up user in database. It puts 'message' attribute 
	 * to HttpServletRequest and 'loggedin' attribute to Session.
	 * @return		the string which is result of operator (predefined in Struts2) 
	 */
	public String login() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		String msg;
		
		//validate fields
		msg = LoginController.validate(user);
		if (!msg.equals(MSG_SUCCESS)) {
			request.setAttribute("message", LoginController.validate(user));
			return INPUT;
		}
		
		//look up in database
		if (!LoginController.checkExistUser(user)) {
			request.setAttribute("message", MSG_USER_NOTEXISTS);
			return INPUT;
		}
		
		//user logged in.
		session.put("loggedin", TRUE);
		return SUCCESS;
	}
		
	/**
	 * Validate user's email and put result message to Request.
	 * @return		the string which is result of operator
	 */
	public String forgot() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String msg = LoginController.validateEmail(user);
		
		if (msg.equals(MSG_SUCCESS))
			return SUCCESS;
		request.setAttribute("message", msg);
		return INPUT;
	}
	
	/**
	 * Remove 'loggedin' attribute from Session.
	 * @return 		the string which is result of operator
	 */
	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("loggedin");
		session.remove("message");
		return SUCCESS;
	}
	
}
