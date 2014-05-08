package com.management.model;

import java.io.Serializable;

public class Bus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String busNumber;
	private String details;
	private float cost;
	
	
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bus(String busNumber, String details, float cost) {
		super();
		this.busNumber = busNumber;
		this.details = details;
		this.cost = cost;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
}
