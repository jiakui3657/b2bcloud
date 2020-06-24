package com.haoxuer.b2bcloud.order.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.order.data.dao.OrderTradeItemDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderTradeItem;

/**
* Created by imake on 2020年05月19日18:20:02.
*/
@Repository

public class OrderTradeItemDaoImpl extends CriteriaDaoImpl<OrderTradeItem, Long> implements OrderTradeItemDao {

	@Override
	public OrderTradeItem findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public OrderTradeItem save(OrderTradeItem bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public OrderTradeItem deleteById(Long id) {
		OrderTradeItem entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<OrderTradeItem> getEntityClass() {
		return OrderTradeItem.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public OrderTradeItem findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public OrderTradeItem deleteById(Long tenant,Long id) {
		OrderTradeItem entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}