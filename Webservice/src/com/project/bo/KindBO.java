package com.project.bo;

import java.util.List;

import com.webservice.bean.Kind;

public interface KindBO {
	public List<Kind> getAll() throws Exception;
	public Kind getById(int id) throws Exception;
	public int addNew(Kind entity) throws Exception;
	public int update(Kind entity) throws Exception;
	public int delete(Kind entity) throws Exception;

}