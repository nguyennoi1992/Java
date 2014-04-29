package com.project.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.Bus;
import com.project.controller.BusController;
import com.project.utilities.ProjectConstants;

public class BusAction extends ActionSupport implements ProjectConstants{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Bus> listBus = new ArrayList<Bus>();
	List<Bus> list = new ArrayList<Bus>();


	BusController connB = new BusController() ;

	Bus bus = new Bus();

	String busID;
	int pageUp = 0, pageDown = 0;
	int pageIndex = 1;
	int totalPage = connB.getAll().size() / STATIC_ROW_MAX + 1;



	/**
	 * Ham nay thuc hien get list 
	 * @return
	 */
	public String list(){
		list = connB.getAll();
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
		connB.Insert(bus);
		return list();
	}

	public String details(){
		bus = connB.search(busID);
		return "details";
	}

	public String update(){
		connB.Update(bus);
		listBus = connB.getAll();
		return "update";
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





}
