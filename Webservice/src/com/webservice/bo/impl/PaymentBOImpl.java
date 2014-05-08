package com.webservice.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.bo.PaymentBO;
import com.webservice.dao.impl.PaymentDAOImpl;
import com.webservice.model.Payment;

public class PaymentBOImpl  implements PaymentBO{
	PaymentDAOImpl dao = new PaymentDAOImpl();

	public PaymentDAOImpl getDao() {
		return dao;
	}
	public void setDao(PaymentDAOImpl dao) {
		this.dao = dao;
	}

	public List<Payment> getAll() throws Exception {
		List<Payment> list = new ArrayList<Payment>();
		List<Payment> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new Payment(l.get(i).getPaymentNumber(),
					l.get(i).getDate(),
					l.get(i).getPlace(),
					l.get(i).getCustomerNumber(),
					l.get(i).getBusNumber()));
		}
		return list;
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
