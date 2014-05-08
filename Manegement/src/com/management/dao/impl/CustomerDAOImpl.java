package com.management.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.management.dao.CustomerDAO;
import com.management.model.Customer;
import com.management.utils.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO<Customer>{
	public List<Customer> getAll() throws Exception {
		String query = "SELECT * FROM Customers";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Customer> list = new ArrayList<Customer>();
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				float number1 = Float.parseFloat(row[10].toString());
				int number2 = Integer.parseInt(row[12].toString());
				String dateLimit = "";
				if(row[5] != null) {
					dateLimit = row[5].toString();					 
				} 
				list.add(new Customer(row[0].toString(),
						row[1].toString(),
						row[2].toString(),
						row[3].toString(),
						row[4].toString(),
						dateLimit,
						row[6].toString(),
						row[7].toString(),
						row[8].toString(),
						row[9].toString(),
						number1,
						row[11].toString(),
						number2,
						row[13].toString(),
						row[14].toString()));
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
	public Customer getById(String id) throws Exception {
		String query = "SELECT * FROM Customers WHERE customerNumber = '" + id + "'";
		Customer customer = new Customer();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				float number1 = Float.parseFloat(row[10].toString());
				int number2 = Integer.parseInt(row[12].toString());
				String dateLimit = "";
				if(row[5] != null) {
					dateLimit = row[5].toString();					 
				} 
				customer = new Customer(row[0].toString(),
						row[1].toString(),
						row[2].toString(),
						row[3].toString(),
						row[4].toString(),
						dateLimit,
						row[6].toString(),
						row[7].toString(),
						row[8].toString(),
						row[9].toString(),
						number1,
						row[11].toString(),
						number2,
						row[13].toString(),
						row[14].toString());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customer;

	}
	public void addNew(Customer entity) throws Exception {
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
	public void update(Customer entity) throws Exception {
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
	public void delete(Customer entity) throws Exception {
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
