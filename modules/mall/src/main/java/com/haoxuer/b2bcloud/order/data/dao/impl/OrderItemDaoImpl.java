package com.haoxuer.b2bcloud.order.data.dao.impl;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.order.data.dao.OrderItemDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imake on 2020年03月30日15:27:08.
 */
@Repository

public class OrderItemDaoImpl extends CriteriaDaoImpl<OrderItem, Long> implements OrderItemDao {

    @Override
    public OrderItem findById(Long id) {
        if (id == null) {
            return null;
        }
        return get(id);
    }

    @Override
    public List<OrderItem> listByUser(Long user, Long product) {

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.eq("product.id", product));
        filters.add(Filter.eq("orderData.user.id", user));
        filters.add(Filter.gt("surplusNum",0));
        List<Order> orders = new ArrayList<>();
        orders.add(Order.asc("id"));
        return list(0, 100, filters, orders);
    }

    @Override
    public OrderItem save(OrderItem bean) {

        getSession().save(bean);


        return bean;
    }

    @Override
    public OrderItem deleteById(Long id) {
        OrderItem entity = super.get(id);
        if (entity != null) {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    protected Class<OrderItem> getEntityClass() {
        return OrderItem.class;
    }

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}