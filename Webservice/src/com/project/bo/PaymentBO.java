package com.project.bo;

import java.util.List;

import com.webservice.bean.Payment;

public interface PaymentBO {
	public List<Payment> getAll() throws Exception;
	public Payment getById(int id) throws Exception;
	public int addNew(Payment entity) throws Exception;
	public int update(Payment entity) throws Exception;
	public int delete(Payment entity) throws Exception;
}
