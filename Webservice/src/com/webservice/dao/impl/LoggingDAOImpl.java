package com.webservice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.webservice.bean.Logging;
import com.webservice.dao.LoggingDAO;
import com.webservice.db.HibernateUtil;

public class LoggingDAOImpl implements LoggingDAO<Logging>{

	@Override
	public List<Logging> getAll() throws Exception {
		// TODO Auto-generated method stub
		String query = "select * from Logging";

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Logging> list = new ArrayList<Logging>();
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				int number = Integer.parseInt(row[0].toString());
				list.add(new Logging(number,
						row[1].toString(),
						row[2].toString(),
						row[3].toString(),
						row[4].toString()));
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

	@Override
	public int addNew(Logging entity) throws Exception {
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
	public int update(Logging entity) throws Exception {
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
	public int delete(Logging entity) throws Exception {
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
