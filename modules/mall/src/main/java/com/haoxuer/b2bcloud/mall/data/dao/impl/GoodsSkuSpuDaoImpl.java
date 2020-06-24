package com.haoxuer.b2bcloud.mall.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.mall.data.dao.GoodsSkuSpuDao;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsSkuSpu;

/**
* Created by imake on 2020年01月17日14:09:33.
*/
@Repository

public class GoodsSkuSpuDaoImpl extends CriteriaDaoImpl<GoodsSkuSpu, Long> implements GoodsSkuSpuDao {

	@Override
	public GoodsSkuSpu findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public GoodsSkuSpu save(GoodsSkuSpu bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public GoodsSkuSpu deleteById(Long id) {
		GoodsSkuSpu entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<GoodsSkuSpu> getEntityClass() {
		return GoodsSkuSpu.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}