package com.management.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.bean.Bus;
import com.management.bo.BusBO;
import com.management.dao.impl.BusDAOImpl;

public class BusBOImpl  implements BusBO{
	BusDAOImpl dao = new BusDAOImpl();

	public BusDAOImpl getDao() {
		return dao;
	}
	public void setDao(BusDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Bus> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<Bus> list = new ArrayList<Bus>();
		List<Bus> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new Bus(l.get(i).getBusNumber(),
					l.get(i).getDetails(),
					l.get(i).getCost()));
		}
		return list;
	}

	@Override
	public Bus getById(String id) throws Exception {
		// TODO Auto-generated method stub
		List<Bus> list = dao.getAll();
		Bus bus = new Bus();
		for(Bus b: list){
			if(b.getBusNumber().toString().compareTo(id) == 0){
				bus = b;
			}
		}
		return bus;
	}

	@Override
	public int addNew(Bus entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.addNew(entity);
		return result;
	}

	@Override
	public int update(Bus entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.update(entity);
		return result;
	}

	@Override
	public int delete(Bus entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.delete(entity);
		return result;
	}
}
