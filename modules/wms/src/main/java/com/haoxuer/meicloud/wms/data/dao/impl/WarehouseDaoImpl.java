package com.haoxuer.meicloud.wms.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.meicloud.wms.data.dao.WarehouseDao;
import com.haoxuer.meicloud.wms.data.entity.Warehouse;

/**
* Created by imake on 2019年11月20日17:50:41.
*/
@Repository

public class WarehouseDaoImpl extends CriteriaDaoImpl<Warehouse, Long> implements WarehouseDao {

	@Override
	public Warehouse findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Warehouse save(Warehouse bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Warehouse deleteById(Long id) {
		Warehouse entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Warehouse> getEntityClass() {
		return Warehouse.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}