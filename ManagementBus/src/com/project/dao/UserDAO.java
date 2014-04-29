package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.bean.User;
import com.project.db.DBUtils;
import com.project.utilities.ProjectConstants;


public class UserDAO implements ProjectConstants {

	/**
	 * look up <code>UserBean</code> in database
	 * @param user <code>UserBean</code> contains information of user
	 * @return <code>true</code> if found user. Otherwise return <code>false</code>
	 */
	public static boolean checkExistUser(User user) {

		String username = user.getUsername();
		String password = user.getPassword();
		String sql = "SELECT * FROM " + STATIC_USERS_TBNAME + " WHERE " + STATIC_USERS_USERNAME + " = ? AND " + STATIC_USERS_PASSWORD + "= ?";
		/*System.out.println(sql);*/
		Connection connection = null;
		boolean ans = false;

		try {
			connection = DBUtils.getConnection();
			if(connection != null){
				//set parameter for SQL query
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.setString(2, password);
				
				//run SQL query
				ResultSet rs = stmt.executeQuery();
				ans = rs.next();
				DBUtils.close(connection);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	
}
