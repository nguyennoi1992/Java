package com.management.bo;

import java.util.List;

import com.management.bean.Customer;

public interface CustomerBO {
	public List<Customer> getAll() throws Exception;
	public Customer getById(String id) throws Exception;
	public int addNew(Customer entity) throws Exception;
	public int update(Customer entity) throws Exception;
	public int delete(Customer entity) throws Exception;
}
