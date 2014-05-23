package com.management.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.management.bean.Bus;
import com.management.bo.impl.BusBOImpl;
import com.management.utils.ProjectConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BusAction extends ActionSupport implements ProjectConstants{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Bus> listBus = new ArrayList<Bus>();
	List<Bus> list = new ArrayList<Bus>();
	Map<String, Object> session = ActionContext.getContext().getSession();
	String account = (String) session.get("account");


	BusBOImpl busBO = new BusBOImpl() ;

	Bus bus = new Bus();

	String busID;
	int pageUp = 0, pageDown = 0;
	int pageIndex = 1;
	int totalPage = 1;

	public BusAction() {
		super();
		// TODO Auto-generated constructor stub
		try {
			int total = busBO.getAll().size();
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


	/**
	 * Ham nay thuc hien get list 
	 * @return
	 */
	public String list(){
		try {
			list = busBO.getAll();
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
			listBus.add(list.get(i));				
		}
		return "list";
	}

	public String add(){
		return "add";
	}

	public String create(){
		utf8Bus();
		try {
			busBO.addNew(bus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list();
	}

	public String details(){
		try {
			bus = busBO.getById(busID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "details";
	}

	public String update(){
		utf8Bus();
		try {
			busBO.update(bus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list();
		return list();
	}

	public String delete() {
		try {
			bus = busBO.getById(busID);
			busBO.delete(bus);
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

	public void utf8Bus(){
		String myparam;
		try {
			myparam = new String(bus.getDetails().getBytes("8859_1"),"UTF8");
			bus.setDetails(myparam);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Bus> getListBus() {
		return listBus;
	}


	public void setListBus(List<Bus> listBus) {
		this.listBus = listBus;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public String getBusID() {
		return busID;
	}

	public void setBusID(String busID) {
		this.busID = busID;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public List<Bus> getList() {
		return list;
	}


	public void setList(List<Bus> list) {
		this.list = list;
	}
}
