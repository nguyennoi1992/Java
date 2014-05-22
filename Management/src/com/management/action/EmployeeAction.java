package com.management.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.management.bean.Employee;
import com.management.bo.impl.EmployeeBOImpl;
import com.management.utils.ProjectConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport implements
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

	List<Employee> listEmployee = new ArrayList<Employee>();
	List<Employee> list = new ArrayList<Employee>();
	Employee employee = new Employee();

	List<String> listSex = new ArrayList<String>();
	List<String> listActived = new ArrayList<String>();

	EmployeeBOImpl employeeBO = new EmployeeBOImpl();

	String employeeID;
	int pageUp = 0, pageDown = 0;
	int pageIndex = 1;
	int totalPage = 1;

	public EmployeeAction() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Account " + account);
		if(account.compareTo("Manager") == 0) {
			try {
				totalPage = employeeBO.getAll().size() / STATIC_ROW_MAX + 1;
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
		if(account.compareTo("Manager") == 0){
			try {
				list = employeeBO.getAll();
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
			listEmployee.add(list.get(i));				
		}

		return "list";
	}

	public String add(){
		if(account.compareTo("Manager") == 0) {
			listSex.add("Nam");
			listSex.add("Nữ");
			listActived.add("Có");
			listActived.add("Không");
		}

		return "add";
	}

	public String create(){
		if(account.compareTo("Manager") == 0) {
			utf8Employee();;
			execute();
			employee.setImage(userImageFileName);
			try {
				employeeBO.addNew(employee);
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
			listSex.add("Nam");
			listSex.add("Nữ");
			listActived.add("Có");
			listActived.add("Không");
			employee = employeeBO.getById(employeeID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "details";
	}

	public String update(){
		if(account.compareTo("Manager") == 0) {
			utf8Employee();;
			try {
				employeeBO.update(employee);
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
		if(account.compareTo("Manager") == 0) {
			execute();
			try {
				employee = employeeBO.getById(employeeID);
				employee.setImage(userImageFileName);
				employeeBO.update(employee);
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
		if(account.compareTo("Manager") == 0) {
			try {
				employee = employeeBO.getById(employeeID);
				if(employee.getActived().toString().compareTo("Có") == 0) {
					employee.setActived("Không");
				} else {
					employee.setActived("Có");
				}
				employeeBO.update(employee);
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

	public void utf8Employee() {
		String myparam;
		try {
			myparam = new String(employee.getFirstName().getBytes("8859_1"),"UTF8");
			employee.setFirstName(myparam);
			myparam = new String(employee.getLastName().getBytes("8859_1"),"UTF8");
			employee.setLastName(myparam);
			myparam = new String(employee.getSex().getBytes("8859_1"),"UTF8");
			employee.setSex(myparam);;
			myparam = new String(employee.getAddress().getBytes("8859_1"),"UTF8");
			employee.setAddress(myparam);
			myparam = new String(employee.getActived().getBytes("8859_1"),"UTF8");
			employee.setActived(myparam);;
			myparam = new String(employee.getAddress().getBytes("8859_1"),"UTF8");
			employee.setAddress(myparam);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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

	public List<Employee> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
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

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}


}
