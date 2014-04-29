package com.project.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.project.bean.Kind;
import com.project.controller.KindController;

public class KindAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<Kind> listKind = new ArrayList<Kind>();
	List<Kind> list = new ArrayList<Kind>();
	
	KindController connK = new KindController() ;
	
	Kind kind = new Kind();
	
	int kindID;
	int pageUp = 0, pageDown = 0;
	int pageIndex = 1;
	int totalPage = connK.getAll().size() / 10 + 1;

	public String list(){
		list = connK.getAll();
		int index = 0;
		if(pageIndex < totalPage) {
			index = pageIndex * 10;
		} else {
			index = list.size();
		}
		for(int i = (pageIndex - 1) * 10; i < index; i++) {
			listKind.add(list.get(i));				
		}
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
		listKind = connK.getAll();
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
