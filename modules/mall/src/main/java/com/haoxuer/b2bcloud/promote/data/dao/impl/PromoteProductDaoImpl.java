package com.haoxuer.b2bcloud.promote.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.promote.data.dao.PromoteProductDao;
import com.haoxuer.b2bcloud.promote.data.entity.PromoteProduct;

/**
* Created by imake on 2020年05月11日14:14:40.
*/
@Repository

public class PromoteProductDaoImpl extends CriteriaDaoImpl<PromoteProduct, Long> implements PromoteProductDao {

	@Override
	public PromoteProduct findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public PromoteProduct save(PromoteProduct bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public PromoteProduct deleteById(Long id) {
		PromoteProduct entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<PromoteProduct> getEntityClass() {
		return PromoteProduct.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public PromoteProduct findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public PromoteProduct deleteById(Long tenant,Long id) {
		PromoteProduct entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}