package com.management.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.management.bean.Customer;
import com.management.bean.Kind;
import com.management.bean.Logging;
import com.management.bean.Usebus;
import com.management.bo.impl.CustomerBOImpl;
import com.management.bo.impl.KindBOImpl;
import com.management.bo.impl.LoggingBOImpl;
import com.management.bo.impl.UsebusBOImpl;
import com.management.utils.ProjectConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class KindAction extends ActionSupport implements ProjectConstants {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Kind> listKind = new ArrayList<Kind>();
	List<Kind> list = new ArrayList<Kind>();
	Map<String, Object> session = ActionContext.getContext().getSession();
	String account = (String) session.get("account");

	KindBOImpl kindBO = new KindBOImpl();
	CustomerBOImpl customerBO = new CustomerBOImpl();
	UsebusBOImpl useBO = new UsebusBOImpl();
	LoggingBOImpl loggingBO = new LoggingBOImpl();

	Kind kind = new Kind();

	int kindID;
	int pageUp = 0, pageDown = 0;
	int pageIndex = 1;
	int totalPage = 1;

	public KindAction() {
		super();
		// TODO Auto-generated constructor stub
		try {
			int total = kindBO.getAll().size();
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

	public String list(){
		try {
			list = kindBO.getAll();
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
			listKind.add(list.get(i));				
		}
		return "list";
	}

	public String add(){
		return "add";
	}

	public String create(){
		if(account.compareTo(ACCOUNT_USER) != 0) {
			utf8Kind();
			try {
				kindBO.addNew(kind);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list();
	}

	public String details(){
		try {
			kind = kindBO.getById(kindID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "details";
	}

	public String update(){
		utf8Kind();
		try {
			kindBO.update(kind);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list();
	}
	public String delete() {

		try {
			List<Customer> listCustomer = customerBO.getAll();
			List<Usebus> listUse = useBO.getAll();
			List<Logging> listLog = loggingBO.getAll();

			for(Customer c: listCustomer){
				if(c.getKindNumber() == kindID){
					for(Usebus u: listUse){
						if(u.getCustomerNumber().compareTo(c.getCustomerNumber()) == 0){
							useBO.delete(u);
						}
					}
					for(Logging l: listLog){
						if(l.getCustomerNumber().compareTo(c.getCustomerNumber()) == 0){
							loggingBO.delete(l);
						}
					}
					customerBO.delete(c);
				}

			}
			kind = kindBO.getById(kindID);
			kindBO.delete(kind);
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

	public void utf8Kind(){
		String myparam;
		try {
			myparam = new String(kind.getKind().getBytes("8859_1"),"UTF8");
			kind.setKind(myparam);
			myparam = new String(kind.getType().getBytes("8859_1"),"UTF8");
			kind.setType(myparam);
			myparam = new String(kind.getCategory().getBytes("8859_1"),"UTF8");
			kind.setCategory(myparam);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Kind> getListKind() {
		return listKind;
	}

	public void setListKind(List<Kind> listKind) {
		this.listKind = listKind;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public int getKindID() {
		return kindID;
	}

	public void setKindID(int kindID) {
		this.kindID = kindID;
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
