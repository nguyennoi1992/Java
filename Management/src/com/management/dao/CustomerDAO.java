package com.management.dao;

import java.util.List;

public interface CustomerDAO <Customer>{
	public List<Customer> getAll() throws Exception;
	public int addNew(Customer entity) throws Exception;
	public int update(Customer entity) throws Exception;
	public int delete(Customer entity) throws Exception;
}
