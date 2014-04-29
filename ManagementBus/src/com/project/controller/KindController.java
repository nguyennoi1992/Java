package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.project.bean.Kind;
import com.project.dao.KindDAO;

public class KindController {

	KindDAO dao = new KindDAO();
	
	public KindController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Kind> getAll(){
		List<Kind> list = new ArrayList<Kind>();
		List<Kind> listAll = dao.getAll();
		for(int i = 0; i < listAll.size(); i++){
			list.add(listAll.get(i));
		}
		
		return list;
	}
	
	public int Insert(Kind bean){
		int result = 0;
		
		result = dao.Insert(bean);

		return result;
	} 
	
	public Kind search(int ID) {
		Kind bean = new Kind();
		
		bean  = dao.search(ID);
		
		return bean;
	}
	
	
	public int Update(Kind bean){
		int result = 0;
		
		result = dao.Update(bean);
		
		return result;
	}
}
