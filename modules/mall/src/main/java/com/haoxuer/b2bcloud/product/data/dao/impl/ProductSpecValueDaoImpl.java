package com.haoxuer.b2bcloud.product.data.dao.impl;

import com.haoxuer.discover.data.page.Filter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.product.data.dao.ProductSpecValueDao;
import com.haoxuer.b2bcloud.product.data.entity.ProductSpecValue;

/**
 * Created by imake on 2020年04月15日19:43:49.
 */
@Repository

public class ProductSpecValueDaoImpl extends CriteriaDaoImpl<ProductSpecValue, Long> implements ProductSpecValueDao {

    @Override
    public ProductSpecValue findById(Long id) {
        if (id == null) {
            return null;
        }
        return get(id);
    }

    @Override
    public ProductSpecValue save(ProductSpecValue bean) {
        ProductSpecValue specValue = one(Filter.eq("spec.id", bean.getSpec().getId()),
                Filter.eq("name", bean.getName()));
        if (specValue == null) {
            getSession().save(bean);
        }
        return bean;
    }

    @Override
    public ProductSpecValue deleteById(Long id) {
        ProductSpecValue entity = super.get(id);
        if (entity != null) {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    protected Class<ProductSpecValue> getEntityClass() {
        return ProductSpecValue.class;
    }

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}