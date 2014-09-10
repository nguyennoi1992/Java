package com.management.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.management.bean.BusDetail;
import com.management.bean.Customer;
import com.management.bean.Employee;
import com.management.bean.Logging;
import com.management.bean.Payment;
import com.management.bean.Usebus;
import com.management.bean.User;
import com.management.bo.impl.BusDetailBOImpl;
import com.management.bo.impl.CustomerBOImpl;
import com.management.bo.impl.EmployeeBOImpl;
import com.management.bo.impl.LoggingBOImpl;
import com.management.bo.impl.PaymentBOImpl;
import com.management.bo.impl.UsebusBOImpl;
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
	UsebusBOImpl useBO = new UsebusBOImpl();
	PaymentBOImpl paymentBO= new PaymentBOImpl();
	EmployeeBOImpl employeeBO = new EmployeeBOImpl();
	BusDetailBOImpl busDetailBO = new BusDetailBOImpl();
	LoggingBOImpl loggingBO = new LoggingBOImpl();

	List<User> listUser = new ArrayList<User>();
	List<User> list = new ArrayList<User>();


	List<String> listAccount = new ArrayList<String>();
	String accountID;
	User user = new User();
	Customer customer = new Customer();
	Usebus use = new Usebus();
	Payment payment = new Payment();
	Employee employee = new Employee();

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
		listAccount.add(ACCOUNT_USER);
		listAccount.add(ACCOUNT_EMPLOYEE);
		listAccount.add(ACCOUNT_SUPERVISOR);
		return "add";
	}

	public String addUser(){
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
			List<Payment> listPayment = paymentBO.getAll();
			List<Usebus> listUse = useBO.getAll();
			List<BusDetail> listBusdetail = busDetailBO.getAll();
			List<Logging> listLog = loggingBO.getAll();

			user = userBO.getById(accountID);
			if(user.getAccount().compareTo(ACCOUNT_USER) == 0){
				for(Payment p: listPayment){
					if(p.getCustomerNumber().compareTo(accountID) == 0){
						paymentBO.delete(p);
					}
				}
				for(Usebus u: listUse){
					if(u.getCustomerNumber().compareTo(accountID) == 0){
						useBO.delete(u);
					}
				}

				for(Logging l: listLog){
					if(l.getCustomerNumber().compareTo(accountID) == 0){
						loggingBO.delete(l);
					}
				}

				customer = customerBO.getById(accountID);
				customerBO.delete(customer);

			} else if(user.getAccount().compareTo(ACCOUNT_EMPLOYEE) == 0){
				for(Payment p: listPayment){
					if(p.getUserNumber().compareTo(accountID) == 0){
						paymentBO.delete(p);
					}
				}
				for (BusDetail b: listBusdetail) {
					if(b.getEmployeeNumber().compareTo(accountID) == 0){
						busDetailBO.delete(b);
					}
				}
				for(Logging l: listLog){
					if(l.getUserNumber().compareTo(accountID) == 0){
						loggingBO.delete(l);
					}
				}
				employee = employeeBO.getById(accountID);
				employeeBO.delete(employee);
			}
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

	public List<String> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<String> listAccount) {
		this.listAccount = listAccount;
	}
}
