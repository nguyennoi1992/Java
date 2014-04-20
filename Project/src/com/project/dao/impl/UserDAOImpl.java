package com.project.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.bean.UserBean;
import com.project.dao.UserDAO;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO<UserBean> {

	public UserDAOImpl() throws Exception {
	}

	
	public boolean checkLogin(UserBean entity) {
		boolean flag = false;
		try {
			List<UserBean> l = null;

			// Using HQL
/*			String queryString = "from Users where username='" + entity.getUsername() + "'"
                    + "and password='" + entity.getPassword() + "'";
            l = getHibernateTemplate().find(queryString);*/

			// Using SQL
			String sqlQuerryString =  "select * from Users where username='" + entity.getUsername() + "'"
					+ "and password='" + entity.getPassword() + "'";
			l = getSession().createSQLQuery(sqlQuerryString).list();

			if (l != null) {
				if (l.size() > 0) {
					flag = true;
				}
			}
		} catch (Exception ex) {
			ex.toString();
			flag = false;
		}
		return flag;
	}

	
	public List<UserBean> getAll() throws Exception {
		List<UserBean> list = null;
		try {
			list = getHibernateTemplate().find("from Users");
		} catch (Exception ex) {
			throw new Exception("Error from DAO: " + ex.getMessage());
		}
		return list;
	}

	
	public UserBean getById(int id) throws Exception {
		UserBean u = new UserBean();
		try {
			List<UserBean> list = null;
			list = getHibernateTemplate().find("from Users where UserNumber='"+id+"'");
			u = list.get(0);
		} catch (Exception ex) {
			throw new Exception("Error from DAO: " + ex.getMessage());
		}
		return u;
	}

	public void addNew(UserBean entity) throws Exception {
		try {
			getHibernateTemplate().save(entity);
		} catch (Exception ex) {
			throw new Exception("Error from DAO: " + ex.getMessage());
		}
	}

	public void update(UserBean entity) throws Exception {
		try {
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (Exception ex) {
			throw new Exception("Error from DAO: " + ex.getMessage());
		}
	}

	public void delete(UserBean entity) throws Exception {

		try {
			getHibernateTemplate().delete(entity);
		} catch (Exception ex) {
			throw new Exception("Error from DAO: " + ex.getMessage());
		}
	}
}