package com.project.action;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.CustomerBean;
import com.project.bo.CustomerBO;

public class CustomerAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<CustomerBean> listCustomer = new ArrayList<CustomerBean>();

	CustomerBO customerBO;

	//DI via Spring
	public void setCustomerBO(CustomerBO customerBO) {
		this.customerBO = customerBO;
	}

	/**
	 * Ham nay thuc hien get list 
	 * @return
	 * @throws Exception 
	 */
	public String list() throws Exception {

		listCustomer = customerBO.getAll();
		return "list";
	}


	public List<CustomerBean> getListCustomer() {
		return listCustomer;
	}



	public void setListCustomer(List<CustomerBean> listCustomer) {
		this.listCustomer = listCustomer;
	}


}
