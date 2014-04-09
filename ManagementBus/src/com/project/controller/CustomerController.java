package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.project.bean.CustomerBean;
import com.project.dao.CustomerDAO;

public class CustomerController {

	CustomerDAO dao = new CustomerDAO();
	
	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<CustomerBean> view(){
		List<CustomerBean> list = new ArrayList<CustomerBean>();
		List<CustomerBean> listAll = dao.getAll();
		for(int i = 0; i < listAll.size(); i++){
			list.add(listAll.get(i));
		}
		
		return list;
	}
	
	public int Insert(CustomerBean bean){
		int result = 0;
		
		result = dao.Insert(bean);

		return result;
	}
	
	public CustomerBean search(String ID) {
		CustomerBean bean = new CustomerBean();
		
		bean  = dao.search(ID);
		
		return bean;
	}
	
	public int Update(CustomerBean bean){
		int result = 0;
		
		result = dao.Update(bean);
		
		return result;
	}
}
