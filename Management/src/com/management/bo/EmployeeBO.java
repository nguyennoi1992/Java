package com.management.bo;

import java.util.List;

import com.management.bean.Employee;

public interface EmployeeBO {
	public List<Employee> getAll() throws Exception;
	public Employee getById(String id) throws Exception;
	public int addNew(Employee entity) throws Exception;
	public int update(Employee entity) throws Exception;
	public int delete(Employee entity) throws Exception;
}
