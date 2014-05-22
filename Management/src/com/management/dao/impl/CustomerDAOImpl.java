package com.management.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.management.bean.Customer;
import com.management.dao.CustomerDAO;
import com.management.utils.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO<Customer>{

	@Override
	public List<Customer> getAll() throws Exception {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Customers";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Customer> list = new ArrayList<Customer>();
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				float number1 = Float.parseFloat(row[11].toString());
				int number2 = Integer.parseInt(row[13].toString());
				String dateLimit = "";
				if(row[6] != null) {
					dateLimit = row[6].toString();					 
				} 
				list.add(new Customer(row[0].toString(),
						row[1].toString(),
						row[2].toString(),
						row[3].toString(),
						row[4].toString(),
						row[5].toString(),
						dateLimit,
						row[7].toString(),
						row[8].toString(),
						row[9].toString(),
						row[10].toString(),
						number1,
						row[12].toString(),
						number2,
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

	@Override
	public int addNew(Customer entity) throws Exception {
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
	public int update(Customer entity) throws Exception {
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
	public int delete(Customer entity) throws Exception {
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
