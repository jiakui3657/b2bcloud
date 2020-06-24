package com.haoxuer.b2bcloud.customer.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.customer.data.dao.ShopperDao;
import com.haoxuer.b2bcloud.customer.data.entity.Shopper;

/**
* Created by imake on 2020年03月30日16:06:23.
*/
@Repository

public class ShopperDaoImpl extends CriteriaDaoImpl<Shopper, Long> implements ShopperDao {

	@Override
	public Shopper findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Shopper save(Shopper bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Shopper deleteById(Long id) {
		Shopper entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Shopper> getEntityClass() {
		return Shopper.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}