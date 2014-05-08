package com.webservice.dao;

import java.util.List;

public interface UserDAO <User> {
	public List<User> getAll() throws Exception;
    public User getById(String id) throws Exception;
    public User getNamePassword(String name, String password) throws Exception;
    public void addNew(User entity) throws Exception;
    public void update(User entity) throws Exception;
    public void delete(User entity) throws Exception;
}
