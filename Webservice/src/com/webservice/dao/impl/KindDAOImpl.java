package com.webservice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.webservice.dao.KindDAO;
import com.webservice.db.HibernateUtil;
import com.webservice.model.Kind;

public class KindDAOImpl implements KindDAO<Kind>{
	public List<Kind> getAll() throws Exception {
		String query = "SELECT * FROM Kind";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Kind> list = new ArrayList<Kind>();
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				int number = Integer.parseInt(row[0].toString());
				list.add(new Kind(number,
						row[1].toString(), 
						row[2].toString(), 
						row[3].toString()));
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;	
	}
	public Kind getById(int id) throws Exception {
		String query = "SELECT * FROM Kind WHERE kindNumber = " + id + "";
		Kind kind = new Kind();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Kind> list = new ArrayList<Kind>();
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				int number = Integer.parseInt(row[0].toString());
				kind = new Kind(number,
						row[1].toString(), 
						row[2].toString(), 
						row[3].toString());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return kind;

	}
	public void addNew(Kind entity) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	public void update(Kind entity) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}


	}
	public void delete(Kind entity) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}


	}
}
