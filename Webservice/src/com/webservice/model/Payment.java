package com.webservice.model;

import java.io.Serializable;

public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String success;
	private int paymentNumber;
	private String date;
	private String place;
	private String customerNumber;
	private String busNumber;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Payment(int paymentNumber, String date, String place,
			String customerNumber, String busNumber) {
		super();
		this.paymentNumber = paymentNumber;
		this.date = date;
		this.place = place;
		this.customerNumber = customerNumber;
		this.busNumber = busNumber;
	}


	public int getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}


	public String getSuccess() {
		return success;
	}


	public void setSuccess(String success) {
		this.success = success;
	}


}
