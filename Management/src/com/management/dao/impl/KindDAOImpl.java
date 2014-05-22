package com.management.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.management.bean.Kind;
import com.management.dao.KindDAO;
import com.management.utils.HibernateUtil;

public class KindDAOImpl implements KindDAO<Kind>{
	@Override
	public List<Kind> getAll() throws Exception {
		// TODO Auto-generated method stub
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

	@Override
	public int addNew(Kind entity) throws Exception {
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
	public int update(Kind entity) throws Exception {
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
	public int delete(Kind entity) throws Exception {
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
