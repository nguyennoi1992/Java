package com.management.bo;

import java.util.List;

import com.management.model.Customer;

public interface CustomerBO {
	public List<Customer> getAll() throws Exception;
	public Customer getById(String id) throws Exception;
	public void addNew(Customer entity) throws Exception;
	public void update(Customer entity) throws Exception;
	public void delete(Customer entity) throws Exception;
}
