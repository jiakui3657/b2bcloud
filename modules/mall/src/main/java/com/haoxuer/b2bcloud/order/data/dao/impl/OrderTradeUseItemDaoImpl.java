package com.haoxuer.b2bcloud.order.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.order.data.dao.OrderTradeUseItemDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderTradeUseItem;

/**
* Created by imake on 2020年05月19日18:20:02.
*/
@Repository

public class OrderTradeUseItemDaoImpl extends CriteriaDaoImpl<OrderTradeUseItem, Long> implements OrderTradeUseItemDao {

	@Override
	public OrderTradeUseItem findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public OrderTradeUseItem save(OrderTradeUseItem bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public OrderTradeUseItem deleteById(Long id) {
		OrderTradeUseItem entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<OrderTradeUseItem> getEntityClass() {
		return OrderTradeUseItem.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public OrderTradeUseItem findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public OrderTradeUseItem deleteById(Long tenant,Long id) {
		OrderTradeUseItem entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}