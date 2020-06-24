package com.haoxuer.b2bcloud.store.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.store.data.dao.StoreDao;
import com.haoxuer.b2bcloud.store.data.entity.Store;

/**
* Created by imake on 2020年05月02日15:43:56.
*/
@Repository

public class StoreDaoImpl extends CriteriaDaoImpl<Store, Long> implements StoreDao {

	@Override
	public Store findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Store save(Store bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Store deleteById(Long id) {
		Store entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Store> getEntityClass() {
		return Store.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public Store findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public Store deleteById(Long tenant,Long id) {
		Store entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}