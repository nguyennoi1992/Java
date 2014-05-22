package com.project.bo;

import java.util.List;

import com.webservice.bean.User;

public interface UserBO {
	public List<User> getAll() throws Exception;
	public User getById(String id) throws Exception;
    public User getNamePassword(String name, String password) throws Exception;
	public int addNew(User entity) throws Exception;
	public int update(User entity) throws Exception;
	public int delete(User entity) throws Exception;
}
