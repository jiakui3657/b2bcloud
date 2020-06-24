package com.haoxuer.b2bcloud.common.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.common.data.dao.IndustryDao;
import com.haoxuer.b2bcloud.common.data.entity.Industry;
import com.haoxuer.discover.data.core.CatalogDaoImpl;

/**
* Created by imake on 2020年05月07日14:03:56.
*/
@Repository

public class IndustryDaoImpl extends CatalogDaoImpl<Industry, Integer> implements IndustryDao {

	@Override
	public Industry findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Industry save(Industry bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public Industry deleteById(Integer id) {
		Industry entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Industry> getEntityClass() {
		return Industry.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public Industry findById(Long tenant,Integer id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public Industry deleteById(Long tenant,Integer id) {
		Industry entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}