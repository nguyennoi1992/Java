package com.project.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.BusBean;
import com.project.bean.CustomerBean;
import com.project.bean.KindBean;
import com.project.controller.BusController;
import com.project.controller.CustomerController;
import com.project.controller.KindController;

public class CustomerAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<CustomerBean> listCustomer = new ArrayList<CustomerBean>();
	List<KindBean> listKind;
	List<BusBean> listBus;
	List<String> listActived = new ArrayList<String>();
	CustomerBean customer = new CustomerBean(); 
	String customerID = null;
	
	
	CustomerController connC = new CustomerController();
	KindController connK = new KindController();
	BusController connB = new BusController();

	/**
	 * Ham nay thuc hien get list 
	 * @return
	 */
	public String list(){
		listCustomer = connC.view();
		return "list";
	}

	public String add(){
		
		listKind = connK.view();
		
		listBus = connB.view();
				
		listActived.add("Có");
		listActived.add("Không");

		return "add";
	}
	
	public String create(){
		connC.Insert(customer);
		return list();
	}
	
	
	public String details(){
		listKind = connK.view();
		
		listBus = connB.view();
				
		listActived.add("Có");
		listActived.add("Không");
		
		customer = connC.search(customerID);

		
		return "details";
	}
	
	public String update(){
		connC.Update(customer);
		
		return list();
	}
	
	public List<CustomerBean> getListCustomer() {
		return listCustomer;
	}



	public void setListCustomer(List<CustomerBean> listCustomer) {
		this.listCustomer = listCustomer;
	}


	public List<KindBean> getListKind() {
		return listKind;
	}


	public void setListKind(List<KindBean> listKind) {
		this.listKind = listKind;
	}


	public List<BusBean> getListBus() {
		return listBus;
	}


	public void setListBus(List<BusBean> listBus) {
		this.listBus = listBus;
	}


	public List<String> getListActived() {
		return listActived;
	}


	public void setListActived(List<String> listActived) {
		this.listActived = listActived;
	}


	public CustomerBean getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}


}
