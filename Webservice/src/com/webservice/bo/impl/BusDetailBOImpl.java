package com.webservice.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.bo.BusDetailBO;
import com.webservice.bean.BusDetail;
import com.webservice.dao.impl.BusDetailDAOImpl;

public class BusDetailBOImpl implements BusDetailBO{
	BusDetailDAOImpl dao = new BusDetailDAOImpl();


	public BusDetailDAOImpl getDao() {
		return dao;
	}
	public void setDao(BusDetailDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<BusDetail> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<BusDetail> list = new ArrayList<BusDetail>();
		List<BusDetail> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new BusDetail(l.get(i).getNumberPlate(),
					l.get(i).getEmployeeNumber(),
					l.get(i).getBusNumber()));
		}
		return list;
	}

	@Override
	public BusDetail getById(String id) throws Exception {
		// TODO Auto-generated method stub
		List<BusDetail> list = dao.getAll();
		BusDetail BusDetail = new BusDetail();
		for(BusDetail p: list){
			if(p.getNumberPlate().compareTo(id) == 0){
				BusDetail = p;
			}
		}
		return BusDetail;
	}

	@Override
	public int addNew(BusDetail entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.addNew(entity);
		return result;
	}

	@Override
	public int update(BusDetail entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.update(entity);
		return result;
	}

	@Override
	public int delete(BusDetail entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.delete(entity);
		return result;
	}
}
