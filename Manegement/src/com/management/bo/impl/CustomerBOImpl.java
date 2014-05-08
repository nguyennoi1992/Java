package com.management.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.bo.CustomerBO;
import com.management.dao.impl.CustomerDAOImpl;
import com.management.model.Customer;

public class CustomerBOImpl  implements CustomerBO{
	CustomerDAOImpl dao = new CustomerDAOImpl();

	public CustomerDAOImpl getDao() {
		return dao;
	}
	public void setDao(CustomerDAOImpl dao) {
		this.dao = dao;
	}

	public List<Customer> getAll() throws Exception {
		List<Customer> list = new ArrayList<Customer>();
		List<Customer> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new Customer(l.get(i).getCustomerNumber(),
					l.get(i).getFirstName(),
					l.get(i).getLastName(),
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
					l.get(i).getBusNumber(),
					l.get(i).getActived()));
		}
		return list;

	}

	public Customer getById(String id) throws Exception {
		Customer u = new Customer();
		u = dao.getById(id);
		return u;
	}

	public void addNew(Customer entity) throws Exception {
		dao.addNew(entity);
	}

	public void update(Customer entity) throws Exception {
		dao.update(entity);
	}

	public void delete(Customer entity) throws Exception {
		dao.delete(entity);
	}
}
