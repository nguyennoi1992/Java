package com.management.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.bean.Customer;
import com.management.bo.CustomerBO;
import com.management.dao.impl.CustomerDAOImpl;

public class CustomerBOImpl  implements CustomerBO{
	CustomerDAOImpl dao = new CustomerDAOImpl();

	public CustomerDAOImpl getDao() {
		return dao;
	}
	public void setDao(CustomerDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Customer> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<Customer>();
		List<Customer> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new Customer(l.get(i).getCustomerNumber(),
					l.get(i).getFirstName(),
					l.get(i).getLastName(),
					l.get(i).getSex(),
					l.get(i).getDateOfBirth(),
					l.get(i).getImage(),
					l.get(i).getDateLimit(),
					l.get(i).getPhoneNumber(),
					l.get(i).getAddress(),
					l.get(i).getSchoolOrCompany(),
					l.get(i).getJob(),
					l.get(i).getBalance(),
					l.get(i).getPlaceEnroll(),
					l.get(i).getKindNumber(),
					l.get(i).getActived()));
		}
		return list;

	}

	@Override
	public Customer getById(String id) throws Exception {
		// TODO Auto-generated method stub
		List<Customer> list = dao.getAll();
		Customer customer = new Customer();
		for(Customer c: list){
			if(c.getCustomerNumber().toString().compareTo(id) == 0){
				customer = c;
			}
		}
		return customer;
	}

	@Override
	public int addNew(Customer entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.addNew(entity);
		return result;
	}

	@Override
	public int update(Customer entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.update(entity);
		return result;
	}

	@Override
	public int delete(Customer entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.delete(entity);
		return result;
	}
}
