package com.haoxuer.b2bcloud.mall.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.mall.data.dao.GoodsCatalogDao;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsCatalog;
import com.haoxuer.discover.data.core.CatalogDaoImpl;

/**
* Created by imake on 2019年12月29日13:42:18.
*/
@Repository

public class GoodsCatalogDaoImpl extends CatalogDaoImpl<GoodsCatalog, Integer> implements GoodsCatalogDao {

	@Override
	public GoodsCatalog findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public GoodsCatalog save(GoodsCatalog bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public GoodsCatalog deleteById(Integer id) {
		GoodsCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<GoodsCatalog> getEntityClass() {
		return GoodsCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}