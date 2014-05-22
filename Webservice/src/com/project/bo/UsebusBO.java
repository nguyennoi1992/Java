package com.project.bo;

import java.util.List;

import com.webservice.bean.Usebus;

public interface UsebusBO {
	public List<Usebus> getAll() throws Exception;
	public Usebus getById(String id) throws Exception;
	public int addNew(Usebus entity) throws Exception;
	public int update(Usebus entity) throws Exception;
	public int delete(Usebus entity) throws Exception;
}
