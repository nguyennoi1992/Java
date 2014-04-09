package com.project.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.PaymentBean;
import com.project.controller.PaymentController;

public class PaymentAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<PaymentBean> listPayment = new ArrayList<PaymentBean>();

	/**
	 * Ham nay thuc hien get list 
	 * @return
	 */
	public String list(){

		PaymentController conn = new PaymentController() ;
		listPayment = conn.view();
		return "list";
	}

	
	public List<PaymentBean> getListPayment() {
		return listPayment;
	}


	public void setListPayment(List<PaymentBean> listPayment) {
		this.listPayment = listPayment;
	}

}
