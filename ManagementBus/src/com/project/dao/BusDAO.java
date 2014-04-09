package com.project.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.project.bean.BusBean;
import com.project.db.DBHelper;
import com.project.db.DBTableName;

public class BusDAO implements DBTableName{
	// doi tuong connect dung cho ham .
	Connection conn = null;
	/*
	 * Ham khoi tao .
	 * Nhiem vu la khoi tao connect tu DB HELPER
	 */
	public BusDAO() {
		// TODO Auto-generated constructor stub
		try {
			conn = (Connection) DBHelper.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BusBean> getAll(){
		
		List<BusBean> list = null;
		
		if (conn == null) {
			try {
				conn = (Connection) DBHelper.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {

			String sql = "SELECT * FROM Bus";

			PreparedStatement pstt = null;

			// get connecttion
			try {
				pstt = (PreparedStatement) conn.prepareStatement(sql);
				if (pstt != null) {
					ResultSet rs = pstt.executeQuery();

					// RegionBean tamp = new RegionBean();
					list = new ArrayList<BusBean>();

					while (rs.next()) {
						list.add(new BusBean(
								rs.getString(STATIC_BUS_BUSNUMBER),
								rs.getString(STATIC_BUS_DETAILS) ,
								rs.getFloat(STATIC_BUS_COST)
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
	public int Insert(BusBean bean) {
		int result = 0;
		// Bat ngoai le chua khoi tao .
		if (conn == null) {
			try {
				conn = (Connection) DBHelper.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		//INSERT VVAO BANG DU LIEU .
		if (conn != null && bean != null) {
			String query = " INSERT INTO " + STATIC_BUS_TBNAME + "( "
					+ STATIC_BUS_BUSNUMBER + ", "
					+ STATIC_BUS_DETAILS + ", "
					+ STATIC_BUS_COST +  ")"
					+ " VALUES " + "("
					+ bean.getBusNumber() + ",'"
					+ bean.getDetails() + "',"
					+ bean.getCost() + ""
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
	public int Update(BusBean bean) {
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
			String query = " UPDATE " + STATIC_BUS_TBNAME + " SET "
					+ STATIC_BUS_DETAILS + " = '" + bean.getDetails() + "', " 
					+ STATIC_BUS_COST + " = " + bean.getCost() + " " 

					+ " WHERE " 
					+ STATIC_BUS_BUSNUMBER + " = " + bean.getBusNumber();

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

	public BusBean search(String ID){
		if (conn == null) {
			try {
				conn = (Connection) DBHelper.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		BusBean bean = new BusBean();
		String query = "SELECT * FROM " + STATIC_BUS_TBNAME + " WHERE " + STATIC_BUS_BUSNUMBER + " = '" + ID +"'";
		System.out.println(query);
		PreparedStatement pstt = null;

		// get connecttion
		try {
			pstt = (PreparedStatement) conn.prepareStatement(query);
			if (pstt != null) {
				ResultSet rs = pstt.executeQuery();

				// RegionBean tamp = new RegionBean();

				while (rs.next()) {
					bean = new BusBean(
							rs.getString(STATIC_BUS_BUSNUMBER),
							rs.getString(STATIC_BUS_DETAILS) ,
							rs.getFloat(STATIC_BUS_COST)
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
