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

	//db4free.net
/*	public final String DB_JDBC_USERNAME = "nguyennoi1992";
	public final String DB_JDBC_PASSWORD = "abc123";
	public final String DB_JDBC_NAME = "jdbc:mysql://www.db4free.net:3306/managementbus";
*/
	//s156.eatj.com
	public final String DB_JDBC_USERNAME = "root";
	public final String DB_JDBC_PASSWORD = "abc123";
	public final String DB_JDBC_NAME = "jdbc:mysql://localhost:3306/managementbus";

	public final String ENCODE_ALGORITHM = "MD5";
	public final String ENCODE_CHARSET = "UTF-8";

	public final String TRUE = "true";
	public final String FALSE = "false";
	
	/*
	 * 
	 */
	public static int STATIC_ROW_MAX = 10;
	public static String STATIC_ROW_NAME = "row";
	
	/*
	 * Bang Users
	 */
	public static String STATIC_USERS_TBNAME = "Users";
	public static String STATIC_USERS_USERNAME = "username";
	public static String STATIC_USERS_PASSWORD = "password";
	
	/*
	 * Bang Customer
	 */
	public static String STATIC_CUSTOMERS_TBNAME = "Customers";
	public static String STATIC_CUSTOMERS_CUSTOMERNUMBER = "customerNumber";
	public static String STATIC_CUSTOMERS_FIRSTNAME = "firstName";
	public static String STATIC_CUSTOMERS_LASTNAME = "lastname";
	public static String STATIC_CUSTOMERS_DATEOFBIRTH = "dateOfBirth";
	public static String STATIC_CUSTOMERS_IMAGE = "image";
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
	public static String STATIC_KIND_TBNAME = "Kind";
	public static String STATIC_KIND_KINDNUMBER = "kindNumber";
	public static String STATIC_KIND_KIND = "kind";
	public static String STATIC_KIND_TYPE = "type";
	public static String STATIC_KIND_CATEGORY = "category";
	
	/*
	 * Bang Bus
	 */
	public static String STATIC_BUS_TBNAME = "Bus";
	public static String STATIC_BUS_BUSNUMBER = "busNumber";
	public static String STATIC_BUS_DETAILS = "details";
	public static String STATIC_BUS_COST = "cost";
	
	/*
	 * Bang Payment
	 */
	public static String STATIC_PAYMENT_TBNAME = "Payment";
	public static String STATIC_PAYMENT_PAYMENTNUMBER = "paymentNumber";
	public static String STATIC_PAYMENT_DATE = "date";
	public static String STATIC_PAYMENT_PLACE = "place";
	public static String STATIC_PAYMENT_CUSTOMERNUMBER = "customerNumber";
	public static String STATIC_PAYMENT_BUSNUMBER = "busNumber";


}
