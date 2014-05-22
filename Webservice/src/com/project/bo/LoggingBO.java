package com.project.bo;

import java.util.List;

import com.webservice.bean.Logging;

public interface LoggingBO{
	public List<Logging> getAll() throws Exception;
	public Logging getById(int id) throws Exception;
	public int addNew(Logging entity) throws Exception;
	public int update(Logging entity) throws Exception;
	public int delete(Logging entity) throws Exception;
}
