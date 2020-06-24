package com.haoxuer.b2bcloud.mall.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.mall.data.dao.GoodsSpuDao;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsSpu;

/**
* Created by imake on 2019年12月29日13:42:02.
*/
@Repository

public class GoodsSpuDaoImpl extends CriteriaDaoImpl<GoodsSpu, Long> implements GoodsSpuDao {

	@Override
	public GoodsSpu findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public GoodsSpu save(GoodsSpu bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public GoodsSpu deleteById(Long id) {
		GoodsSpu entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<GoodsSpu> getEntityClass() {
		return GoodsSpu.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}