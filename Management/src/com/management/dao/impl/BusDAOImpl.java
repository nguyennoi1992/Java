package com.management.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.management.bean.Bus;
import com.management.dao.BusDAO;
import com.management.utils.HibernateUtil;

public class BusDAOImpl implements BusDAO<Bus>{
	@Override
	public List<Bus> getAll() throws Exception {
		// TODO Auto-generated method stub
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

	@Override
	public int addNew(Bus entity) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		int result = 0;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
			result = 1;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int update(Bus entity) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		int result = 0;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
			result = 1;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;

	}

	@Override
	public int delete(Bus entity) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		int result = 0;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();
			result = 1;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}
}
