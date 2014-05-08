package com.management.dao;

import java.util.List;

public interface UserDAO <User> {
	public List<User> getAll() throws Exception;
    public User getById(String id) throws Exception;
    public User getByNamePassword(String name, String password) throws Exception;
    public void addNew(User entity) throws Exception;
    public void update(User entity) throws Exception;
    public void delete(User entity) throws Exception;
    public boolean checkExistUser(User entity) throws Exception;
    public User getByNameEmail(String username, String email) throws Exception;
}
