package com.management.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.bean.Employee;
import com.management.bo.EmployeeBO;
import com.management.dao.impl.EmployeeDAOImpl;

public class EmployeeBOImpl implements EmployeeBO {
	EmployeeDAOImpl dao = new EmployeeDAOImpl();

	@Override
	public List<Employee> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<Employee>();
		List<Employee> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new Employee(l.get(i).getEmployeeNumber(),
					l.get(i).getFirstName(),
					l.get(i).getLastName(),
					l.get(i).getSex(),
					l.get(i).getDateOfBirth(),
					l.get(i).getImage(),
					l.get(i).getAddress(),
					l.get(i).getPhoneNumber(),
					l.get(i).getPosition(),
					l.get(i).getActived()));
		}
		return list;
	}

	@Override
	public Employee getById(String id) throws Exception {
		// TODO Auto-generated method stub
		List<Employee> list = dao.getAll();
		Employee Employee = new Employee();
		for(Employee b: list){
			if(b.getEmployeeNumber().toString().compareTo(id) == 0){
				Employee = b;
			}
		}
		return Employee;
	}

	@Override
	public int addNew(Employee entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.addNew(entity);
		return result;
	}

	@Override
	public int update(Employee entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.update(entity);
		return result;
	}

	@Override
	public int delete(Employee entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.delete(entity);
		return result;
	}
}
