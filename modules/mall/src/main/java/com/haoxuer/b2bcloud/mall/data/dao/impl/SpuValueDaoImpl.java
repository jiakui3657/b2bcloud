package com.haoxuer.b2bcloud.mall.data.dao.impl;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.mall.data.dao.SpuValueDao;
import com.haoxuer.b2bcloud.mall.data.entity.SpuValue;

import java.util.List;

/**
* Created by imake on 2019年12月29日13:42:35.
*/
@Repository

public class SpuValueDaoImpl extends CriteriaDaoImpl<SpuValue, Long> implements SpuValueDao {

	@Override
	public SpuValue findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public SpuValue save(SpuValue bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public SpuValue deleteById(Long id) {
		SpuValue entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	public List<SpuValue> findlist(int first, Integer size, List<Filter> filters, List<Order> orders) {
		return findList(first,size,filters,orders);
	}

	@Override
	protected Class<SpuValue> getEntityClass() {
		return SpuValue.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}