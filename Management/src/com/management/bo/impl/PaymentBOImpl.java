package com.management.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.bean.Payment;
import com.management.bo.PaymentBO;
import com.management.dao.impl.PaymentDAOImpl;

public class PaymentBOImpl  implements PaymentBO{
	PaymentDAOImpl dao = new PaymentDAOImpl();

	public PaymentDAOImpl getDao() {
		return dao;
	}
	public void setDao(PaymentDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Payment> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<Payment> list = new ArrayList<Payment>();
		List<Payment> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new Payment(l.get(i).getPaymentNumber(),
					l.get(i).getDate(),
					l.get(i).getPlace(),
					l.get(i).getCustomerNumber(),
					l.get(i).getUserNumber(),
					l.get(i).getNumberPlate()));
		}
		return list;
	}

	@Override
	public Payment getById(int id) throws Exception {
		// TODO Auto-generated method stub
		List<Payment> list = dao.getAll();
		Payment payment = new Payment();
		for(Payment p: list){
			if(p.getPaymentNumber() == id){
				payment = p;
			}
		}
		return payment;
	}

	@Override
	public int addNew(Payment entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.addNew(entity);
		return result;
	}

	@Override
	public int update(Payment entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.update(entity);
		return result;
	}

	@Override
	public int delete(Payment entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.delete(entity);
		return result;
	}
}
