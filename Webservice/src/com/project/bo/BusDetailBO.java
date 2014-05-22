package com.project.bo;

import java.util.List;

import com.webservice.bean.BusDetail;

public interface BusDetailBO {
	public List<BusDetail> getAll() throws Exception;
	public BusDetail getById(String id) throws Exception;
	public int addNew(BusDetail entity) throws Exception;
	public int update(BusDetail entity) throws Exception;
	public int delete(BusDetail entity) throws Exception;
}
