package com.management.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.management.dao.BusDAO;
import com.management.model.Bus;
import com.management.utils.HibernateUtil;

public class BusDAOImpl implements BusDAO<Bus>{
	public List<Bus> getAll() throws Exception {
		String query = "SELECT * FROM Bus";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Bus> list = new ArrayList<Bus>();
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				float number = (float) 0.0;
				if(row[2] != null) {
					number = Float.parseFloat(row[2].toString());
				}
				list.add(new Bus(row[0].toString(),
						row[1].toString(), 
						number));
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println(list.size());
		return list;	
	}
	public Bus getById(String id) throws Exception {
		String query = "SELECT * FROM Bus WHERE busNumber = '" + id + "'";
		Bus bus = new Bus();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				float number = (float) 0.0;
				if(row[2] != null) {
					number = Float.parseFloat(row[2].toString());
				}
				bus = new Bus(row[0].toString(),
						row[1].toString(), 
						number);
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bus;

	}
	public void addNew(Bus entity) throws Exception {
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
	public void update(Bus entity) throws Exception {
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
	public void delete(Bus entity) throws Exception {
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
