package com.haoxuer.b2bcloud.customer.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerLevelDao;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerLevel;
import com.haoxuer.b2bcloud.customer.data.service.CustomerLevelService;

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
* Created by imake on 2020年05月07日11:15:21.
*/


@Scope("prototype")
@Service
@Transactional
public class CustomerLevelServiceImpl implements CustomerLevelService {

	private CustomerLevelDao dao;


	@Override
	@Transactional(readOnly = true)
	public CustomerLevel findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public CustomerLevel save(CustomerLevel bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public CustomerLevel update(CustomerLevel bean) {
		Updater<CustomerLevel> updater = new Updater<CustomerLevel>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public CustomerLevel deleteById(Long id) {
		CustomerLevel bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public CustomerLevel[] deleteByIds(Long[] ids) {
		CustomerLevel[] beans = new CustomerLevel[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(CustomerLevelDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<CustomerLevel> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<CustomerLevel> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<CustomerLevel> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public CustomerLevel findById(Long tenant, Long id) {
        return dao.findById(tenant, id);
    }

    @Override
    public CustomerLevel deleteById(Long tenant, Long id) {
        return dao.deleteById(tenant, id);
    }
}