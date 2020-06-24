package com.haoxuer.b2bcloud.mall.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.mall.data.dao.SpuNameDao;
import com.haoxuer.b2bcloud.mall.data.entity.SpuName;

/**
* Created by imake on 2019年12月31日15:41:42.
*/
@Repository

public class SpuNameDaoImpl extends CriteriaDaoImpl<SpuName, Long> implements SpuNameDao {

	@Override
	public SpuName findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public SpuName save(SpuName bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public SpuName deleteById(Long id) {
		SpuName entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<SpuName> getEntityClass() {
		return SpuName.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}