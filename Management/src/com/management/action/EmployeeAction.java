package com.management.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.management.bean.BusDetail;
import com.management.bean.Employee;
import com.management.bean.User;
import com.management.bo.impl.BusDetailBOImpl;
import com.management.bo.impl.EmployeeBOImpl;
import com.management.bo.impl.UserBOImpl;
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
	UserBOImpl userBO = new UserBOImpl();

	List<String> listID = new ArrayList<String>();
	String employeeID;
	String name;
	String numberPlate;
	int pageUp = 0, pageDown = 0;
	int pageIndex = 1;
	int totalPage = 1;

	public EmployeeAction() {
		super();
		// TODO Auto-generated constructor stub
		if(account.compareTo(ACCOUNT_MANAGER) == 0){
			try {
				int total = employeeBO.getAll().size();
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
			try {
				List<Employee> l = employeeBO.getAll();
				for(Employee e: l){
					if(e.getPosition().compareTo(POSITION_SUPERVISOR) != 0){
						list.add(e);
					}
				}
				int total = list.size();
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
		if(name == null) {
			if(account.compareTo(ACCOUNT_MANAGER) == 0){
				try {
					list = employeeBO.getAll();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					List<Employee> l = employeeBO.getAll();
					for(Employee e: l){
						if(e.getPosition().compareTo(POSITION_SUPERVISOR) != 0){
							list.add(e);
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} else {
			List<Employee> l = new ArrayList<Employee>();
			try {
				l = employeeBO.getAll();
				for(Employee cus: l) {
					String EmployeeName = cus.getFirstName() + " " + cus.getLastName();
					if(EmployeeName.compareTo(name) == 0) {
						list.add(cus);
					}
				}
				int total = list.size();
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
		listSex.add(SEX_NAM);
		listSex.add(SEX_NU);
		listActived.add(ACTIVED_YES);
		listActived.add(ACTIVED_NO);
		List<User> l = new ArrayList<User>();
		try {
			l = userBO.getAll();
			list = employeeBO.getAll();
			for(User u: l){
				int check = 0;
				for(Employee e: list){
					if(u.getUserNumber().compareTo(e.getEmployeeNumber()) == 0
							&& u.getAccount().compareTo(ACCOUNT_EMPLOYEE) == 0){
						check++;
					}
				}
				if(check == 0 && u.getAccount().compareTo(ACCOUNT_EMPLOYEE) == 0){
					listID.add(u.getUserNumber());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "add";
	}

	public String create(){
		utf8Employee();;
		execute();
		employee.setImage(userImageFileName);
		try {
			employeeBO.addNew(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list();
	}


	public String details(){
		try {
			listSex.add(SEX_NAM);
			listSex.add(SEX_NU);
			listActived.add(ACTIVED_YES);
			listActived.add(ACTIVED_NO);
			employee = employeeBO.getById(employeeID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "details";
	}

	public String update(){
		utf8Employee();
		try {
			employeeBO.update(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list();
	}

	public String image(){ 
		return "image";
	}


	public String upload(){
		execute();
		try {
			employee = employeeBO.getById(employeeID);
			employee.setImage(userImageFileName);
			employeeBO.update(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		try {
			employee = employeeBO.getById(employeeID);
			if(employee.getActived().toString().compareTo(ACTIVED_YES) == 0) {
				employee.setActived(ACTIVED_NO);
			} else {
				employee.setActived(ACTIVED_YES);
			}
			employeeBO.update(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list();

		return "active";
	}


	public String profile(){
		String userNumber = (String) session.get("userNumber");
		BusDetailBOImpl busDetailBO = new BusDetailBOImpl();
		List<BusDetail> l = new ArrayList<BusDetail>(); 

		try {
			employee = employeeBO.getById(userNumber);
			System.out.println("position " + employee.getPosition());
			session.put("position", employee.getPosition());
			l = busDetailBO.getAll();
			if(employee.getPosition().compareTo("Lái xe") == 0){
				for(BusDetail bd: l) {
					System.out.println("employeeNumber " + bd.getEmployeeNumber());					
					if(bd.getEmployeeNumber().compareTo(employee.getEmployeeNumber()) == 0){
						System.out.println("numberPlate1 " + bd.getNumberPlate());
						numberPlate = bd.getNumberPlate();					
					}
				}
			}
			System.out.println("numberPlate " + numberPlate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "profile";
	}

	public String search(){
		return list();
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
			myparam = new String(employee.getPosition().getBytes("8859_1"),"UTF8");
			employee.setPosition(myparam);
			myparam = new String(employee.getActived().getBytes("8859_1"),"UTF8");
			employee.setActived(myparam);;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String myparam;
		try {
			myparam = new String(name.getBytes("8859_1"),"UTF8");
			this.name = myparam;
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public List<String> getListID() {
		return listID;
	}

	public void setListID(List<String> listID) {
		this.listID = listID;
	}
}
