package com.project.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.project.bean.CustomerBean;
import com.project.db.DBHelper;
import com.project.db.DBTableName;

public class CustomerDAO implements DBTableName{
	// doi tuong connect dung cho ham .
	Connection conn = null;
	/*
	 * Ham khoi tao .
	 * Nhiem vu la khoi tao connect tu DB HELPER
	 */
	public CustomerDAO() {
		// TODO Auto-generated constructor stub
		try {
			conn = (Connection) DBHelper.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<CustomerBean> getAll(){
		
		List<CustomerBean> list = null;
		
		if (conn == null) {
			try {
				conn = (Connection) DBHelper.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {

			String sql = "SELECT * FROM Customers";

			PreparedStatement pstt = null;

			// get connecttion
			try {
				pstt = (PreparedStatement) conn.prepareStatement(sql);
				if (pstt != null) {
					ResultSet rs = pstt.executeQuery();

					// RegionBean tamp = new RegionBean();
					list = new ArrayList<CustomerBean>();

					while (rs.next()) {
						list.add(new CustomerBean(
								rs.getString(STATIC_CUSTOMERS_CUSTOMERNUMBER),
								rs.getString(STATIC_CUSTOMERS_FIRSTNAME) ,
								rs.getString(STATIC_CUSTOMERS_LASTNAME),
								rs.getString(STATIC_CUSTOMERS_DATEOFBIRTH),
								rs.getString(STATIC_CUSTOMERS_DATELIMIT),
								rs.getString(STATIC_CUSTOMERS_PHONENUMBER),
								rs.getString(STATIC_CUSTOMERS_ADDRESS),
								rs.getString(STATIC_CUSTOMERS_SCHOOLORCOMPANY),
								rs.getString(STATIC_CUSTOMERS_JOB),
								rs.getFloat(STATIC_CUSTOMERS_BALANCE),
								rs.getString(STATIC_CUSTOMERS_PLACEENROLL),
								rs.getInt(STATIC_CUSTOMERS_KINDNUMBER),
								rs.getString(STATIC_CUSTOMERS_BUSNUMBER),
								rs.getString(STATIC_CUSTOMERS_ACTIVED)
								));

					}
					rs.close();

				}
				pstt.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		

		return list;
	}

	/*
	 * Insert table
	 */
	public int Insert(CustomerBean bean) {
		int result = 0;
		// Bat ngoai le chua khoi tao .
		if (conn == null) {
			try {
				conn = (Connection) DBHelper.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		//INSERT VAO BANG DU LIEU .
		if (conn != null && bean != null) {
			String query = " INSERT INTO " + STATIC_CUSTOMERS_TBNAME + "( "
					+ STATIC_CUSTOMERS_CUSTOMERNUMBER + ", "
					+ STATIC_CUSTOMERS_FIRSTNAME + ", "
					+ STATIC_CUSTOMERS_LASTNAME + ", "
					+ STATIC_CUSTOMERS_DATEOFBIRTH + ", "
					+ STATIC_CUSTOMERS_DATELIMIT + ", "
					+ STATIC_CUSTOMERS_PHONENUMBER + ", "
					+ STATIC_CUSTOMERS_ADDRESS + ", "
					+ STATIC_CUSTOMERS_SCHOOLORCOMPANY + ", "
					+ STATIC_CUSTOMERS_JOB + ", "
					+ STATIC_CUSTOMERS_BALANCE + ", "
					+ STATIC_CUSTOMERS_PLACEENROLL + ", "
					+ STATIC_CUSTOMERS_KINDNUMBER + ", "
					+ STATIC_CUSTOMERS_BUSNUMBER + ", "
					+ STATIC_CUSTOMERS_ACTIVED + ")"
					+ " VALUES " + "('"
					+ bean.getCustomerNumber() + "','"
					+ bean.getFirstName() + "','"
					+ bean.getLastName() + "','"
					+ bean.getDateOfBirth() + "','"
					+ bean.getDateLimit() + "','"
					+ bean.getPhoneNumber() + "','"
					+ bean.getAddress() + "','"
					+ bean.getSchoolOrCompany() + "','"
					+ bean.getJob() + "',"
					+ bean.getBalance() + ",'"
					+ bean.getPlaceEnroll() + "',"
					+ bean.getKindNumber() + ",'"
					+ bean.getBusNumber() + "','"
					+ bean.getActived() + "'"
					+ ")";
System.out.println("INSERT" + query);
			PreparedStatement pstt = null;

			try {
				pstt = (PreparedStatement) conn.prepareStatement(query);
				if (pstt != null) {
					result = pstt.executeUpdate();
				}
				pstt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/*
	 * Update table
	 */
	public int Update(CustomerBean bean) {
		// TODO Auto-generated method stub
		int result = 0;
		if (conn == null) {
			try {
				conn = (Connection) DBHelper.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (conn != null && bean != null) {
			String query = " UPDATE " + STATIC_CUSTOMERS_TBNAME + " SET "
					+ STATIC_CUSTOMERS_FIRSTNAME + " = '" + bean.getFirstName() + "', " 
					+ STATIC_CUSTOMERS_LASTNAME + " = '" + bean.getLastName() + "', " 
					+ STATIC_CUSTOMERS_DATEOFBIRTH + " = '" + bean.getDateOfBirth() + "', " 
					+ STATIC_CUSTOMERS_DATELIMIT + " = '" + bean.getDateLimit() + "', " 
					+ STATIC_CUSTOMERS_PHONENUMBER + " = '" + bean.getPhoneNumber() + "', " 
					+ STATIC_CUSTOMERS_ADDRESS + " = '" + bean.getAddress() + "', " 
					+ STATIC_CUSTOMERS_SCHOOLORCOMPANY + " = '" + bean.getSchoolOrCompany() + "', " 
					+ STATIC_CUSTOMERS_JOB + " = '" + bean.getJob() + "', " 
					+ STATIC_CUSTOMERS_BALANCE + " = " + bean.getBalance() + ", " 
					+ STATIC_CUSTOMERS_PLACEENROLL + " = '" + bean.getPlaceEnroll() + "', " 
					+ STATIC_CUSTOMERS_KINDNUMBER + " = " + bean.getKindNumber() + ", " 
					+ STATIC_CUSTOMERS_BUSNUMBER + " = '" + bean.getBusNumber() + "', " 
					+ STATIC_CUSTOMERS_ACTIVED + " = '" + bean.getActived() + "' " 

					+ " WHERE " 
					+ STATIC_CUSTOMERS_CUSTOMERNUMBER + " = '" + bean.getCustomerNumber() +"'";
System.out.println("UPDATE" + query);
			PreparedStatement pstt = null;
			// get connecttion
			try {
				pstt = (PreparedStatement) conn.prepareStatement(query);
				if (pstt != null) {
					result = pstt.executeUpdate();
				}
				pstt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public CustomerBean search(String ID){
		if (conn == null) {
			try {
				conn = (Connection) DBHelper.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		CustomerBean bean = new CustomerBean();
		String query = "SELECT * FROM " + STATIC_CUSTOMERS_TBNAME + " WHERE " + STATIC_CUSTOMERS_CUSTOMERNUMBER + " = '" + ID +"'";
		System.out.println(query);
		PreparedStatement pstt = null;

		// get connecttion
		try {
			pstt = (PreparedStatement) conn.prepareStatement(query);
			if (pstt != null) {
				ResultSet rs = pstt.executeQuery();

				// RegionBean tamp = new RegionBean();

				while (rs.next()) {
					bean = new CustomerBean(
							rs.getString(STATIC_CUSTOMERS_CUSTOMERNUMBER),
							rs.getString(STATIC_CUSTOMERS_FIRSTNAME) ,
							rs.getString(STATIC_CUSTOMERS_LASTNAME),
							rs.getString(STATIC_CUSTOMERS_DATEOFBIRTH),
							rs.getString(STATIC_CUSTOMERS_DATELIMIT),
							rs.getString(STATIC_CUSTOMERS_PHONENUMBER),
							rs.getString(STATIC_CUSTOMERS_ADDRESS),
							rs.getString(STATIC_CUSTOMERS_SCHOOLORCOMPANY),
							rs.getString(STATIC_CUSTOMERS_JOB),
							rs.getFloat(STATIC_CUSTOMERS_BALANCE),
							rs.getString(STATIC_CUSTOMERS_PLACEENROLL),
							rs.getInt(STATIC_CUSTOMERS_KINDNUMBER),
							rs.getString(STATIC_CUSTOMERS_BUSNUMBER),
							rs.getString(STATIC_CUSTOMERS_ACTIVED)
							);

				}
				rs.close();

			}
			pstt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return bean;
	}

	public void closeconn(){
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
