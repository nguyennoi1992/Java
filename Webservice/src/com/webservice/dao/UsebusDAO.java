package com.webservice.dao;

import java.util.List;

public interface UsebusDAO <Usebus> {
	public List<Usebus> getAll() throws Exception;
	public int addNew(Usebus entity) throws Exception;
	public int update(Usebus entity) throws Exception;
	public int delete(Usebus entity) throws Exception;
}
