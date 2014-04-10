package com.project.bo;

import java.util.List;

import com.project.bean.CustomerBean;

public interface CustomerBO {
	public List<CustomerBean> getAll() throws Exception;
    public CustomerBean getById(int id) throws Exception;
    public void addNew(CustomerBean entity) throws Exception;
    public void update(CustomerBean entity) throws Exception;
    public void delete(CustomerBean entity) throws Exception;
}
