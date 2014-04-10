package com.project.bo;

import java.util.List;

import com.project.bean.KindBean;


public interface KindBO {
	public List<KindBean> getAll() throws Exception;
    public KindBean getById(int id) throws Exception;
    public void addNew(KindBean entity) throws Exception;
    public void update(KindBean entity) throws Exception;
    public void delete(KindBean entity) throws Exception;
}
