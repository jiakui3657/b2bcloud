package com.haoxuer.b2bcloud.order.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.order.data.dao.OrderExchangeDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderExchange;

/**
* Created by imake on 2020年05月12日18:42:45.
*/
@Repository

public class OrderExchangeDaoImpl extends CriteriaDaoImpl<OrderExchange, Long> implements OrderExchangeDao {

	@Override
	public OrderExchange findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public OrderExchange save(OrderExchange bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public OrderExchange deleteById(Long id) {
		OrderExchange entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<OrderExchange> getEntityClass() {
		return OrderExchange.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public OrderExchange findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public OrderExchange deleteById(Long tenant,Long id) {
		OrderExchange entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}