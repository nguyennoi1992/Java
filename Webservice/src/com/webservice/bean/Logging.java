package com.webservice.bean;

import java.io.Serializable;

public class Logging implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int logNumber;
	private String userNumber;
	private String customerNumber;
	private String date;
	private String action;
	public Logging() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Logging(int logNumber, String userNumber, String customerNumber,
			String date, String action) {
		super();
		this.logNumber = logNumber;
		this.userNumber = userNumber;
		this.customerNumber = customerNumber;
		this.date = date;
		this.action = action;
	}
	public int getLogNumber() {
		return logNumber;
	}
	public void setLogNumber(int logNumber) {
		this.logNumber = logNumber;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
}
