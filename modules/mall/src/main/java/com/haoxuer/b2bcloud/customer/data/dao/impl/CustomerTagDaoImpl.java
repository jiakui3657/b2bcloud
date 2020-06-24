package com.haoxuer.b2bcloud.customer.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerTagDao;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerTag;

/**
* Created by imake on 2020年05月09日15:47:39.
*/
@Repository

public class CustomerTagDaoImpl extends CriteriaDaoImpl<CustomerTag, Long> implements CustomerTagDao {

	@Override
	public CustomerTag findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public CustomerTag save(CustomerTag bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public CustomerTag deleteById(Long id) {
		CustomerTag entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<CustomerTag> getEntityClass() {
		return CustomerTag.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public CustomerTag findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public CustomerTag deleteById(Long tenant,Long id) {
		CustomerTag entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}