package com.haoxuer.b2bcloud.customer.data.dao.impl;

import com.haoxuer.b2bcloud.customer.data.entity.ShopCart;
import com.haoxuer.b2bcloud.product.data.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.customer.data.dao.ShopCartItemDao;
import com.haoxuer.b2bcloud.customer.data.entity.ShopCartItem;

/**
 * Created by imake on 2020年05月23日19:44:59.
 */
@Repository

public class ShopCartItemDaoImpl extends CriteriaDaoImpl<ShopCartItem, Long> implements ShopCartItemDao {

    @Override
    public ShopCartItem findById(Long id) {
        if (id == null) {
            return null;
        }
        return get(id);
    }

    @Override
    public ShopCartItem save(ShopCartItem bean) {

        getSession().save(bean);


        return bean;
    }

    @Override
    public ShopCartItem deleteById(Long id) {
        ShopCartItem entity = super.get(id);
        if (entity != null) {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    protected Class<ShopCartItem> getEntityClass() {
        return ShopCartItem.class;
    }

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public ShopCartItem findById(Long tenant, Long id) {
        if (id == null) {
            return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
    }

    @Override
    public ShopCartItem deleteById(Long tenant, Long id) {
        ShopCartItem entity = one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
        if (entity != null) {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    public ShopCartItem findByCart(Long cart, Long product) {
        ShopCartItem item = one(Filter.eq("cart.id", cart), Filter.eq("product.id", product));
        return item;
    }
}