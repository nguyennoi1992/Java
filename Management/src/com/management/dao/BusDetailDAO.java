package com.management.dao;

import java.util.List;

public interface BusDetailDAO  <BusDetail>{
	public List<BusDetail> getAll() throws Exception;
	public int addNew(BusDetail entity) throws Exception;
	public int update(BusDetail entity) throws Exception;
	public int delete(BusDetail entity) throws Exception;
}