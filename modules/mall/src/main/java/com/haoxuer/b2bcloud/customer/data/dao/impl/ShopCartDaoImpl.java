package com.haoxuer.b2bcloud.customer.data.dao.impl;

import com.haoxuer.bigworld.member.data.entity.TenantUser;
import com.haoxuer.bigworld.tenant.data.entity.Tenant;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.haoxuer.discover.data.page.Filter;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.customer.data.dao.ShopCartDao;
import com.haoxuer.b2bcloud.customer.data.entity.ShopCart;

/**
 * Created by imake on 2020年05月23日19:44:59.
 */
@Repository

public class ShopCartDaoImpl extends CriteriaDaoImpl<ShopCart, Long> implements ShopCartDao {

    @Override
    public ShopCart findById(Long id) {
        if (id == null) {
            return null;
        }
        return get(id);
    }

    @Override
    public ShopCart save(ShopCart bean) {

        getSession().save(bean);


        return bean;
    }

    @Override
    public ShopCart deleteById(Long id) {
        ShopCart entity = super.get(id);
        if (entity != null) {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    protected Class<ShopCart> getEntityClass() {
        return ShopCart.class;
    }

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public ShopCart findById(Long tenant, Long id) {
        if (id == null) {
            return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
    }

    @Override
    public ShopCart deleteById(Long tenant, Long id) {
        ShopCart entity = one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
        if (entity != null) {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    public ShopCart findByUser(Long user,Long tenant) {
        ShopCart cart = one(Filter.eq("user.id", user));
        if (cart == null) {
            cart = new ShopCart();
            cart.setUser(TenantUser.fromId(user));
            cart.setNum(0);
            cart.setTenant(Tenant.fromId(tenant));
            save(cart);
        }
        return cart;
    }
}