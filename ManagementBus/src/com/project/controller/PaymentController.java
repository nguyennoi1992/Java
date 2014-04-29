package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.project.bean.Customer;
import com.project.bean.Payment;
import com.project.dao.CustomerDAO;
import com.project.dao.PaymentDAO;

public class PaymentController {

	PaymentDAO dao = new PaymentDAO();
	CustomerDAO daoC = new CustomerDAO();
	
	public PaymentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Payment> getAll(){
		List<Payment> list = new ArrayList<Payment>();
		List<Payment> listAll = dao.getAll();
		for(int i = 0; i < listAll.size(); i++){
			Customer cus = new Customer();
			cus = daoC.search(listAll.get(i).getCustomerNumber());
			listAll.get(i).setName(cus.getFirstName() + " " + cus.getLastName());
			list.add(listAll.get(i));
		}

		return list;
	}
}
