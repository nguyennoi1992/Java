package com.project.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.BusBean;
import com.project.controller.BusController;

public class BusAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<BusBean> listBus = new ArrayList<BusBean>();
	
	BusBean bus = new BusBean();

	String busID;
	
	BusController connB = new BusController() ;

	/**
	 * Ham nay thuc hien get list 
	 * @return
	 */
	public String list(){

		listBus = connB.view();
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
		listBus = connB.view();
		return "update";
	}
	
	public List<BusBean> getListBus() {
		return listBus;
	}


	public void setListBus(List<BusBean> listBus) {
		this.listBus = listBus;
	}

	public BusBean getBus() {
		return bus;
	}

	public void setBus(BusBean bus) {
		this.bus = bus;
	}

	public String getBusID() {
		return busID;
	}

	public void setBusID(String busID) {
		this.busID = busID;
	}


	
	

}
