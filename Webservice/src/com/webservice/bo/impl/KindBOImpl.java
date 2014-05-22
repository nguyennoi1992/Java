package com.webservice.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.bo.KindBO;
import com.webservice.bean.Kind;
import com.webservice.dao.impl.KindDAOImpl;

public class KindBOImpl  implements KindBO{
	KindDAOImpl dao = new KindDAOImpl();

	public KindDAOImpl getDao() {
		return dao;
	}
	public void setDao(KindDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Kind> getAll() throws Exception {
		// TODO Auto-generated method stub
		List<Kind> list = new ArrayList<Kind>();
		List<Kind> l = dao.getAll();
		for(int i = 0; i < l.size(); i++) {
			list.add(new Kind(l.get(i).getKindNumber(),
					l.get(i).getKind(),
					l.get(i).getType(),
					l.get(i).getCategory()));
		}
		return list;

	}

	@Override
	public Kind getById(int id) throws Exception {
		// TODO Auto-generated method stub
		List<Kind> list = dao.getAll();
		Kind kind = new Kind();
		for(Kind k: list){
			if(k.getKindNumber() == id){
				kind = k;
			}
		}
		return kind;
	}

	@Override
	public int addNew(Kind entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.addNew(entity);
		return result;
	}

	@Override
	public int update(Kind entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.update(entity);
		return result;
	}

	@Override
	public int delete(Kind entity) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = dao.delete(entity);
		return result;
	}
}
