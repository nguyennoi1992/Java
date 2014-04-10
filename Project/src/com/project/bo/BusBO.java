package com.project.bo;

import java.util.List;

import com.project.bean.BusBean;

public interface BusBO {
	public List<BusBean> getAll() throws Exception;
    public BusBean getById(int id) throws Exception;
    public void addNew(BusBean entity) throws Exception;
    public void update(BusBean entity) throws Exception;
    public void delete(BusBean entity) throws Exception;
}
