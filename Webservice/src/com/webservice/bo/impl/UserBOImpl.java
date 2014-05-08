package com.webservice.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.bo.UserBO;
import com.webservice.dao.impl.UserDAOImpl;
import com.webservice.model.User;

public class UserBOImpl implements UserBO{
	private UserDAOImpl dao = new UserDAOImpl();

	public List<User> getAll() throws Exception {
		List<User> list = new ArrayList<User>();
		List<User> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new User(l.get(i).getUserNumber(),
					l.get(i).getUsername(),
					l.get(i).getPassword(),
					l.get(i).getEmail(),
					l.get(i).getBusNumber()));
		}
		return list;
	}

	public User getById(String id) throws Exception {
		User u = new User();
		u = dao.getById(id);
		return u;
	}

	public User getNamePassword(String name, String password) throws Exception {
		User u = new User();
		u = dao.getNamePassword(name, password);
		return u;
	}


	public void addNew(User entity) throws Exception {
		dao.addNew(entity);
	}

	public void update(User entity) throws Exception {
		dao.update(entity);
	}

	public void delete(User entity) throws Exception {
		dao.delete(entity);
	}
}
