package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.project.bean.KindBean;
import com.project.dao.KindDAO;

public class KindController {

	KindDAO dao = new KindDAO();
	
	public KindController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<KindBean> view(){
		List<KindBean> list = new ArrayList<KindBean>();
		List<KindBean> listAll = dao.getAll();
		for(int i = 0; i < listAll.size(); i++){
			list.add(listAll.get(i));
		}
		
		return list;
	}
	
	public int Insert(KindBean bean){
		int result = 0;
		
		result = dao.Insert(bean);

		return result;
	} 
	
	public KindBean search(int ID) {
		KindBean bean = new KindBean();
		
		bean  = dao.search(ID);
		
		return bean;
	}
	
	
	public int Update(KindBean bean){
		int result = 0;
		
		result = dao.Update(bean);
		
		return result;
	}
}
