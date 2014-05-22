package com.management.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.management.bean.Customer;
import com.management.bean.Kind;
import com.management.bean.Logging;
import com.management.bo.impl.BusBOImpl;
import com.management.bo.impl.CustomerBOImpl;
import com.management.bo.impl.KindBOImpl;
import com.management.bo.impl.LoggingBOImpl;
import com.management.utils.ProjectConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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
	Map<String, Object> session = ActionContext.getContext().getSession();
	String account = (String) session.get("account");

	List<Customer> listCustomer = new ArrayList<Customer>();
	List<Customer> list = new ArrayList<Customer>();
	List<Kind> listKind;
	List<String> listSex = new ArrayList<String>();
	List<String> listActived = new ArrayList<String>();
	
	
	Customer customer = new Customer(); 
	String customerID = null;


	CustomerBOImpl customerBO = new CustomerBOImpl();
	KindBOImpl kindBO = new KindBOImpl();
	BusBOImpl busBO = new BusBOImpl();
	LoggingBOImpl lockBO = new LoggingBOImpl();
	Logging logging = new Logging();

	int pageUp = 0, pageDown = 0;
	int pageIndex = 1;
	int totalPage = 1;

	public CustomerAction() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Account " + account);
		if(account.compareTo("User") != 0) {
			try {
				totalPage = customerBO.getAll().size() / STATIC_ROW_MAX + 1;
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
		if(account.compareTo("User") != 0){
			try {
				list = customerBO.getAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			String userNumber = (String) session.get("userNumber");
			try {
				list.add(customerBO.getById(userNumber));
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
		for(int i = begin; i < index; i++) {
			listCustomer.add(list.get(i));				
		}

		return "list";
	}

	public String add(){
		if(account.compareTo("User") != 0) {
			try {
				listKind = kindBO.getAll();
				listSex.add("Nam");
				listSex.add("Nữ");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			listActived.add("Có");
			listActived.add("Không");
		}

		return "add";
	}

	public String create(){
		if(account.compareTo("User") != 0) {
			utf8Customer();
			execute();
			customer.setImage(userImageFileName);
			try {
				customerBO.addNew(customer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		list();

		return list();
	}


	public String details(){
		try {
			listKind = kindBO.getAll();
			listSex.add("Nam");
			listSex.add("Nữ");

			listActived.add("Có");
			listActived.add("Không");

			customer = customerBO.getById(customerID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "details";
	}

	public String update(){
		if(account.compareTo("User") != 0) {
			utf8Customer();
			try {
				customerBO.update(customer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list();
	}
	public String image(){ 
		return "image";
	}
	public String upload(){
		if(account.compareTo("User") != 0) {
			execute();
			try {
				customer = customerBO.getById(customerID);
				customer.setImage(userImageFileName);
				customerBO.update(customer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		list();

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

		return SUCCESS;
	}

	public String active() {
		if(account.compareTo("User") != 0) {
			String userNumber = (String) session.get("userNumber");
			logging.setUserNumber(userNumber);
			logging.setDate(now());
			logging.setCustomerNumber(customerID);
			try {
				customer = customerBO.getById(customerID);
				if(customer.getActived().toString().compareTo("Có") == 0) {
					customer.setActived("Không");
					logging.setAction("Kích hoạt tài khoản");
				} else {
					customer.setActived("Có");
					logging.setAction("Khóa tài khoản");
				}
				customerBO.update(customer);
				lockBO.addNew(logging);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		list();

		return "active";
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

	public void utf8Customer() {
		String myparam;
		try {
			myparam = new String(customer.getFirstName().getBytes("8859_1"),"UTF8");
			customer.setFirstName(myparam);
			myparam = new String(customer.getLastName().getBytes("8859_1"),"UTF8");
			customer.setLastName(myparam);
			myparam = new String(customer.getSex().getBytes("8859_1"),"UTF8");
			customer.setSex(myparam);;
			myparam = new String(customer.getSchoolOrCompany().getBytes("8859_1"),"UTF8");
			customer.setSchoolOrCompany(myparam);;
			myparam = new String(customer.getJob().getBytes("8859_1"),"UTF8");
			customer.setJob(myparam);;
			myparam = new String(customer.getAddress().getBytes("8859_1"),"UTF8");
			customer.setAddress(myparam);
			myparam = new String(customer.getActived().getBytes("8859_1"),"UTF8");
			customer.setActived(myparam);;
			myparam = new String(customer.getPlaceEnroll().getBytes("8859_1"),"UTF8");
			customer.setPlaceEnroll(myparam);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public String now(){
		String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
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
	public List<String> getListSex() {
		return listSex;
	}

	public void setListSex(List<String> listSex) {
		this.listSex = listSex;
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
