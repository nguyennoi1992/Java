package com.management.bo;

import java.util.List;

import com.management.model.Payment;

public interface PaymentBO {
	public List<Payment> getAll() throws Exception;
	public Payment getById(int id) throws Exception;
	public int addNew(Payment entity) throws Exception;
	public void update(Payment entity) throws Exception;
	public void delete(Payment entity) throws Exception;
}
