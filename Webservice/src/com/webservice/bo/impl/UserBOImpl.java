package com.webservice.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.bo.UserBO;
import com.webservice.bean.User;
import com.webservice.dao.impl.UserDAOImpl;

public class UserBOImpl implements UserBO{
	private UserDAOImpl dao = new UserDAOImpl();

	@Override
	public List<User> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		List<User> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new User(l.get(i).getUserNumber(),
					l.get(i).getUsername(),
					l.get(i).getPassword(),
					l.get(i).getEmail(),
					l.get(i).getAccount()));
		}
		return list;
	}

	@Override
	public User getById(String id) throws Exception {
		// TODO Auto-generated method stub
		List<User> list = dao.getAll();
		User user = new User();
		for(User u: list){
			if(u.getUserNumber().toString().compareTo(id) == 0){
				user = u;
			}
		}
		return user;
	}

	@Override
	public User getNamePassword(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		List <User> list = dao.getAll();
		User user = new User();
		for(User u: list){
			if(u.getUsername().toString().compareTo(name) == 0 &&
					u.getPassword().toString().compareTo(password) == 0){
				user = u;
			}
		}
		return user;
	}

	@Override
	public int addNew(User entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.addNew(entity);
		return result;
	}

	@Override
	public int update(User entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.update(entity);
		return result;
	}

	@Override
	public int delete(User entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.delete(entity);
		return result;
	}
}
