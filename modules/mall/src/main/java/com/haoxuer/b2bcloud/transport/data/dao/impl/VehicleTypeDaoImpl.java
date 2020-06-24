package com.haoxuer.b2bcloud.transport.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.transport.data.dao.VehicleTypeDao;
import com.haoxuer.b2bcloud.transport.data.entity.VehicleType;

/**
* Created by imake on 2020年03月21日16:54:10.
*/
@Repository

public class VehicleTypeDaoImpl extends CriteriaDaoImpl<VehicleType, Long> implements VehicleTypeDao {

	@Override
	public VehicleType findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public VehicleType save(VehicleType bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public VehicleType deleteById(Long id) {
		VehicleType entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<VehicleType> getEntityClass() {
		return VehicleType.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}