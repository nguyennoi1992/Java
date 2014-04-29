package com.project.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.project.bean.Payment;
import com.project.db.DBUtils;
import com.project.utilities.ProjectConstants;

public class PaymentDAO implements ProjectConstants{
	// doi tuong connect dung cho ham .
	Connection conn = null;
	/*
	 * Ham khoi tao .
	 * Nhiem vu la khoi tao connect tu DB HELPER
	 */
	public PaymentDAO() {
		// TODO Auto-generated constructor stub
		try {
			conn = (Connection) DBUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Payment> getAll(){

		List<Payment> list = null;

		if (conn == null) {
			try {
				conn = (Connection) DBUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {

			String sql = "SELECT * FROM Payment";

			PreparedStatement pstt = null;

			// get connecttion
			try {
				pstt = (PreparedStatement) conn.prepareStatement(sql);
				if (pstt != null) {
					ResultSet rs = pstt.executeQuery();

					// RegionBean tamp = new RegionBean();
					list = new ArrayList<Payment>();

					while (rs.next()) {
						list.add(new Payment(
								rs.getInt(STATIC_PAYMENT_PAYMENTNUMBER),
								rs.getString(STATIC_PAYMENT_DATE) ,
								rs.getString(STATIC_PAYMENT_PLACE),
								rs.getString(STATIC_PAYMENT_CUSTOMERNUMBER),
								rs.getString(STATIC_PAYMENT_BUSNUMBER)
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
	public int Insert(Payment bean) {
		int result = 0;
		// Bat ngoai le chua khoi tao .
		if (conn == null) {
			try {
				conn = (Connection) DBUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		//INSERT VVAO BANG DU LIEU .
		if (conn != null && bean != null) {
			String query = " INSERT INTO " + STATIC_PAYMENT_TBNAME + "( "
					+ STATIC_PAYMENT_DATE + ", "
					+ STATIC_PAYMENT_PLACE + ", "
					+ STATIC_PAYMENT_CUSTOMERNUMBER + ", "
					+ STATIC_PAYMENT_BUSNUMBER +  ")"
					+ " VALUES " + "('"
					+ bean.getDate() + "','"
					+ bean.getPlace() + "','"
					+ bean.getCustomerNumber() + "','"
					+ bean.getBusNumber() + "'"
					+ ")";

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
	public int Update(Payment bean) {
		// TODO Auto-generated method stub
		int result = 0;
		if (conn == null) {
			try {
				conn = (Connection) DBUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (conn != null && bean != null) {
			String query = " UPDATE " + STATIC_PAYMENT_TBNAME + " SET "
					+ STATIC_PAYMENT_DATE + " = '" + bean.getDate() + "', " 
					+ STATIC_PAYMENT_PLACE + " = '" + bean.getPlace() + "', '"
					+ STATIC_PAYMENT_CUSTOMERNUMBER + " = '" + bean.getCustomerNumber() + "', '"
					+ STATIC_PAYMENT_BUSNUMBER + " = '" + bean.getBusNumber() + "' " 

					+ " WHERE " 
					+ STATIC_PAYMENT_PAYMENTNUMBER + " = " + bean.getPaymentNumber();

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


	public void closeconn(){
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
