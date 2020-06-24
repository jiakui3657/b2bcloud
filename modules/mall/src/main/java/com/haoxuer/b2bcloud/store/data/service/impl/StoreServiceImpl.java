package com.haoxuer.b2bcloud.store.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.store.data.dao.StoreDao;
import com.haoxuer.b2bcloud.store.data.entity.Store;
import com.haoxuer.b2bcloud.store.data.service.StoreService;

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
* Created by imake on 2020年05月02日15:43:56.
*/


@Scope("prototype")
@Service
@Transactional
public class StoreServiceImpl implements StoreService {

	private StoreDao dao;


	@Override
	@Transactional(readOnly = true)
	public Store findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Store save(Store bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Store update(Store bean) {
		Updater<Store> updater = new Updater<Store>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Store deleteById(Long id) {
		Store bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Store[] deleteByIds(Long[] ids) {
		Store[] beans = new Store[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(StoreDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Store> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Store> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Store> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public Store findById(Long tenant, Long id) {
        return dao.findById(tenant, id);
    }

    @Override
    public Store deleteById(Long tenant, Long id) {
        return dao.deleteById(tenant, id);
    }
}