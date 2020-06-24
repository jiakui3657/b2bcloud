package com.haoxuer.b2bcloud.product.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.product.data.dao.ProductSpecDao;
import com.haoxuer.b2bcloud.product.data.entity.ProductSpec;

/**
* Created by imake on 2020年04月15日19:22:54.
*/
@Repository

public class ProductSpecDaoImpl extends CriteriaDaoImpl<ProductSpec, Long> implements ProductSpecDao {

	@Override
	public ProductSpec findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ProductSpec save(ProductSpec bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public ProductSpec deleteById(Long id) {
		ProductSpec entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ProductSpec> getEntityClass() {
		return ProductSpec.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}