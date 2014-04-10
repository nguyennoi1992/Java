package com.project.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.bean.CustomerBean;
import com.project.dao.CustomerDAO;


public class CustomerDAOImpl extends HibernateDaoSupport implements CustomerDAO<CustomerBean> {

	public CustomerDAOImpl() throws Exception {
	}

	public List<CustomerBean> getAll() throws Exception {
		List<CustomerBean> list = null;
		try {
			list = getHibernateTemplate().find("FROM Customers");
		} catch (Exception ex) {
			throw new Exception("Error from DAO: " + ex.getMessage());
		}
		return list;
	}

	public CustomerBean getById(int id) throws Exception {
		CustomerBean u = new CustomerBean();
		try {
			List<CustomerBean> list = null;
			list = getHibernateTemplate().find("from Customers where CustomerNumber='"+id+"'");
			u = list.get(0);
		} catch (Exception ex) {
			throw new Exception("Error from DAO: " + ex.getMessage());
		}
		return u;
	}

	public void addNew(CustomerBean entity) throws Exception {
		try {
			getHibernateTemplate().save(entity);
		} catch (Exception ex) {
			throw new Exception("Error from DAO: " + ex.getMessage());
		}
	}

	public void update(CustomerBean entity) throws Exception {
		try {
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (Exception ex) {
			throw new Exception("Error from DAO: " + ex.getMessage());
		}
	}

	public void delete(CustomerBean entity) throws Exception {

		try {
			getHibernateTemplate().delete(entity);
		} catch (Exception ex) {
			throw new Exception("Error from DAO: " + ex.getMessage());
		}
	}
}
