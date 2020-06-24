package com.haoxuer.b2bcloud.order.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.order.data.dao.OrderTallyItemDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderTallyItem;

/**
* Created by imake on 2020年06月04日16:13:57.
*/
@Repository

public class OrderTallyItemDaoImpl extends CriteriaDaoImpl<OrderTallyItem, Long> implements OrderTallyItemDao {

	@Override
	public OrderTallyItem findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public OrderTallyItem save(OrderTallyItem bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public OrderTallyItem deleteById(Long id) {
		OrderTallyItem entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<OrderTallyItem> getEntityClass() {
		return OrderTallyItem.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public OrderTallyItem findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public OrderTallyItem deleteById(Long tenant,Long id) {
		OrderTallyItem entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}