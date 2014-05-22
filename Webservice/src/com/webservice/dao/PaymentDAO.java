package com.webservice.dao;

import java.util.List;

public interface PaymentDAO <Payment> {
	public List<Payment> getAll() throws Exception;
	public int addNew(Payment entity) throws Exception;
	public int update(Payment entity) throws Exception;
	public int delete(Payment entity) throws Exception;
}
