package com.project.dao;

import java.util.List;

public interface KindDAO <KindBean>{
	public List<KindBean> getAll() throws Exception;
    public KindBean getById(int id) throws Exception;
    public void addNew(KindBean entity) throws Exception;
    public void update(KindBean entity) throws Exception;
    public void delete(KindBean entity) throws Exception;
}
