package com.project.dao;

import java.util.List;

public interface BusDAO <BusBean>{
	public List<BusBean> getAll() throws Exception;
    public BusBean getById(int id) throws Exception;
    public void addNew(BusBean entity) throws Exception;
    public void update(BusBean entity) throws Exception;
    public void delete(BusBean entity) throws Exception;
}
