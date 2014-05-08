package com.project.bo;

import java.util.List;

import com.webservice.model.User;

public interface UserBO {
	public List<User> getAll() throws Exception;
	public User getById(String id) throws Exception;
    public User getNamePassword(String name, String password) throws Exception;
	public void addNew(User entity) throws Exception;
	public void update(User entity) throws Exception;
	public void delete(User entity) throws Exception;
}
