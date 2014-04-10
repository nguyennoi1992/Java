package com.project.bean;

import java.io.Serializable;


public class UserBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userNumber;
	private String username;
	private String password;
	private String email;
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserBean(int userNumber, String username, String password,
			String email) {
		super();
		this.userNumber = userNumber;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
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
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
}
