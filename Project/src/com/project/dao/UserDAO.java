package com.project.dao;

import java.util.List;

import com.project.bean.UserBean;

public interface UserDAO <UseBean>{
	public boolean checkLogin(UserBean entity);
	public List<UseBean> getAll() throws Exception;
    public UseBean getById(int id) throws Exception;
    public void addNew(UseBean entity) throws Exception;
    public void update(UseBean entity) throws Exception;
    public void delete(UseBean entity) throws Exception;
}
