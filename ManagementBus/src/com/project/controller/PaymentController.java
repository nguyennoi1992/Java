package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.project.bean.PaymentBean;
import com.project.dao.PaymentDAO;

public class PaymentController {

	PaymentDAO dao = new PaymentDAO();

	public PaymentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<PaymentBean> view(){
		List<PaymentBean> list = new ArrayList<PaymentBean>();
		List<PaymentBean> listAll = dao.getAll();
		for(int i = 0; i < listAll.size(); i++){
			list.add(listAll.get(i));
		}

		return list;
	}
}
