package com.webservice.bean;

import java.io.Serializable;


public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String success;
	private String customerNumber;
	private String  firstName;
	private String lastName;
	private String sex;
	private String dateOfBirth;
	private String image;
	private String dateLimit;
	private String phoneNumber;
	private String address;
	private String SchoolOrCompany;
	private String job;
	private float balance;
	private String placeEnroll;
	private int kindNumber;
	private String actived;
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String customerNumber, String firstName, String lastName,
			String sex, String dateOfBirth, String image, String dateLimit,
			String phoneNumber, String address, String schoolOrCompany,
			String job, float balance, String placeEnroll, int kindNumber,
			String actived) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.image = image;
		this.dateLimit = dateLimit;
		this.phoneNumber = phoneNumber;
		this.address = address;
		SchoolOrCompany = schoolOrCompany;
		this.job = job;
		this.balance = balance;
		this.placeEnroll = placeEnroll;
		this.kindNumber = kindNumber;
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

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDateLimit() {
		return dateLimit;
	}
	public void setDateLimit(String dateLimit) {
		this.dateLimit = dateLimit;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
		return SchoolOrCompany;
	}
	public void setSchoolOrCompany(String schoolOrCompany) {
		SchoolOrCompany = schoolOrCompany;
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
	public String getActived() {
		return actived;
	}
	public void setActived(String actived) {
		this.actived = actived;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}
}
