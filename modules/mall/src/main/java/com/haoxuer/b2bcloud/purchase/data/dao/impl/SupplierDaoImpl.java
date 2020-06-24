package com.haoxuer.b2bcloud.purchase.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.purchase.data.dao.SupplierDao;
import com.haoxuer.b2bcloud.purchase.data.entity.Supplier;

/**
* Created by imake on 2020年05月12日19:55:07.
*/
@Repository

public class SupplierDaoImpl extends CriteriaDaoImpl<Supplier, Long> implements SupplierDao {

	@Override
	public Supplier findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Supplier save(Supplier bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Supplier deleteById(Long id) {
		Supplier entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Supplier> getEntityClass() {
		return Supplier.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public Supplier findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public Supplier deleteById(Long tenant,Long id) {
		Supplier entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}