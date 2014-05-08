package com.management.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.bo.PaymentBO;
import com.management.dao.impl.CustomerDAOImpl;
import com.management.dao.impl.PaymentDAOImpl;
import com.management.model.Customer;
import com.management.model.Payment;

public class PaymentBOImpl  implements PaymentBO{
	PaymentDAOImpl dao = new PaymentDAOImpl();
	CustomerDAOImpl daoC = new CustomerDAOImpl();

	public List<Payment> getAll() throws Exception {
		List<Payment> listAll = new ArrayList<Payment>();
		List<Payment> list = new ArrayList<Payment>();
		List<Payment> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new Payment(l.get(i).getPaymentNumber(),
					l.get(i).getDate(),
					l.get(i).getPlace(),
					l.get(i).getCustomerNumber(),
					l.get(i).getBusNumber()));
		}
		for(int i = 0; i < list.size(); i++){
			Customer cus = new Customer();
			cus = daoC.getById(list.get(i).getCustomerNumber());
			list.get(i).setName(cus.getFirstName() + " " + cus.getLastName());
			listAll.add(list.get(i));
		}
		return listAll;
	}

	public Payment getById(int id) throws Exception {
		Payment u = new Payment();
		u = dao.getById(id);
		return u;
	}

	public int addNew(Payment entity) throws Exception {
		int result = 0;
		result = dao.addNew(entity);
		return result;
	}

	public void update(Payment entity) throws Exception {
		dao.update(entity);
	}

	public void delete(Payment entity) throws Exception {
		dao.delete(entity);
	}
}
