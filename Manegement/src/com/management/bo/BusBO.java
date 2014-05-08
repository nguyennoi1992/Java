package com.management.bo;

import java.util.List;

import com.management.model.Bus;

public interface BusBO {
	public List<Bus> getAll() throws Exception;
	public Bus getById(String id) throws Exception;
	public void addNew(Bus entity) throws Exception;
	public void update(Bus entity) throws Exception;
	public void delete(Bus entity) throws Exception;
}
