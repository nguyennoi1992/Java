package com.management.bean;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userNumber;
	private String username;
	private String password;
	private String email;
	private String account;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userNumber, String username,
			String password, String email, String account) {
		super();
		this.userNumber = userNumber;
		this.username = username;
		this.password = password;
		this.email = email;
		this.account = account;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	/**
	 * setter for <code>password</code>. Try to encoding <code>password</code>
	 * by MD5 algorithm
	 * @param password	the string to be encoded
	 */
	public void setPassword(String password) {
		MessageDigest md = null;
		byte[] byteOfPassword = null;
		byte[] digest = null;
		BigInteger bInt = null;
		
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		try {
			byteOfPassword = password.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		digest = md.digest(byteOfPassword);
		//convert from byte to hex string
		bInt = new BigInteger(1, digest);
		this.password = String.format("%0" + (digest.length << 1) + "x", bInt);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
