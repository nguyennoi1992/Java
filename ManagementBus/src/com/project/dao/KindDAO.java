package com.project.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.project.bean.KindBean;
import com.project.db.DBHelper;
import com.project.db.DBTableName;

public class KindDAO implements DBTableName{
	// doi tuong connect dung cho ham .
	Connection conn = null;
	/*
	 * Ham khoi tao .
	 * Nhiem vu la khoi tao connect tu DB HELPER
	 */
	public KindDAO() {
		// TODO Auto-generated constructor stub
		try {
			conn = (Connection) DBHelper.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<KindBean> getAll(){
		
		List<KindBean> list = null;
		
		if (conn == null) {
			try {
				conn = (Connection) DBHelper.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {

			String sql = "SELECT * FROM Kind";

			PreparedStatement pstt = null;

			// get connecttion
			try {
				pstt = (PreparedStatement) conn.prepareStatement(sql);
				if (pstt != null) {
					ResultSet rs = pstt.executeQuery();

					// RegionBean tamp = new RegionBean();
					list = new ArrayList<KindBean>();

					while (rs.next()) {
						list.add(new KindBean(
								rs.getInt(STATIC_KIND_KINDNUMBER),
								rs.getString(STATIC_KIND_KIND) ,
								rs.getString(STATIC_KIND_TYPE),
								rs.getString(STATIC_KIND_CATEGORY)
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
	public int Insert(KindBean bean) {
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
			String query = " INSERT INTO " + STATIC_KIND_TBNAME + "( "
					+ STATIC_KIND_KINDNUMBER + ", "
					+ STATIC_KIND_KIND + ", "
					+ STATIC_KIND_TYPE + ", "
					+ STATIC_KIND_CATEGORY +  ")"
					+ " VALUES " + "("
					+ bean.getKindNumber() + ",'"
					+ bean.getKind() + "','"
					+ bean.getType() + "','"
					+ bean.getCategory() + "'"
					+ ")";
System.out.println(query);
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
	public int Update(KindBean bean) {
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
			String query = " UPDATE " + STATIC_KIND_TBNAME + " SET "
					+ STATIC_KIND_KIND + " = '" + bean.getKind() + "', " 
					+ STATIC_KIND_TYPE + " = '" + bean.getType() + "', " 
					+ STATIC_KIND_CATEGORY + " = '" + bean.getCategory() + "' " 

					+ " WHERE " 
					+ STATIC_KIND_KINDNUMBER + " = " + bean.getKindNumber();

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

	public KindBean search(int ID){
		if (conn == null) {
			try {
				conn = (Connection) DBHelper.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		KindBean bean = new KindBean();
		String query = "SELECT * FROM " + STATIC_KIND_TBNAME + " WHERE " + STATIC_KIND_KINDNUMBER + " = " + ID +"";
		System.out.println(query);
		PreparedStatement pstt = null;

		// get connecttion
		try {
			pstt = (PreparedStatement) conn.prepareStatement(query);
			if (pstt != null) {
				ResultSet rs = pstt.executeQuery();

				// RegionBean tamp = new RegionBean();

				while (rs.next()) {
					bean = new KindBean(
							rs.getInt(STATIC_KIND_KINDNUMBER),
							rs.getString(STATIC_KIND_KIND) ,
							rs.getString(STATIC_KIND_TYPE),
							rs.getString(STATIC_KIND_CATEGORY)
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
