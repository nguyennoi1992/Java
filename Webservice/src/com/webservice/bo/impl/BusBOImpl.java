package com.webservice.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.bo.BusBO;
import com.webservice.dao.impl.BusDAOImpl;
import com.webservice.model.Bus;

public class BusBOImpl  implements BusBO{
	BusDAOImpl dao = new BusDAOImpl();

	public BusDAOImpl getDao() {
		return dao;
	}
	public void setDao(BusDAOImpl dao) {
		this.dao = dao;
	}

	public List<Bus> getAll() throws Exception {
		List<Bus> list = new ArrayList<Bus>();
		List<Bus> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new Bus(l.get(i).getBusNumber(),
					l.get(i).getDetails(),
					l.get(i).getCost()));
		}
		return list;
	}

	public Bus getById(String id) throws Exception {
		Bus u = new Bus();
		u = dao.getById(id);
		return u;
	}

	public void addNew(Bus entity) throws Exception {
		dao.addNew(entity);
	}

	public void update(Bus entity) throws Exception {
		try {
			dao.update(entity);
		} catch (Exception ex) {
			throw new Exception("Display error: " + ex.getMessage());
		}
	}

	public void delete(Bus entity) throws Exception {
		dao.delete(entity);
	}
}
