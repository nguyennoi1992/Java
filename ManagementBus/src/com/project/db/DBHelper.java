package com.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.project.utilities.ProjectConstants;

public class DBHelper implements ProjectConstants {
	
	/*
	 * Thuc hien tao ra 1 connect toi co so du lieu .
	 * 
	 */
	public static Connection getConnection() throws Exception{
		Class.forName(DB_JDBC_DRIVER);
		try{
			return DriverManager.getConnection(DB_JDBC_NAME, DB_JDBC_USERNAME, DB_JDBC_PASSWORD);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	
	/*
	 *  Truyen vao 1 tham so Connection .
	 *  Ham nay se~ thuc hien dong' ket noi voi co so du lieu .
	 */
	public static void close(Connection c) {
		try {
			if (c != null && !c.isClosed()) {
				c.close();
				c = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}