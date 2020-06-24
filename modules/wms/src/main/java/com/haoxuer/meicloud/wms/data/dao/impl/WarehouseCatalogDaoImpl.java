package com.haoxuer.meicloud.wms.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.meicloud.wms.data.dao.WarehouseCatalogDao;
import com.haoxuer.meicloud.wms.data.entity.WarehouseCatalog;
import com.haoxuer.discover.data.core.CatalogDaoImpl;

/**
* Created by imake on 2019年11月20日17:46:43.
*/
@Repository

public class WarehouseCatalogDaoImpl extends CatalogDaoImpl<WarehouseCatalog, Integer> implements WarehouseCatalogDao {

	@Override
	public WarehouseCatalog findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public WarehouseCatalog save(WarehouseCatalog bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public WarehouseCatalog deleteById(Integer id) {
		WarehouseCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<WarehouseCatalog> getEntityClass() {
		return WarehouseCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}