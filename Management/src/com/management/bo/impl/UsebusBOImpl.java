package com.management.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.bean.Usebus;
import com.management.bo.UsebusBO;
import com.management.dao.impl.UsebusDAOImpl;

public class UsebusBOImpl implements UsebusBO {
	
	UsebusDAOImpl dao = new UsebusDAOImpl();

	@Override
	public List<Usebus> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<Usebus> list = new ArrayList<Usebus>();
		List<Usebus> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new Usebus(l.get(i).getBusNumber(),
					l.get(i).getCustomerNumber()));
		}
		return list;
	}

	@Override
	public Usebus getById(String id) throws Exception {
		// TODO Auto-generated method stub
		List<Usebus> list = dao.getAll();
		Usebus usebus = new Usebus();
		for(Usebus u: list){
			if(u.getCustomerNumber().toString().compareTo(id) == 0){
				usebus = u;
			}
		}
		return usebus;
	}

	@Override
	public int addNew(Usebus entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.addNew(entity);
		return result;
	}

	@Override
	public int update(Usebus entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.update(entity);
		return result;
	}

	@Override
	public int delete(Usebus entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.delete(entity);
		return result;
	}
}
