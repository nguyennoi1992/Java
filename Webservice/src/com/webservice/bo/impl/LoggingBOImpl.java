package com.webservice.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.bo.LoggingBO;
import com.webservice.bean.Logging;
import com.webservice.dao.impl.LoggingDAOImpl;

public class LoggingBOImpl implements LoggingBO{
	
	LoggingDAOImpl dao = new LoggingDAOImpl();

	@Override
	public List<Logging> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<Logging> list = new ArrayList<Logging>();
		List<Logging> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new Logging(l.get(i).getLogNumber(),
					l.get(i).getUserNumber(),
					l.get(i).getCustomerNumber(),
					l.get(i).getDate(),
					l.get(i).getAction()));
		}
		return list;
	}


	@Override
	public Logging getById(int id) throws Exception {
		// TODO Auto-generated method stub
		List<Logging> list = dao.getAll();
		Logging Lock = new Logging();
		for(Logging p: list){
			if(p.getLogNumber() == id){
				Lock = p;
			}
		}
		return Lock;
	}

	@Override
	public int addNew(Logging entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.addNew(entity);
		return result;
	}

	@Override
	public int update(Logging entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.update(entity);
		return result;
	}

	@Override
	public int delete(Logging entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.delete(entity);
		return result;
	}
}
