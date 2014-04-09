package com.project.utilities;

public abstract interface ProjectConstants {
	public final String MSG_SUCCESS = "success";
	public final String MSG_USER_NOTEXISTS = "user_notexist";
	public final String MSG_EMPTY_USERNAME = "empty_user";
	public final String MSG_EMPTY_PASSWORD = "empty_password";
	public final String MSG_EMPTY_EMAIL = "empty_email";
	public final String MSG_INVALID_USERNAME = "invalid_username";
	public final String MSG_INVALID_EMAIL = "invalid_email";

	public final String DB_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final String DB_JDBC_USERNAME = "daica";
	public final String DB_JDBC_PASSWORD = "daica@123";
	public final String DB_JDBC_NAME = "jdbc:mysql://s156.eatj.com:3307/daica";

	public final String ENCODE_ALGORITHM = "MD5";
	public final String ENCODE_CHARSET = "UTF-8";

	public final String TRUE = "true";
	public final String FALSE = "false";
	public final String EMPTY_STRING = "";
	
	/*
	 * Bang Users
	 */
	public final String DB_TABLE_USER = "users";
	public final String DB_FIELD_USERNAME = "username";
	public final String DB_FIELD_PASSWORD = "password";
	
	/*
	 * Bang Customer
	 */
	public final String DB_TABLE_CUSTOMERS = "customers";
	public final String DB_FIELD_CUSTOMERNUMBER = "customerNumber";
	public final String DB_FIELD_FIRSTNAME = "firstName";
	public final String DB_FIELD_LASTNAME = "lastname";
	public final String DB_FIELD_DATEOFBIRTH = "dateOfBirth";
	public final String DB_FIELD_PHONENUMBER = "phoneNumber";
	public final String DB_FIELD_ADDRESS = "address";
	public final String DB_FIELD_SCHOOLORCOMPANY = "school/company";
	public final String DB_FIELD_JOB = "job";
	public final String DB_FIELD_BALANCE = "balance";
	public final String DB_FIELD_PLACEENROLL = "placeEnroll";
//	public final String DB_FIELD_KINDNUMBER = "kindNumber";
	public final String DB_FIELD_ACTIVED = "actived";
	
	/*
	 * Bang Kind
	 */
	public final String DB_TABLE_KIND = "kind";
	public final String DB_FIELD_KINDNUMBER = "kindNumber";
	public final String DB_FIELD_KIND = "kind";
//	public final String DB_FIELD_BUSNUMBER = "busNumber";
	public final String DB_FIELD_DETAILS = "details";
	
	/*
	 * Bang Bus
	 */
	public final String DB_TABLE_BUS = "bus";
	public final String DB_FIELD_BUSNUMBER = "busNumber";
//	public final String DB_FIELD_DETAILS = "details";
	public final String DB_FIELD_COSTDAY = "costDay";
	public final String DB_FIELD_COSTMONTH = "costMonth";
	
	/*
	 * Bang Payment
	 */
	public final String DB_TABLE_PAYMENT = "payment";
	public final String DB_FIELD_PAYMENTNUMBER = "paymentNumber";
	public final String DB_FIELD_DATE = "date";
	public final String DB_FIELD_PLACE = "place";
//	public final String DB_FIELD_CUSTOMERNUMBER = "customerNumber";
//	public final String DB_FIELD_BUSNUMBER = "busNumber";

}
