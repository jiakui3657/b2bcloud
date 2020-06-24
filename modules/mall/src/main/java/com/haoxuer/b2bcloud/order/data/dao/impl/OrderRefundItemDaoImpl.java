package com.haoxuer.b2bcloud.order.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.order.data.dao.OrderRefundItemDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderRefundItem;

/**
* Created by imake on 2020年06月18日10:29:26.
*/
@Repository

public class OrderRefundItemDaoImpl extends CriteriaDaoImpl<OrderRefundItem, Long> implements OrderRefundItemDao {

	@Override
	public OrderRefundItem findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public OrderRefundItem save(OrderRefundItem bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public OrderRefundItem deleteById(Long id) {
		OrderRefundItem entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<OrderRefundItem> getEntityClass() {
		return OrderRefundItem.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public OrderRefundItem findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public OrderRefundItem deleteById(Long tenant,Long id) {
		OrderRefundItem entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}