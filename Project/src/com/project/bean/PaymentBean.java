package com.project.bean;

import java.io.Serializable;
import java.util.Date;

public class PaymentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int paymentNumber;
	private Date date;
	private String place;
	private String customerNumber;
	private String busNumber;

	public PaymentBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PaymentBean(int paymentNumber, Date date, String place,
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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



}
