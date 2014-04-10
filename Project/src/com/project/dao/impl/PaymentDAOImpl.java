package com.project.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.bean.PaymentBean;
import com.project.dao.PaymentDAO;



public class PaymentDAOImpl extends HibernateDaoSupport implements PaymentDAO<PaymentBean>{
	
	public PaymentDAOImpl() throws Exception {
    }
	
	
	public List<PaymentBean> getAll() throws Exception {
        List<PaymentBean> list = null;
        try {
            list = getHibernateTemplate().find("from Payment");
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
        return list;
        
    }

    
	public PaymentBean getById(int id) throws Exception {
        PaymentBean u = new PaymentBean();
        try {
        	List<PaymentBean> list = null;
        	list = getHibernateTemplate().find("from Payment where PaymentNumber='"+id+"'");
        	u = list.get(0);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
        return u;
    }

    public void addNew(PaymentBean entity) throws Exception {
        try {
            getHibernateTemplate().save(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }

    public void update(PaymentBean entity) throws Exception {
        try {
            getHibernateTemplate().saveOrUpdate(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }

    public void delete(PaymentBean entity) throws Exception {

        try {
            getHibernateTemplate().delete(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }
}
