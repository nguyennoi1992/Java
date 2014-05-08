package com.project.bo;

import java.util.List;

import com.webservice.model.Kind;

public interface KindBO {
	public List<Kind> getAll() throws Exception;
	public Kind getById(int id) throws Exception;
	public void addNew(Kind entity) throws Exception;
	public void update(Kind entity) throws Exception;
	public void delete(Kind entity) throws Exception;

}