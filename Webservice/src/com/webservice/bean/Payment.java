package com.webservice.bean;

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
	private String userNumber;
	private String customerName;
	private String employeeName;
	private String numberPlate;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int paymentNumber, String date, String place,
			String customerNumber, String userNumber, String numberPlate) {
		super();
		this.paymentNumber = paymentNumber;
		this.date = date;
		this.place = place;
		this.customerNumber = customerNumber;
		this.userNumber = userNumber;
		this.numberPlate = numberPlate;
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
	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
}
