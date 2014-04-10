package com.project.bo;

import java.util.List;

import com.project.bean.UserBean;

public interface UserBO {
	public boolean checkLogin(UserBean entity);
	public List<UserBean> getAll() throws Exception;
	public UserBean getById(int id) throws Exception;
	public void addNew(UserBean entity) throws Exception;
	public void update(UserBean entity) throws Exception;
	public void delete(UserBean entity) throws Exception;
}
