package com.management.bo;

import java.util.List;

import com.management.bean.User;

public interface UserBO {
	public List<User> getAll() throws Exception;
	public User getById(String id) throws Exception;
    public User getByNamePassword(String name, String password) throws Exception;
	public int addNew(User entity) throws Exception;
	public int update(User entity) throws Exception;
	public int delete(User entity) throws Exception;
    public boolean checkExistUser(User entity) throws Exception;
    public String validate(User entity) throws Exception;
    public String validateEmail(User entity) throws Exception;
    public boolean sendEmail(String username, String email) throws Exception;    
}
