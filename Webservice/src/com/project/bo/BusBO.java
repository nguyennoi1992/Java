package com.project.bo;

import java.util.List;

import com.webservice.bean.Bus;

public interface BusBO {
	public List<Bus> getAll() throws Exception;
	public Bus getById(String id) throws Exception;
	public int addNew(Bus entity) throws Exception;
	public int update(Bus entity) throws Exception;
	public int delete(Bus entity) throws Exception;
}
