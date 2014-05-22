package com.management.bean;

import java.io.Serializable;

public class BusDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numberPlate;
	private String employeeNumber;
	private String busNumber;
	public BusDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusDetail(String numberPlate, String employeeNumber, String busNumber) {
		super();
		this.numberPlate = numberPlate;
		this.employeeNumber = employeeNumber;
		this.busNumber = busNumber;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
}
