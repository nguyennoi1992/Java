package com.management.dao;

import java.util.List;

public interface EmployeeDAO <Employee> {
	public List<Employee> getAll() throws Exception;
	public int addNew(Employee entity) throws Exception;
	public int update(Employee entity) throws Exception;
	public int delete(Employee entity) throws Exception;

}
