package com.project.action;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.UserBean;
import com.project.bo.UserBO;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L; 
	private String username;
	private String password;
	UserBO userBO;

	//DI via Spring
	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}
	
	public String doLogin() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			
			UserBean entity = new UserBean();
			entity.setUsername(username);
			entity.setPassword(password);
			
			boolean result = userBO.checkLogin(entity);
			
			if (result == true) {
				session.setAttribute("adminLogin", entity.getUsername());
				return SUCCESS;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		addActionError("Tên đăng nhập hoặc mật khẩu sai!");
		return INPUT;
	}

	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("adminLogin");
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		MessageDigest md = null;
		byte[] byteOfPassword = null;
		byte[] digest = null;
		BigInteger bInt = null;
		
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		try {
			byteOfPassword = password.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		digest = md.digest(byteOfPassword);
		//convert from byte to hex string
		bInt = new BigInteger(1, digest);
		this.password = String.format("%0" + (digest.length << 1) + "x", bInt);	}
}
