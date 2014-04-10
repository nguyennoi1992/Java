package com.project.bean;

import java.io.Serializable;
import java.util.Date;



public class CustomerBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerNumber;
	private String  firstName;
	private String lastName;
	private Date dateOfBirth;
	private Date dateLimit;
	private String phoneNumber;
	private String address;
	private String schoolOrCompany;
	private String job;
	private float balance;
	private String placeEnroll;
	private int kindNumber;
	private String busNumber;
	private String actived;

	public CustomerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerBean(String customerNumber, String firstName,
			String lastName, Date dateOfBirth, Date dateLimit,
			String phoneNumber, String address, String schoolOrCompany,
			String job, float balance, String placeEnroll, int kindNumber,
			String busNumber, String actived) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.dateLimit = dateLimit;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.schoolOrCompany = schoolOrCompany;
		this.job = job;
		this.balance = balance;
		this.placeEnroll = placeEnroll;
		this.kindNumber = kindNumber;
		this.busNumber = busNumber;
		this.actived = actived;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateLimit() {
		return dateLimit;
	}

	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSchoolOrCompany() {
		return schoolOrCompany;
	}

	public void setSchoolOrCompany(String schoolOrCompany) {
		this.schoolOrCompany = schoolOrCompany;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getPlaceEnroll() {
		return placeEnroll;
	}

	public void setPlaceEnroll(String placeEnroll) {
		this.placeEnroll = placeEnroll;
	}

	public int getKindNumber() {
		return kindNumber;
	}

	public void setKindNumber(int kindNumber) {
		this.kindNumber = kindNumber;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getActived() {
		return actived;
	}

	public void setActived(String actived) {
		this.actived = actived;
	}
	
	
	
}
