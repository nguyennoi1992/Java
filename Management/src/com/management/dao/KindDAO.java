package com.management.dao;

import java.util.List;

public interface KindDAO <Kind>{
	public List<Kind> getAll() throws Exception;
	public int addNew(Kind entity) throws Exception;
	public int update(Kind entity) throws Exception;
	public int delete(Kind entity) throws Exception;
}
