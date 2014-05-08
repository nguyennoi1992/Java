package com.management.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.management.dao.UserDAO;
import com.management.model.User;
import com.management.utils.HibernateUtil;

public class UserDAOImpl implements UserDAO<User>{
	public List<User> getAll() throws Exception {
		String query = "select * from Users";

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<User> list = new ArrayList<User>();
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				list.add(new User(row[0].toString(),
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
	public User getById(String id) throws Exception {
		String query = "select * from Users where UserNumber = '" + id + "'";
		User user = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				user = new User(row[0].toString(),
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
		return user;

	}
	public User getByNamePassword(String name, String password) throws Exception {
		String query = "SELECT * FROM Users WHERE userName = '" + name
				+ "' AND password = '" + password + "'";
		User user = new User();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				user = new User(row[0].toString(),
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
		return user;
	}

	public void addNew(User entity) throws Exception {
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
	public void update(User entity) throws Exception {
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
	public void delete(User entity) throws Exception {
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
	
    public boolean checkExistUser(User entity) throws Exception {
		
    	String username = entity.getUsername();
		String password = entity.getPassword();
    	
		String query = "SELECT * FROM Users WHERE userName = '" + username
				+ "' AND password = '" + password + "'";
		boolean ans = false;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<User> list = session.createSQLQuery(query).list();
			if(list.size() != 0) {
				ans = true;
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ans;

    }
    
    public User getByNameEmail(String username, String email) throws Exception {
		String query = "select * from Users where Username = '" + username
				+ "' AND Email = '" + email + "'";
		User user = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for(Object[] row:(List<Object[]>) session.createSQLQuery(query).list()) {
				user = new User(row[0].toString(),
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
		return user;    	
    }

}
