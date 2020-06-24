package com.haoxuer.b2bcloud.product.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.product.data.dao.ProductCatalogDao;
import com.haoxuer.b2bcloud.product.data.entity.ProductCatalog;
import com.haoxuer.discover.data.core.CatalogDaoImpl;

/**
* Created by imake on 2020年05月07日19:01:34.
*/
@Repository

public class ProductCatalogDaoImpl extends CatalogDaoImpl<ProductCatalog, Integer> implements ProductCatalogDao {

	@Override
	public ProductCatalog findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ProductCatalog save(ProductCatalog bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public ProductCatalog deleteById(Integer id) {
		ProductCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ProductCatalog> getEntityClass() {
		return ProductCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public ProductCatalog findById(Long tenant,Integer id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public ProductCatalog deleteById(Long tenant,Integer id) {
		ProductCatalog entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}