package com.project.bo.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.bean.PaymentBean;
import com.project.bo.PaymentBO;
import com.project.dao.impl.PaymentDAOImpl;

public class PaymentBOImpl extends HibernateDaoSupport implements PaymentBO{
	private PaymentDAOImpl PaymentDAO;

	public PaymentDAOImpl getPaymentDAO() {
		return PaymentDAO;
	}

	public void setPaymentDAO(PaymentDAOImpl PaymentDAO) {
		this.PaymentDAO = PaymentDAO;
	}

	public List<PaymentBean> getAll() throws Exception {
		List<PaymentBean> l = null;
		try {
			l = PaymentDAO.getAll();
		} catch (Exception e) {
			throw new Exception("Display error: " + e.getMessage());
		} 
		return l;
	}

	public PaymentBean getById(int id) throws Exception {
		PaymentBean u = new PaymentBean();
		try {
			u = PaymentDAO.getById(id);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
		return u;
	}

	public void addNew(PaymentBean entity) throws Exception {
		try {
			PaymentDAO.addNew(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}

	public void update(PaymentBean entity) throws Exception {
		try {
			PaymentDAO.update(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}

	public void delete(PaymentBean entity) throws Exception {
		try {
			PaymentDAO.delete(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}

}
