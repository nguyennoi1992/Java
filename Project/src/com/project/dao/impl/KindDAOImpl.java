package com.project.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.bean.KindBean;
import com.project.dao.KindDAO;



public class KindDAOImpl extends HibernateDaoSupport implements KindDAO<KindBean>{
	
	public KindDAOImpl() throws Exception {
    }
	
	
	public List<KindBean> getAll() throws Exception {
        List<KindBean> list = null;
        try {
            list = getHibernateTemplate().find("from Kind");
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
        return list;

    }

    
	public KindBean getById(int id) throws Exception {
        KindBean u = new KindBean();
        try {
        	List<KindBean> list = null;
        	list = getHibernateTemplate().find("from Kind where KindNumber='"+id+"'");
        	u = list.get(0);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
        return u;
    }

    public void addNew(KindBean entity) throws Exception {
        try {
            getHibernateTemplate().save(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }

    public void update(KindBean entity) throws Exception {
        try {
            getHibernateTemplate().saveOrUpdate(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }

    public void delete(KindBean entity) throws Exception {

        try {
            getHibernateTemplate().delete(entity);
        } catch (Exception ex) {
            throw new Exception("Error from DAO: " + ex.getMessage());
        }
    }
}

