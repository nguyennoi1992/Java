package com.project.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.Bus;
import com.project.bean.Customer;
import com.project.bean.Kind;
import com.project.controller.BusController;
import com.project.controller.CustomerController;
import com.project.controller.KindController;
import com.project.utilities.ProjectConstants;

public class CustomerAction extends ActionSupport implements
ServletRequestAware, ProjectConstants {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File userImage;
	private String userImageContentType;
	private String userImageFileName;

	private HttpServletRequest servletRequest;

	List<Customer> listCustomer = new ArrayList<Customer>();
	List<Customer> list = new ArrayList<Customer>();
	List<Kind> listKind;
	List<Bus> listBus;
	List<String> listActived = new ArrayList<String>();
	Customer customer = new Customer(); 
	String customerID = null;


	CustomerController connC = new CustomerController();
	KindController connK = new KindController();
	BusController connB = new BusController();

	int pageUp = 0, pageDown = 0;
	int pageIndex = 1;
	int totalPage = connC.getAll().size() / STATIC_ROW_MAX + 1;

	/**
	 * Ham nay thuc hien get list 
	 * @return
	 */
	public String list(){
		list = connC.getAll();
		int index = 0, begin = 0;
		begin = (pageIndex - 1) * STATIC_ROW_MAX;
		if(pageIndex < totalPage) {
			index = pageIndex * STATIC_ROW_MAX;
		} else {
			index = list.size();
		}
		for(int i = begin; i < index; i++) {
			listCustomer.add(list.get(i));				
		}
		return "list";
	}

	public String add(){

		listKind = connK.getAll();

		listBus = connB.getAll();

		listActived.add("Có");
		listActived.add("Không");

		return "add";
	}

	public String create(){
		connC.Insert(customer);
		return list();
	}


	public String details(){
		listKind = connK.getAll();

		listBus = connB.getAll();

		listActived.add("Có");
		listActived.add("Không");

		customer = connC.search(customerID);


		return "details";
	}

	public String update(){
		connC.Update(customer);

		return list();
	}

	public String upload(){
		return "upload";
	}
	
	public String execute() {
		try {

			String filePath = servletRequest.getSession().getServletContext().getRealPath("/") +
					"images\\customers";
			System.out.println("Server path:" + filePath);
			File fileToCreate = new File(filePath, this.userImageFileName);

			FileUtils.copyFile(this.userImage, fileToCreate);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());

			return INPUT;
		}
		
		connC.search(customerID);
		customer.setImage(userImageFileName);
		connC.Update(customer);
		
		return SUCCESS;
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


	public List<Customer> getListCustomer() {
		return listCustomer;
	}



	public void setListCustomer(List<Customer> listCustomer) {
		this.listCustomer = listCustomer;
	}


	public List<Kind> getListKind() {
		return listKind;
	}


	public void setListKind(List<Kind> listKind) {
		this.listKind = listKind;
	}


	public List<Bus> getListBus() {
		return listBus;
	}


	public void setListBus(List<Bus> listBus) {
		this.listBus = listBus;
	}


	public List<String> getListActived() {
		return listActived;
	}


	public void setListActived(List<String> listActived) {
		this.listActived = listActived;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

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
