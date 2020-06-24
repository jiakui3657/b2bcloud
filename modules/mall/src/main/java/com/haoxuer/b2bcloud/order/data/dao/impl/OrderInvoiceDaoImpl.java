package com.haoxuer.b2bcloud.order.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.order.data.dao.OrderInvoiceDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderInvoice;

/**
* Created by imake on 2020年05月07日11:11:37.
*/
@Repository

public class OrderInvoiceDaoImpl extends CriteriaDaoImpl<OrderInvoice, Long> implements OrderInvoiceDao {

	@Override
	public OrderInvoice findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public OrderInvoice save(OrderInvoice bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public OrderInvoice deleteById(Long id) {
		OrderInvoice entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<OrderInvoice> getEntityClass() {
		return OrderInvoice.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public OrderInvoice findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public OrderInvoice deleteById(Long tenant,Long id) {
		OrderInvoice entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}