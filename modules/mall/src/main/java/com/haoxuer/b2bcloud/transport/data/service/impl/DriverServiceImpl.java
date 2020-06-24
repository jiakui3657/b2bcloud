package com.haoxuer.b2bcloud.transport.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.transport.data.dao.DriverDao;
import com.haoxuer.b2bcloud.transport.data.entity.Driver;
import com.haoxuer.b2bcloud.transport.data.service.DriverService;

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
* Created by imake on 2020年03月21日16:54:58.
*/


@Scope("prototype")
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

	private DriverDao dao;


	@Override
	@Transactional(readOnly = true)
	public Driver findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Driver save(Driver bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Driver update(Driver bean) {
		Updater<Driver> updater = new Updater<Driver>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Driver deleteById(Long id) {
		Driver bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Driver[] deleteByIds(Long[] ids) {
		Driver[] beans = new Driver[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(DriverDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Driver> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Driver> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Driver> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}