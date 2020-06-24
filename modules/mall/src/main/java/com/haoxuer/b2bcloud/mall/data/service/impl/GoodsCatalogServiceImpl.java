package com.haoxuer.b2bcloud.mall.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.mall.data.dao.GoodsCatalogDao;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsCatalog;
import com.haoxuer.b2bcloud.mall.data.service.GoodsCatalogService;

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
* Created by imake on 2019年12月29日13:42:18.
*/


@Scope("prototype")
@Service
@Transactional
public class GoodsCatalogServiceImpl implements GoodsCatalogService {

	private GoodsCatalogDao dao;


	@Override
	@Transactional(readOnly = true)
	public GoodsCatalog findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<GoodsCatalog> findByTops(Integer pid) {
		LinkedList<GoodsCatalog> result = new LinkedList<GoodsCatalog>();
		GoodsCatalog catalog = dao.findById(pid);
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
    public List<GoodsCatalog> child(Integer id,Integer max) {
        List<Order> orders=new ArrayList<Order>();
        orders.add(Order.asc("code"));
        List<Filter> list=new ArrayList<Filter>();
        list.add(Filter.eq("parent.id",id));
        return dao.list(0,max,list,orders);
	}

	@Override
    @Transactional
	public GoodsCatalog save(GoodsCatalog bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public GoodsCatalog update(GoodsCatalog bean) {
		Updater<GoodsCatalog> updater = new Updater<GoodsCatalog>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public GoodsCatalog deleteById(Integer id) {
		GoodsCatalog bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public GoodsCatalog[] deleteByIds(Integer[] ids) {
		GoodsCatalog[] beans = new GoodsCatalog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(GoodsCatalogDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<GoodsCatalog> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<GoodsCatalog> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<GoodsCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}