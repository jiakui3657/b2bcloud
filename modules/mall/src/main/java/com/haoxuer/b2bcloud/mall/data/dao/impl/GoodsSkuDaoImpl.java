package com.haoxuer.b2bcloud.mall.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.mall.data.dao.GoodsSkuDao;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsSku;

/**
* Created by imake on 2020年01月17日14:08:58.
*/
@Repository

public class GoodsSkuDaoImpl extends CriteriaDaoImpl<GoodsSku, Long> implements GoodsSkuDao {

	@Override
	public GoodsSku findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public GoodsSku save(GoodsSku bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public GoodsSku deleteById(Long id) {
		GoodsSku entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<GoodsSku> getEntityClass() {
		return GoodsSku.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}