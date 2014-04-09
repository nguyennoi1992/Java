package com.project.db;

public interface DBTableName {
	/*
	 * 
	 */
	public static int STATIC_ROW_MAX = 10;
	public static String STATIC_ROW_NAME = "row";
	
	/*
	 * Bang Users
	 */
	public static String STATIC_USERS_TBNAME = "users";
	public static String STATIC_USERS_USERNAME = "username";
	public static String STATIC_USERS_PASSWORD = "password";
	
	/*
	 * Bang Customer
	 */
	public static String STATIC_CUSTOMERS_TBNAME = "customers";
	public static String STATIC_CUSTOMERS_CUSTOMERNUMBER = "customerNumber";
	public static String STATIC_CUSTOMERS_FIRSTNAME = "firstName";
	public static String STATIC_CUSTOMERS_LASTNAME = "lastname";
	public static String STATIC_CUSTOMERS_DATEOFBIRTH = "dateOfBirth";
	public static String STATIC_CUSTOMERS_DATELIMIT = "dateLimit";
	public static String STATIC_CUSTOMERS_PHONENUMBER = "phoneNumber";
	public static String STATIC_CUSTOMERS_ADDRESS = "address";
	public static String STATIC_CUSTOMERS_SCHOOLORCOMPANY = "schoolOrCompany";
	public static String STATIC_CUSTOMERS_JOB = "job";
	public static String STATIC_CUSTOMERS_BALANCE = "balance";
	public static String STATIC_CUSTOMERS_PLACEENROLL = "placeEnroll";
	public static String STATIC_CUSTOMERS_KINDNUMBER = "kindNumber";
	public static String STATIC_CUSTOMERS_BUSNUMBER = "busNumber";
	public static String STATIC_CUSTOMERS_ACTIVED = "actived";
	
	/*
	 * Bang Kind
	 */
	public static String STATIC_KIND_TBNAME = "kind";
	public static String STATIC_KIND_KINDNUMBER = "kindNumber";
	public static String STATIC_KIND_KIND = "kind";
	public static String STATIC_KIND_TYPE = "type";
	public static String STATIC_KIND_CATEGORY = "category";
	
	/*
	 * Bang Bus
	 */
	public static String STATIC_BUS_TBNAME = "bus";
	public static String STATIC_BUS_BUSNUMBER = "busNumber";
	public static String STATIC_BUS_DETAILS = "details";
	public static String STATIC_BUS_COST = "cost";
	
	/*
	 * Bang Payment
	 */
	public static String STATIC_PAYMENT_TBNAME = "payment";
	public static String STATIC_PAYMENT_PAYMENTNUMBER = "paymentNumber";
	public static String STATIC_PAYMENT_DATE = "date";
	public static String STATIC_PAYMENT_PLACE = "place";
	public static String STATIC_PAYMENT_CUSTOMERNUMBER = "customerNumber";
	public static String STATIC_PAYMENT_BUSNUMBER = "busNumber";

}
