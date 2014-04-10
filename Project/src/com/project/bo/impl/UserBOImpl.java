package com.project.bo.impl;

import java.util.List;

import com.project.bean.UserBean;
import com.project.bo.UserBO;
import com.project.dao.impl.UserDAOImpl;

public class UserBOImpl implements UserBO{

	private UserDAOImpl userDAO;

	public UserDAOImpl getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAOImpl userDAO) {
		this.userDAO = userDAO;
	}
	public boolean checkLogin(UserBean entity) {
		return userDAO.checkLogin(entity);
	}

	public List<UserBean> getAll() throws Exception {
		List<UserBean> l = null;
		try {
			l = userDAO.getAll();
		} catch (Exception e) {
			throw new Exception("Display error: " + e.getMessage());
		} 
		return l;
	}

	public UserBean getById(int id) throws Exception {
		UserBean u = new UserBean();
		try {
			u = userDAO.getById(id);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
		return u;
	}

	public void addNew(UserBean entity) throws Exception {
		try {
			userDAO.addNew(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}

	public void update(UserBean entity) throws Exception {
		try {
			userDAO.update(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}

	public void delete(UserBean entity) throws Exception {
		try {
			userDAO.delete(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}
}

