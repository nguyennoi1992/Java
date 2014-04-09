package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.bean.UserBean;
import com.project.db.DBHelper;
import com.project.utilities.ProjectConstants;


public class UserDAO implements ProjectConstants {

	/**
	 * look up <code>UserBean</code> in database
	 * @param user <code>UserBean</code> contains information of user
	 * @return <code>true</code> if found user. Otherwise return <code>false</code>
	 */
	public static boolean checkExistUser(UserBean user) {

		String username = user.getUsername();
		String password = user.getPassword();
		String sql = "SELECT * FROM " + DB_TABLE_USER + " WHERE " + DB_FIELD_USERNAME + " = ? AND " + DB_FIELD_PASSWORD + "= ?";
		/*System.out.println(sql);*/
		Connection connection = null;
		boolean ans = false;

		try {
			connection = DBHelper.getConnection();
			if(connection != null){
				//set parameter for SQL query
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.setString(2, password);
				
				//run SQL query
				ResultSet rs = stmt.executeQuery();
				ans = rs.next();
				DBHelper.close(connection);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	
}
