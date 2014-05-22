package com.webservice.dao;

import java.util.List;

public interface UserDAO <User> {
	public List<User> getAll() throws Exception;
    public int addNew(User entity) throws Exception;
    public int update(User entity) throws Exception;
    public int delete(User entity) throws Exception;
}
