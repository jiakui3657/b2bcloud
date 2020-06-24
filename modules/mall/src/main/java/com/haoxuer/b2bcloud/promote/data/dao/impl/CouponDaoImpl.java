package com.haoxuer.b2bcloud.promote.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.promote.data.dao.CouponDao;
import com.haoxuer.b2bcloud.promote.data.entity.Coupon;

/**
* Created by imake on 2020年05月06日21:50:05.
*/
@Repository

public class CouponDaoImpl extends CriteriaDaoImpl<Coupon, Long> implements CouponDao {

	@Override
	public Coupon findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Coupon save(Coupon bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Coupon deleteById(Long id) {
		Coupon entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Coupon> getEntityClass() {
		return Coupon.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public Coupon findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public Coupon deleteById(Long tenant,Long id) {
		Coupon entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}