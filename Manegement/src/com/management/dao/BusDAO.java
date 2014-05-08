package com.management.dao;

import java.util.List;

public interface BusDAO <Bus>{
	public List<Bus> getAll() throws Exception;
	public Bus getById(String id) throws Exception;
	public void addNew(Bus entity) throws Exception;
	public void update(Bus entity) throws Exception;
	public void delete(Bus entity) throws Exception;
}
