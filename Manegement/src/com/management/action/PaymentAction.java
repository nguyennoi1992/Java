package com.management.action;

import java.util.ArrayList;
import java.util.List;

import com.management.bo.impl.PaymentBOImpl;
import com.management.model.Payment;
import com.management.utils.ProjectConstants;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentAction extends ActionSupport implements ProjectConstants {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Payment> listPayment = new ArrayList<Payment>();
	List<Payment> list = new ArrayList<Payment>();

	PaymentBOImpl paymentBO = new PaymentBOImpl() ;

	Payment payment = new Payment();
	int paymentID;
	int pageUp = 0, pageDown = 0;
	int pageIndex = 1;
	int totalPage = 1;

	public PaymentAction() {
		super();
		// TODO Auto-generated constructor stub
		try {
			totalPage = paymentBO.getAll().size() / STATIC_ROW_MAX + 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Ham nay thuc hien get list 
	 * @return
	 */
	public String list(){
		try {
			list = paymentBO.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int index = 0, begin = 0;
		begin = (pageIndex - 1) * STATIC_ROW_MAX;
		if(pageIndex < totalPage) {
			index = pageIndex * STATIC_ROW_MAX;
		} else {
			index = list.size();
		}
		for(int i = begin; i < index; i++) {
			listPayment.add(list.get(i));				
		}
		return "list";
	}
	public String delete() {
		try {
			payment = paymentBO.getById(paymentID);
			paymentBO.delete(payment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list();
		return "delete";
	}

	public String page() {
		if(pageUp != 0) {
			pageIndex = pageUp;
			if(pageIndex < totalPage) {
				pageIndex++;
			}
		}

		if(pageDown != 0) {
			pageIndex = pageDown;
			if(pageIndex > 1) {
				pageIndex--;
			}
		}

		list();
		return "page";
	}

	public List<Payment> getListPayment() {
		return listPayment;
	}


	public void setListPayment(List<Payment> listPayment) {
		this.listPayment = listPayment;
	}

	public int getPageUp() {
		return pageUp;
	}

	public void setPageUp(int pageUp) {
		this.pageUp = pageUp;
	}

	public int getPageDown() {
		return pageDown;
	}

	public void setPageDown(int pageDown) {
		this.pageDown = pageDown;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	

}
