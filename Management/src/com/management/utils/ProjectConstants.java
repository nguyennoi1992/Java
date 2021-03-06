package com.management.utils;

public abstract interface ProjectConstants {
	public final String MSG_SUCCESS = "success";
	public final String MSG_USER_NOTEXISTS = "user_notexist";
	public final String MSG_EMPTY_USERNAME = "empty_user";
	public final String MSG_EMPTY_PASSWORD = "empty_password";
	public final String MSG_EMPTY_EMAIL = "empty_email";
	public final String MSG_INVALID_USERNAME = "invalid_username";
	public final String MSG_INVALID_EMAIL = "invalid_email";

	public final String ENCODE_ALGORITHM = "MD5";
	public final String ENCODE_CHARSET = "UTF-8";

	public final String TRUE = "true";
	public final String FALSE = "false";
	
	public static int STATIC_ROW_MAX = 10;
	public static String[] STATIC_STRING = {"a", "b", "c", "d", "e", "f", "g", "h", 
		"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", 
		"y", "z",
		"A", "B", "C", "D", "E", "F", "G", "H", 
		"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", 
		"Y", "Z"};
	
	public final String ACCOUNT_USER = "User";
	public final String ACCOUNT_EMPLOYEE = "Employee";
	public final String ACCOUNT_SUPERVISOR = "Supervisor";
	public final String ACCOUNT_MANAGER = "Manager";
	
	
	public final String SEX_NAM = "Nam";
	public final String SEX_NU = "Nữ";
	
	public final String ACTIVED_YES = "Có";
	public final String ACTIVED_NO = "Không";
	
	public final String ACTION_LOCK = "Khóa tài khoản";
	public final String ACTION_UNLOCK = "Kích hoạt tài khoản";
	
	public final String POSITION_SUPERVISOR = "Kiểm soát viên";
	public final String POSITION_DRIVER = "Lái xe";
}
