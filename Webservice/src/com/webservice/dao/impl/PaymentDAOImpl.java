package com.webservice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.webservice.dao.PaymentDAO;
import com.webservice.db.HibernateUtil;
import com.webservice.model.Payment;

public class PaymentDAOImpl implements PaymentDAO<Payment>{
	public List<Payment> getAll() throws Exception {
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
	public Payment getById(int id) throws Exception {
		String query = "SELECT * FROM Payment WHERE paymentNumber = " + id + "";
		Payment payment = new Payment();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				int number = Integer.parseInt(row[0].toString());
				payment = new Payment(number,
						row[1].toString(), 
						row[2].toString(), 
						row[3].toString(), 
						row[4].toString());
			}  
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return payment;

	}
	public int addNew(Payment entity) throws Exception {
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
	public void update(Payment entity) throws Exception {
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
	public void delete(Payment entity) throws Exception {
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
