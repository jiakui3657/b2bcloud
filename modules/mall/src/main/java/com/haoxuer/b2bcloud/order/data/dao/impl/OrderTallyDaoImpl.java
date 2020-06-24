package com.haoxuer.b2bcloud.order.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.order.data.dao.OrderTallyDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderTally;

/**
* Created by imake on 2020年06月04日16:56:41.
*/
@Repository

public class OrderTallyDaoImpl extends CriteriaDaoImpl<OrderTally, Long> implements OrderTallyDao {

	@Override
	public OrderTally findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public OrderTally save(OrderTally bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public OrderTally deleteById(Long id) {
		OrderTally entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<OrderTally> getEntityClass() {
		return OrderTally.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public OrderTally findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public OrderTally deleteById(Long tenant,Long id) {
		OrderTally entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}