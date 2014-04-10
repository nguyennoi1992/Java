package com.project.bo;

import java.util.List;

import com.project.bean.PaymentBean;

public interface PaymentBO {
	public List<PaymentBean> getAll() throws Exception;
    public PaymentBean getById(int id) throws Exception;
    public void addNew(PaymentBean entity) throws Exception;
    public void update(PaymentBean entity) throws Exception;
    public void delete(PaymentBean entity) throws Exception;
}
