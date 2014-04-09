package com.project.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.KindBean;
import com.project.controller.KindController;

public class KindAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<KindBean> listKind = new ArrayList<KindBean>();
	
	KindController connK = new KindController() ;
	
	KindBean kind = new KindBean();
	
	int kindID;

	public String list(){

		listKind = connK.view();
		return "list";
	}
	
	public String add(){
		return "add";
	}
	
	public String create(){
		connK.Insert(kind);
		return list();
	}
	
	public String details(){
		kind = connK.search(kindID);
		return "details";
	}
	
	public String update(){
		connK.Update(kind);
		listKind = connK.view();
		return "update";
	}

	public List<KindBean> getListKind() {
		return listKind;
	}

	public void setListKind(List<KindBean> listKind) {
		this.listKind = listKind;
	}

	public KindBean getKind() {
		return kind;
	}

	public void setKind(KindBean kind) {
		this.kind = kind;
	}

	public int getKindID() {
		return kindID;
	}

	public void setKindID(int kindID) {
		this.kindID = kindID;
	}
	
	

}
