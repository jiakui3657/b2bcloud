package com.haoxuer.b2bcloud.product.data.dao.impl;

import com.haoxuer.discover.data.enums.StoreState;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.product.data.dao.ProductLabelDao;
import com.haoxuer.b2bcloud.product.data.entity.ProductLabel;

/**
* Created by imake on 2020年05月06日22:17:46.
*/
@Repository

public class ProductLabelDaoImpl extends CriteriaDaoImpl<ProductLabel, Long> implements ProductLabelDao {

	@Override
	public ProductLabel findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ProductLabel save(ProductLabel bean) {

		ProductLabel temp = one(Filter.eq("tenant.id", bean.getTenant().getId()),
				Filter.eq("name", bean.getName()));
		if (temp == null) {
			getSession().save(bean);
		} else {
			temp.setStoreState(StoreState.normal);
		}
		bean = temp;
		return bean;
	}

	@Override
	public ProductLabel deleteById(Long id) {
		ProductLabel entity = super.get(id);
		if (entity != null) {
			entity.setStoreState(StoreState.recycle);
		}
		return entity;
	}
	
	@Override
	protected Class<ProductLabel> getEntityClass() {
		return ProductLabel.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public ProductLabel findById(Long tenant,Long id) {
	    if (id == null) {
           return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
	}

    @Override
	public ProductLabel deleteById(Long tenant,Long id) {
		ProductLabel entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
}