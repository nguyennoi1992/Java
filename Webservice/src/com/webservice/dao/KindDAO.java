package com.webservice.dao;

import java.util.List;

public interface KindDAO <Kind>{
	public List<Kind> getAll() throws Exception;
	public Kind getById(int id) throws Exception;
	public void addNew(Kind entity) throws Exception;
	public void update(Kind entity) throws Exception;
	public void delete(Kind entity) throws Exception;
}
