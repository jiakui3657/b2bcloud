package com.haoxuer.b2bcloud.order.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.order.data.dao.OrderTradeDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderTrade;

/**
* Created by imake on 2020年05月18日19:57:06.
*/
@Repository

public class OrderTradeDaoImpl extends CriteriaDaoImpl<OrderTrade, Long> implements OrderTradeDao {

	@Override
	public OrderTrade findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public OrderTrade save(OrderTrade bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public OrderTrade deleteById(Long id) {
		OrderTrade entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<OrderTrade> getEntityClass() {
		return OrderTrade.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public OrderTrade findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public OrderTrade deleteById(Long tenant,Long id) {
		OrderTrade entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}