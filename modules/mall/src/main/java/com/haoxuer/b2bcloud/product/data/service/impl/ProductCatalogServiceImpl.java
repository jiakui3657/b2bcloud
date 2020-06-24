package com.haoxuer.b2bcloud.product.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.product.data.dao.ProductCatalogDao;
import com.haoxuer.b2bcloud.product.data.entity.ProductCatalog;
import com.haoxuer.b2bcloud.product.data.service.ProductCatalogService;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import com.haoxuer.discover.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2020年05月07日19:01:34.
*/


@Scope("prototype")
@Service
@Transactional
public class ProductCatalogServiceImpl implements ProductCatalogService {

	private ProductCatalogDao dao;


	@Override
	@Transactional(readOnly = true)
	public ProductCatalog findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<ProductCatalog> findByTops(Integer pid) {
		LinkedList<ProductCatalog> result = new LinkedList<ProductCatalog>();
		ProductCatalog catalog = dao.findById(pid);
	    if(catalog != null){
			while ( catalog != null && catalog.getParent() != null ) {
				result.addFirst(catalog);
				catalog = dao.findById(catalog.getParentId());
			}
			result.addFirst(catalog);
	    }
		return result;
	}


    @Override
    public List<ProductCatalog> child(Integer id,Integer max) {
        List<Order> orders=new ArrayList<Order>();
        orders.add(Order.asc("code"));
        List<Filter> list=new ArrayList<Filter>();
        list.add(Filter.eq("parent.id",id));
        return dao.list(0,max,list,orders);
	}

	@Override
    @Transactional
	public ProductCatalog save(ProductCatalog bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public ProductCatalog update(ProductCatalog bean) {
		Updater<ProductCatalog> updater = new Updater<ProductCatalog>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public ProductCatalog deleteById(Integer id) {
		ProductCatalog bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public ProductCatalog[] deleteByIds(Integer[] ids) {
		ProductCatalog[] beans = new ProductCatalog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ProductCatalogDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<ProductCatalog> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<ProductCatalog> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<ProductCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public ProductCatalog findById(Long tenant, Integer id) {
        return dao.findById(tenant, id);
    }

    @Override
    public ProductCatalog deleteById(Long tenant, Integer id) {
        return dao.deleteById(tenant, id);
    }
}