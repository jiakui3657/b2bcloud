package com.haoxuer.b2bcloud.order.data.dao.impl;

import com.haoxuer.discover.data.core.Finder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.order.data.dao.OrderDataDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderData;

import java.math.BigDecimal;
import java.util.List;

/**
* Created by imake on 2020年05月08日10:28:40.
*/
@Repository

public class OrderDataDaoImpl extends CriteriaDaoImpl<OrderData, Long> implements OrderDataDao {

	@Override
	public OrderData findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public OrderData save(OrderData bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public OrderData deleteById(Long id) {
		OrderData entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	@Override
	public BigDecimal sum(List<Filter> filters) {
		Finder finder = makeSumFinder(filters);
		List<Object> ls = find(finder);
		if (ls != null && ls.size() > 0) {
			Object object = ls.get(0);
			if (object instanceof BigDecimal) {
				return (BigDecimal) object;
			}
		}
		return new BigDecimal(0);
	}

	protected Finder makeSumFinder(List<Filter> filters) {
		Finder finder = Finder.create();
		finder.append("select sum(model.payAmount)  from " + getEntityClass().getSimpleName());
		if (filters == null || filters.isEmpty()) {
			finder.append(" model ");
		} else {
			finder.append(" model where ");
		}
		makerFilter(filters, finder);

		return finder;
	}
	@Override
	protected Class<OrderData> getEntityClass() {
		return OrderData.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public OrderData findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public OrderData deleteById(Long tenant,Long id) {
		OrderData entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}