package com.project.controller;


import com.project.bean.User;
import com.project.dao.UserDAO;
import com.project.utilities.CheckEmail;
import com.project.utilities.ProjectConstants;

public class LoginController implements ProjectConstants {
	
	/**
	 * Validate username and password of user
	 * @param user	UserBean contains username and password
	 * @see UserBean
	 * @return message code of result
	 */
	public static String validate(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		//empty field
		if (username.equals(""))
			return MSG_EMPTY_USERNAME;
		if (password.equals(""))
			return MSG_EMPTY_PASSWORD;
		
		//contain illegal characters
		if (CheckEmail.invalid(username))
			return MSG_INVALID_USERNAME;
		else 
			return MSG_SUCCESS;
	}

	/**
	 * look up user in database
	 * @param user UserBean contain username and password
	 * @return
	 */
	public static boolean checkExistUser(User user) {
		return UserDAO.checkExistUser(user);
	}

	/**
	 * validate if user's email is correct
	 * @param user UserBean contain email of user
	 * @return message code of result
	 */
	public static String validateEmail(User user) {
		String email = user.getEmail();
		return CheckEmail.validateEmail(email);
	}

}
