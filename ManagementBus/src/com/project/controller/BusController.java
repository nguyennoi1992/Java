package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.project.bean.BusBean;
import com.project.dao.BusDAO;


public class BusController {

	BusDAO dao = new BusDAO();

	public BusController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<BusBean> view(){
		List<BusBean> list = new ArrayList<BusBean>();
		List<BusBean> listAll = dao.getAll();
		for(int i = 0; i < listAll.size(); i++){
			list.add(listAll.get(i));
		}

		return list;
	}
	
	public int Insert(BusBean bean){
		int result = 0;
		
		result = dao.Insert(bean);

		return result;
	}
	
	public BusBean search(String ID) {
		BusBean bean = new BusBean();
		
		bean  = dao.search(ID);
		
		return bean;
	}
	
	public int Update(BusBean bean){
		int result = 0;
		
		result = dao.Update(bean);
		
		return result;
	}
}
