package com.management.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.management.bo.impl.UserBOImpl;
import com.management.model.User;
import com.management.utils.ProjectConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Object>, ProjectConstants {

	private static final long serialVersionUID = 1L;
	private User user = new User();
	private UserBOImpl userBO = new UserBOImpl();
	private String username;
	private String email;
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
		String msg = null;

		//validate fields
		try {
			msg = userBO.validate(user);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (!msg.equals(MSG_SUCCESS)) {
			try {
				request.setAttribute("message", userBO.validate(user));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return INPUT;
		}

		//look up in database
		try {
			if (!userBO.checkExistUser(user)) {
				request.setAttribute("message",MSG_USER_NOTEXISTS);
				return INPUT;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//user logged in.
		session.put("loggedin", TRUE);
		session.put("name", user.getUsername());
		return SUCCESS;
	}

	/**
	 * Validate user's email and put result message to Request.
	 * @return		the string which is result of operator
	 */
	public String forgot() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String msg = null;
		try {
			msg = userBO.validateEmail(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (msg.equals("success")) {
			boolean result = false;
			try {
				result = userBO.sendEmail(user.getUsername(), user.getEmail());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result == false) {
				return INPUT;
			} else {
				return SUCCESS;
			}
		}
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
