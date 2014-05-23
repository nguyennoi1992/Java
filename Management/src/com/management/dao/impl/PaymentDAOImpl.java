package com.management.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.management.bean.Payment;
import com.management.dao.PaymentDAO;
import com.management.utils.HibernateUtil;

public class PaymentDAOImpl implements PaymentDAO<Payment>{
	@Override
	public List<Payment> getAll() throws Exception {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Payment";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Payment> list = new ArrayList<Payment>();
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				int number = Integer.parseInt(row[0].toString());
				list.add(new Payment(number,
						row[1].toString(), 
						row[2].toString(), 
						row[3].toString(),
						row[4].toString(),
						row[5].toString()));
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
	public int addNew(Payment entity) throws Exception {
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
	public int update(Payment entity) throws Exception {
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
	public int delete(Payment entity) throws Exception {
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
