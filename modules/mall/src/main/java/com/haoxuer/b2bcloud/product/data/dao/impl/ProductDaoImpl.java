package com.haoxuer.b2bcloud.product.data.dao.impl;

import com.haoxuer.b2bcloud.order.data.entity.OrderTrade;
import com.haoxuer.discover.data.core.Finder;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.b2bcloud.product.data.dao.ProductDao;
import com.haoxuer.b2bcloud.product.data.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by imake on 2020年03月23日16:15:52.
 */
@Repository

public class ProductDaoImpl extends CriteriaDaoImpl<Product, Long> implements ProductDao {

    @Override
    public Product findById(Long id) {
        if (id == null) {
            return null;
        }
        return get(id);
    }

    @Override
    public Product save(Product bean) {

        getSession().save(bean);


        return bean;
    }

    @Override
    protected Finder makeFinder(List<Filter> filters, List<Order> orders) {
        Finder finder = Finder.create();
        finder.append("select distinct model from " + getEntityClass().getSimpleName());
        if (filters == null || filters.isEmpty()) {
            finder.append(" model ");
        } else {
            finder.append(" model where ");
        }

        makerFilter(filters, finder);

        makeOrder(orders, finder);
        return finder;
    }

    protected void makerFilter(List<Filter> filters, Finder finder, List<Long> tags) {
        if (filters != null&&filters.size()>0) {
            handles(filters, finder);
            if (tags!=null&&tags.size()>0){
                finder.append(" and in_tag in (:in_tags)");
                finder.setParam("in_tags", tags);
            }
        }else{
            //没有过滤器
            finder.append(" where  in_tag in (:in_tags)");
            finder.setParam("in_tags", tags);
        }
    }

    private void handles(List<Filter> filters, Finder finder) {
        int i = 0;
        for (Filter filter : filters) {

            if (i == 0) {
                finder.append(" model." + filter.getProperty());
            } else {
                finder.append(" " + filter.getCondition() + "  model." + filter.getProperty());
            }
            String cname = filter.getPrefix() + getProperty(filter);
            if (filter.getOperator() == Filter.Operator.eq) {
                finder.append(" =:" + cname);
            } else if (filter.getOperator() == Filter.Operator.ne) {
                finder.append(" !=:" + cname);
            } else if (filter.getOperator() == Filter.Operator.ge) {
                finder.append(" >=:" + cname);
            } else if (filter.getOperator() == Filter.Operator.gt) {
                finder.append(" >:" + cname);
            } else if (filter.getOperator() == Filter.Operator.le) {
                finder.append(" <=:" + cname);
            } else if (filter.getOperator() == Filter.Operator.lt) {
                finder.append(" <:" + cname);
            } else if (filter.getOperator() == Filter.Operator.like) {
                finder.append(" like:" + cname);
            } else if (filter.getOperator() == Filter.Operator.isNull) {
                finder.append(" is null ");
            } else if (filter.getOperator() == Filter.Operator.isNotNull) {
                finder.append(" is not null  ");
            } else if (filter.getOperator() == Filter.Operator.in) {
                finder.append(" in  (:" + cname + ")");
            }

            if (filter.getOperator() == Filter.Operator.like) {
                finder.setParam(cname, "%" + filter.getValue() + "%");
            } else if (filter.getOperator() == Filter.Operator.isNotNull || filter.getOperator() == Filter.Operator.isNull) {
                //不用传递参数
            } else {
                finder.setParam(cname, filter.getValue());
            }
            i++;
        }
    }

    @Override
    protected void makerFilter(List<Filter> filters, Finder finder) {
        if (filters != null) {
            handles(filters, finder);
        }
    }

    @Override
    public Product deleteById(Long id) {
        Product entity = super.get(id);
        if (entity != null) {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    public Page<Product> page(Pageable pageable, List<Long> tags) {
        Page<Product> result = null;
        List<Filter> filters = pageable.getFilters();
        List<Order> orders = pageable.getOrders();

        Finder finder = Finder.create();
        finder.append("select distinct model from " + getEntityClass().getSimpleName());
        finder.append(" model ");
        if (tags != null && tags.size() > 0) {
            finder.append(" join model.tags in_tag");
        }
        if (filters == null || filters.isEmpty()) {
            finder.append("  ");
        } else {
            finder.append("  where ");
        }
        makerFilter(filters, finder,tags);

        makeOrder(orders, finder);


        Pagination<Product> page = find(finder, pageable.getPageNumber(), pageable.getPageSize());
        result = new Page<Product>(page.getList(), page.getTotalCount(), pageable);
        return result;
    }

    @Override
    public Product findById(Long tenant, Long id) {
        if (id == null) {
            return null;
        }
        return one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
    }

    @Override
    public Product deleteById(Long tenant, Long id) {
        Product entity =  one(Filter.eq("tenant.id", tenant), Filter.eq("id", id));
        if (entity != null) {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}