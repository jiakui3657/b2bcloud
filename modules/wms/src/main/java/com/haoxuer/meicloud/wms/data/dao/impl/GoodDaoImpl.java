package com.haoxuer.meicloud.wms.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.meicloud.wms.data.dao.GoodDao;
import com.haoxuer.meicloud.wms.data.entity.Good;

/**
* Created by imake on 2019年11月20日12:11:02.
*/
@Repository

public class GoodDaoImpl extends CriteriaDaoImpl<Good, Long> implements GoodDao {

	@Override
	public Good findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Good save(Good bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Good deleteById(Long id) {
		Good entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Good> getEntityClass() {
		return Good.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}