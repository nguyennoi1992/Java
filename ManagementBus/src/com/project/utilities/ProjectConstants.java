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

}
