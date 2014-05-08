package com.webservice.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.bo.KindBO;
import com.webservice.dao.impl.KindDAOImpl;
import com.webservice.model.Kind;

public class KindBOImpl  implements KindBO{
	KindDAOImpl dao = new KindDAOImpl();

	public KindDAOImpl getDao() {
		return dao;
	}
	public void setDao(KindDAOImpl dao) {
		this.dao = dao;
	}

	public List<Kind> getAll() throws Exception {
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

	public Kind getById(int id) throws Exception {
		Kind u = new Kind();
		u = dao.getById(id);
		return u;
	}

	public void addNew(Kind entity) throws Exception {
		dao.addNew(entity);
	}

	public void update(Kind entity) throws Exception {
		dao.update(entity);
	}

	public void delete(Kind entity) throws Exception {
		dao.delete(entity);
	}
}
