package com.haoxuer.b2bcloud.customer.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerLevelDao;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerLevel;

/**
* Created by imake on 2020年05月07日11:15:21.
*/
@Repository

public class CustomerLevelDaoImpl extends CriteriaDaoImpl<CustomerLevel, Long> implements CustomerLevelDao {

	@Override
	public CustomerLevel findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public CustomerLevel save(CustomerLevel bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public CustomerLevel deleteById(Long id) {
		CustomerLevel entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<CustomerLevel> getEntityClass() {
		return CustomerLevel.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public CustomerLevel findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public CustomerLevel deleteById(Long tenant,Long id) {
		CustomerLevel entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}