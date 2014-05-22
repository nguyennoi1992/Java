package com.webservice.dao;

import java.util.List;

public interface LoggingDAO <Lock>{
	public List<Lock> getAll() throws Exception;
	public int addNew(Lock entity) throws Exception;
	public int update(Lock entity) throws Exception;
	public int delete(Lock entity) throws Exception;
}
