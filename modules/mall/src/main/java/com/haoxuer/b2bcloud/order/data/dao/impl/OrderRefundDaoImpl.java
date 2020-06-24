package com.haoxuer.b2bcloud.order.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.order.data.dao.OrderRefundDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderRefund;

/**
* Created by imake on 2020年05月09日23:00:47.
*/
@Repository

public class OrderRefundDaoImpl extends CriteriaDaoImpl<OrderRefund, Long> implements OrderRefundDao {

	@Override
	public OrderRefund findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public OrderRefund save(OrderRefund bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public OrderRefund deleteById(Long id) {
		OrderRefund entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<OrderRefund> getEntityClass() {
		return OrderRefund.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public OrderRefund findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public OrderRefund deleteById(Long tenant,Long id) {
		OrderRefund entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}