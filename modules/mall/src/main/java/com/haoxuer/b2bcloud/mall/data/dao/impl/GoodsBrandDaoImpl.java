package com.haoxuer.b2bcloud.mall.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.mall.data.dao.GoodsBrandDao;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsBrand;

/**
* Created by imake on 2019年12月29日14:17:43.
*/
@Repository

public class GoodsBrandDaoImpl extends CriteriaDaoImpl<GoodsBrand, Long> implements GoodsBrandDao {

	@Override
	public GoodsBrand findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public GoodsBrand save(GoodsBrand bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public GoodsBrand deleteById(Long id) {
		GoodsBrand entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<GoodsBrand> getEntityClass() {
		return GoodsBrand.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}