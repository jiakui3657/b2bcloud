package com.haoxuer.b2bcloud.product.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.product.data.dao.ProductPriceDao;
import com.haoxuer.b2bcloud.product.data.entity.ProductPrice;

/**
* Created by imake on 2020年03月30日16:56:18.
*/
@Repository

public class ProductPriceDaoImpl extends CriteriaDaoImpl<ProductPrice, Long> implements ProductPriceDao {

	@Override
	public ProductPrice findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ProductPrice save(ProductPrice bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public ProductPrice deleteById(Long id) {
		ProductPrice entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ProductPrice> getEntityClass() {
		return ProductPrice.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}