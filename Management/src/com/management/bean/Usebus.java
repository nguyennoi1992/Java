package com.management.bean;

import java.io.Serializable;

public class Usebus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String busNumber;
	private String customerNumber;
	
	
	public Usebus() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usebus(String busNumber, String customerNumber) {
		super();
		this.busNumber = busNumber;
		this.customerNumber = customerNumber;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
}
