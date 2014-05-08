package com.webservice.dao;

import java.util.List;

public interface PaymentDAO <Payment> {
	public List<Payment> getAll() throws Exception;
	public Payment getById(int id) throws Exception;
	public int addNew(Payment entity) throws Exception;
	public void update(Payment entity) throws Exception;
	public void delete(Payment entity) throws Exception;
}
