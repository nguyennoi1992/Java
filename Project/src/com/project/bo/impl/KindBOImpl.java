package com.project.bo.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.bean.KindBean;
import com.project.bo.KindBO;
import com.project.dao.impl.KindDAOImpl;

public class KindBOImpl extends HibernateDaoSupport implements KindBO{
	private KindDAOImpl KindDAO;

	public KindDAOImpl getKindDAO() {
		return KindDAO;
	}

	public void setKindDAO(KindDAOImpl KindDAO) {
		this.KindDAO = KindDAO;
	}

	public List<KindBean> getAll() throws Exception {
		List<KindBean> l = null;
		try {
			l = KindDAO.getAll();
		} catch (Exception e) {
			throw new Exception("Display error: " + e.getMessage());
		} 
		return l;
	}

	public KindBean getById(int id) throws Exception {
		KindBean u = new KindBean();
		try {
			u = KindDAO.getById(id);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
		return u;
	}

	public void addNew(KindBean entity) throws Exception {
		try {
			KindDAO.addNew(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}

	public void update(KindBean entity) throws Exception {
		try {
			KindDAO.update(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}

	public void delete(KindBean entity) throws Exception {
		try {
			KindDAO.delete(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}

}
