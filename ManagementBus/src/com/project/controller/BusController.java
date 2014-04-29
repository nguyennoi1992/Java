package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.project.bean.Bus;
import com.project.dao.BusDAO;


public class BusController {

	BusDAO dao = new BusDAO();

	public BusController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Bus> getAll(){
		List<Bus> list = new ArrayList<Bus>();
		List<Bus> listAll = dao.getAll();
		for(int i = 0; i < listAll.size(); i++){
			list.add(listAll.get(i));
		}

		return list;
	}
	
	public int Insert(Bus bean){
		int result = 0;
		
		result = dao.Insert(bean);

		return result;
	}
	
	public Bus search(String ID) {
		Bus bean = new Bus();
		
		bean  = dao.search(ID);
		
		return bean;
	}
	
	public int Update(Bus bean){
		int result = 0;
		
		result = dao.Update(bean);
		
		return result;
	}
}
