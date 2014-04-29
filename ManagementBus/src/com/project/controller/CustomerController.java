package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.project.bean.Customer;
import com.project.dao.CustomerDAO;

public class CustomerController {

	CustomerDAO dao = new CustomerDAO();
	
	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Customer> getAll(){
		List<Customer> list = new ArrayList<Customer>();
		List<Customer> listAll = dao.getAll();
		for(int i = 0; i < listAll.size(); i++){
			list.add(listAll.get(i));
		}
		
		return list;
	}
	
	public int Insert(Customer bean){
		int result = 0;
		
		result = dao.Insert(bean);

		return result;
	}
	
	public Customer search(String ID) {
		Customer bean = new Customer();
		
		bean  = dao.search(ID);
		
		return bean;
	}
	
	public int Update(Customer bean){
		int result = 0;
		
		result = dao.Update(bean);
		
		return result;
	}
}
