package com.project.bean;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.project.utilities.ProjectConstants;

public class User implements ProjectConstants {
	
	private String username;
	private String password;
	private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
			md = MessageDigest.getInstance(ENCODE_ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		try {
			byteOfPassword = password.getBytes(ENCODE_CHARSET);
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
