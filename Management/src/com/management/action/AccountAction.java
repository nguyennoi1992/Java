package com.management.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.management.bean.Customer;
import com.management.bean.User;
import com.management.bo.impl.CustomerBOImpl;
import com.management.bo.impl.UserBOImpl;
import com.management.utils.ProjectConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport implements ProjectConstants{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Map<String, Object> session = ActionContext.getContext().getSession();
	String account = (String) session.get("account");

	UserBOImpl userBO = new UserBOImpl();
	CustomerBOImpl customerBO = new CustomerBOImpl();

	List<User> listUser = new ArrayList<User>();
	List<User> list = new ArrayList<User>();

	List<String> listID = new ArrayList<String>();

	String accountID;
	User user = new User();

	int pageUp = 0, pageDown = 0;
	int pageIndex = 1;
	int totalPage = 1;

	public AccountAction() {
		super();
		// TODO Auto-generated constructor stub
		try {
			int total = userBO.getAll().size();
			int div = total / STATIC_ROW_MAX;
			if(div * STATIC_ROW_MAX == total) {
				totalPage = div;
			} else {
				totalPage = div + 1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String list() {
		try {
			list = userBO.getAll();
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
			listUser.add(list.get(i));				
		}
		return "list";
	}

	public String add(){
		List<Customer> listCustomer = new ArrayList<Customer>();
		try {
			listCustomer = customerBO.getAll();
			list = userBO.getAll();
			for(Customer cus: listCustomer) {
				int check = 0;
				for(User us: list) {
					if(cus.getCustomerNumber().compareTo(us.getUserNumber()) == 0) {
						check = 1;
						break;
					}
				}
				if(check == 0) {
					listID.add(cus.getCustomerNumber());
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "add";
	}

	public String addUser(){
		user.setAccount("User");
		try {
			userBO.addNew(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list();
	}

	public String delete() {
		try {
			user = userBO.getById(accountID);
			userBO.delete(user);
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
	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public List<String> getListID() {
		return listID;
	}

	public void setListID(List<String> listID) {
		this.listID = listID;
	}
}
