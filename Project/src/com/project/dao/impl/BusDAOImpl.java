package com.project.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.bean.BusBean;
import com.project.dao.BusDAO;


public class BusDAOImpl extends HibernateDaoSupport implements BusDAO<BusBean>{
	
	public BusDAOImpl() throws Exception {
    }
	
	public List<BusBean> getAll() throws Exception {
        List<BusBean> list = null;
        try {
            list = getHibernateTemplate().find("from Bus");
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }

        return list;
    }

    
	public BusBean getById(int id) throws Exception {
        BusBean u = new BusBean();
        try {
        	List<BusBean> list = null;
        	list = getHibernateTemplate().find("from Bus where BusNumber='"+id+"'");
        	u = list.get(0);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
        return u;
    }

    public void addNew(BusBean entity) throws Exception {
        try {
            getHibernateTemplate().save(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }

    public void update(BusBean entity) throws Exception {
        try {
            getHibernateTemplate().saveOrUpdate(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }

    public void delete(BusBean entity) throws Exception {

        try {
            getHibernateTemplate().delete(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }
}

