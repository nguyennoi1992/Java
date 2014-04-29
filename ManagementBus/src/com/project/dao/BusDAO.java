package com.project.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.project.bean.Bus;
import com.project.db.DBUtils;
import com.project.utilities.ProjectConstants;

public class BusDAO implements ProjectConstants{
	// doi tuong connect dung cho ham .
	Connection conn = null;
	/*
	 * Ham khoi tao .
	 * Nhiem vu la khoi tao connect tu DB HELPER
	 */
	public BusDAO() {
		// TODO Auto-generated constructor stub
		try {
			conn = (Connection) DBUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Bus> getAll(){
		
		List<Bus> list = null;
		
		if (conn == null) {
			try {
				conn = (Connection) DBUtils.getConnection();
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
					list = new ArrayList<Bus>();

					while (rs.next()) {
						list.add(new Bus(
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
	public int Insert(Bus bean) {
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
	public int Update(Bus bean) {
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

	public Bus search(String ID){
		if (conn == null) {
			try {
				conn = (Connection) DBUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		Bus bean = new Bus();
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
					bean = new Bus(
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
