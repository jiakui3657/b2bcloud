package com.haoxuer.b2bcloud.promote.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.promote.data.dao.PromoteDao;
import com.haoxuer.b2bcloud.promote.data.entity.Promote;

/**
* Created by imake on 2020年05月11日14:18:16.
*/
@Repository

public class PromoteDaoImpl extends CriteriaDaoImpl<Promote, Long> implements PromoteDao {

	@Override
	public Promote findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Promote save(Promote bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Promote deleteById(Long id) {
		Promote entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Promote> getEntityClass() {
		return Promote.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public Promote findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public Promote deleteById(Long tenant,Long id) {
		Promote entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}