package com.project.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.Payment;
import com.project.controller.PaymentController;
import com.project.utilities.ProjectConstants;

public class PaymentAction extends ActionSupport implements ProjectConstants {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<Payment> listPayment = new ArrayList<Payment>();
	List<Payment> list = new ArrayList<Payment>();
	
	PaymentController connP = new PaymentController() ;

	int pageUp = 0, pageDown = 0;
	int pageIndex = 1;
	int totalPage = connP.getAll().size() / STATIC_ROW_MAX + 1;

	/**
	 * Ham nay thuc hien get list 
	 * @return
	 */
	public String list(){
		list = connP.getAll();
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

}
