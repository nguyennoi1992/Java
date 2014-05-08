package com.management.dao;

import java.util.List;

public interface CustomerDAO <Customer>{
	public List<Customer> getAll() throws Exception;
	public Customer getById(String id) throws Exception;
	public void addNew(Customer entity) throws Exception;
	public void update(Customer entity) throws Exception;
	public void delete(Customer entity) throws Exception;
}
