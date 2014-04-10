package com.project.bo.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.bean.BusBean;
import com.project.bo.BusBO;
import com.project.dao.impl.BusDAOImpl;



public class BusBOImpl extends HibernateDaoSupport implements BusBO{
	private BusDAOImpl BusDAO;

	public BusDAOImpl getBusDAO() {
		return BusDAO;
	}

	public void setBusDAO(BusDAOImpl BusDAO) {
		this.BusDAO = BusDAO;
	}

	public List<BusBean> getAll() throws Exception {
		List<BusBean> l = null;
		try {
			l = BusDAO.getAll();
		} catch (Exception e) {
			throw new Exception("Display error: " + e.getMessage());
		} 
		return l;
	}

	public BusBean getById(int id) throws Exception {
		BusBean u = new BusBean();
		try {
			u = BusDAO.getById(id);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
		return u;
	}

	public void addNew(BusBean entity) throws Exception {
		try {
			BusDAO.addNew(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}

	public void update(BusBean entity) throws Exception {
		try {
			BusDAO.update(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}

	public void delete(BusBean entity) throws Exception {
		try {
			BusDAO.delete(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}
}