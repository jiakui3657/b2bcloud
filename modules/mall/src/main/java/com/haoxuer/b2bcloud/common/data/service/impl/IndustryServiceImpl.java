package com.haoxuer.b2bcloud.common.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.common.data.dao.IndustryDao;
import com.haoxuer.b2bcloud.common.data.entity.Industry;
import com.haoxuer.b2bcloud.common.data.service.IndustryService;

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
* Created by imake on 2020年05月07日14:03:56.
*/


@Scope("prototype")
@Service
@Transactional
public class IndustryServiceImpl implements IndustryService {

	private IndustryDao dao;


	@Override
	@Transactional(readOnly = true)
	public Industry findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Industry> findByTops(Integer pid) {
		LinkedList<Industry> result = new LinkedList<Industry>();
		Industry catalog = dao.findById(pid);
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
    public List<Industry> child(Integer id,Integer max) {
        List<Order> orders=new ArrayList<Order>();
        orders.add(Order.asc("code"));
        List<Filter> list=new ArrayList<Filter>();
        list.add(Filter.eq("parent.id",id));
        return dao.list(0,max,list,orders);
	}

	@Override
    @Transactional
	public Industry save(Industry bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Industry update(Industry bean) {
		Updater<Industry> updater = new Updater<Industry>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Industry deleteById(Integer id) {
		Industry bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Industry[] deleteByIds(Integer[] ids) {
		Industry[] beans = new Industry[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(IndustryDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Industry> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Industry> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Industry> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public Industry findById(Long tenant, Integer id) {
        return dao.findById(tenant, id);
    }

    @Override
    public Industry deleteById(Long tenant, Integer id) {
        return dao.deleteById(tenant, id);
    }
}