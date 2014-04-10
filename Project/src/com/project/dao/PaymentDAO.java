package com.project.dao;

import java.util.List;

public interface PaymentDAO <PaymentBean>{
	public List<PaymentBean> getAll() throws Exception;
    public PaymentBean getById(int id) throws Exception;
    public void addNew(PaymentBean entity) throws Exception;
    public void update(PaymentBean entity) throws Exception;
    public void delete(PaymentBean entity) throws Exception;
}
