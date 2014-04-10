package com.project.bo.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.bean.CustomerBean;
import com.project.bo.CustomerBO;
import com.project.dao.impl.CustomerDAOImpl;


public class CustomerBOImpl extends HibernateDaoSupport implements CustomerBO{
	private CustomerDAOImpl CustomerDAO;

	public CustomerDAOImpl getCustomerDAO() {
		return CustomerDAO;
	}

	public void setCustomerDAO(CustomerDAOImpl CustomerDAO) {
		this.CustomerDAO = CustomerDAO;
	}

	public List<CustomerBean> getAll() throws Exception {
		List<CustomerBean> l = null;
		try {
			l = CustomerDAO.getAll();
		} catch (Exception e) {
			throw new Exception("Display error: " + e.getMessage());
		} 
		return l;
	}

	public CustomerBean getById(int id) throws Exception {
		CustomerBean u = new CustomerBean();
		try {
			u = CustomerDAO.getById(id);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
		return u;
	}

	public void addNew(CustomerBean entity) throws Exception {
		try {
			CustomerDAO.addNew(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}

	public void update(CustomerBean entity) throws Exception {
		try {
			CustomerDAO.update(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}

	public void delete(CustomerBean entity) throws Exception {
		try {
			CustomerDAO.delete(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}
}
