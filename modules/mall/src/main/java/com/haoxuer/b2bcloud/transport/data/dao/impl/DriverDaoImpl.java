package com.haoxuer.b2bcloud.transport.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.transport.data.dao.DriverDao;
import com.haoxuer.b2bcloud.transport.data.entity.Driver;

/**
* Created by imake on 2020年03月21日16:54:58.
*/
@Repository

public class DriverDaoImpl extends CriteriaDaoImpl<Driver, Long> implements DriverDao {

	@Override
	public Driver findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Driver save(Driver bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Driver deleteById(Long id) {
		Driver entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Driver> getEntityClass() {
		return Driver.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}