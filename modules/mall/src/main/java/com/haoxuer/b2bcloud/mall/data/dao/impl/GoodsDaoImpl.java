package com.haoxuer.b2bcloud.mall.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.mall.data.dao.GoodsDao;
import com.haoxuer.b2bcloud.mall.data.entity.Goods;

/**
* Created by imake on 2019年12月29日13:46:48.
*/
@Repository

public class GoodsDaoImpl extends CriteriaDaoImpl<Goods, Long> implements GoodsDao {

	@Override
	public Goods findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Goods save(Goods bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Goods deleteById(Long id) {
		Goods entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Goods> getEntityClass() {
		return Goods.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}