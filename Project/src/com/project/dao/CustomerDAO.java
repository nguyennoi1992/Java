package com.project.dao;

import java.util.List;

public interface CustomerDAO <CustomerBean>{
	public List<CustomerBean> getAll() throws Exception;
    public CustomerBean getById(int id) throws Exception;
    public void addNew(CustomerBean entity) throws Exception;
    public void update(CustomerBean entity) throws Exception;
    public void delete(CustomerBean entity) throws Exception;
}
