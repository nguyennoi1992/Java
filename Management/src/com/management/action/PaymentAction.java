package com.management.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.management.bean.Customer;
import com.management.bean.Employee;
import com.management.bean.Payment;
import com.management.bo.impl.CustomerBOImpl;
import com.management.bo.impl.EmployeeBOImpl;
import com.management.bo.impl.PaymentBOImpl;
import com.management.utils.ProjectConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentAction extends ActionSupport implements ProjectConstants {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Payment> listPayment = new ArrayList<Payment>();
	List<Payment> list = new ArrayList<Payment>();
	Map<String, Object> session = ActionContext.getContext().getSession();
	String account = (String) session.get("account");

	PaymentBOImpl paymentBO = new PaymentBOImpl() ;
	CustomerBOImpl customerBO = new CustomerBOImpl();
	EmployeeBOImpl employeeBO = new EmployeeBOImpl();

	Payment payment = new Payment();
	Customer customer = new Customer();
	Employee employee = new Employee();

	int paymentID;
	int pageUp = 0, pageDown = 0;
	int pageIndex = 1;
	int totalPage = 1;

	public PaymentAction() {
		super();
		// TODO Auto-generated constructor stub
		if(account.compareTo(ACCOUNT_MANAGER) == 0){
			try {
				int total = paymentBO.getAll().size();
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
		} else if(account.compareTo(ACCOUNT_EMPLOYEE) == 0){
			List<Payment> l = new ArrayList<Payment>();
			String userNumber = (String) session.get("userNumber");
			int total = 0;
			try {
				l = paymentBO.getAll();
				for(Payment p: l) {
					if(p.getUserNumber().compareTo(userNumber) == 0) {
						total++;
					}
				}
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
		} else {
			List<Payment> l = new ArrayList<Payment>();
			String userNumber = (String) session.get("userNumber");
			int total = 0;
			try {
				l = paymentBO.getAll();
				for(Payment p: l) {
					if(p.getCustomerNumber().compareTo(userNumber) == 0) {
						total++;
					}
				}
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

	}
	/**
	 * Ham nay thuc hien get list 
	 * @return
	 */
	public String list(){
		if(account.compareTo(ACCOUNT_MANAGER) == 0){
			try {
				list = paymentBO.getAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(account.compareTo(ACCOUNT_EMPLOYEE) == 0){
			List<Payment> l = new ArrayList<Payment>();
			String userNumber = (String) session.get("userNumber");
			try {
				l = paymentBO.getAll();
				for(Payment p: l) {
					if(p.getUserNumber().compareTo(userNumber) == 0) {
						list.add(p);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			List<Payment> l = new ArrayList<Payment>();
			String userNumber = (String) session.get("userNumber");
			try {
				l = paymentBO.getAll();
				for(Payment p: l) {
					if(p.getCustomerNumber().compareTo(userNumber) == 0) {
						list.add(p);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int index = 0, begin = 0;
		begin = (pageIndex - 1) * STATIC_ROW_MAX;
		if(pageIndex < totalPage) {
			index = pageIndex * STATIC_ROW_MAX;
		} else {
			index = list.size();
		}
		try {
			for(int i = 0; i < list.size(); i++) {
				customer = customerBO.getById(list.get(i).getCustomerNumber());
				employee = employeeBO.getById(list.get(i).getUserNumber());
				list.get(i).setCustomerName(customer.getFirstName() + " " + customer.getLastName());
				list.get(i).setEmployeeName(employee.getFirstName() + " " + employee.getLastName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
