package com.webservice.dao;

import java.util.List;

public interface BusDAO <Bus>{
	public List<Bus> getAll() throws Exception;
	public int addNew(Bus entity) throws Exception;
	public int update(Bus entity) throws Exception;
	public int delete(Bus entity) throws Exception;
}
