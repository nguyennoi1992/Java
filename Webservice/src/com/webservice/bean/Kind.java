package com.webservice.bean;

import java.io.Serializable;

public class Kind implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int kindNumber;
	private String kind;
	private String type;
	private String category;
	
	
	public Kind() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Kind(int kindNumber, String kind, String type, String category) {
		super();
		this.kindNumber = kindNumber;
		this.kind = kind;
		this.type = type;
		this.category = category;
	}
	public int getKindNumber() {
		return kindNumber;
	}
	public void setKindNumber(int kindNumber) {
		this.kindNumber = kindNumber;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
