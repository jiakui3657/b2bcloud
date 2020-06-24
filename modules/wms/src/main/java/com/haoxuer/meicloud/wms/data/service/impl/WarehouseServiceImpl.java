package com.haoxuer.meicloud.wms.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.meicloud.wms.data.dao.WarehouseDao;
import com.haoxuer.meicloud.wms.data.entity.Warehouse;
import com.haoxuer.meicloud.wms.data.service.WarehouseService;

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
* Created by imake on 2019年11月20日17:50:41.
*/


@Scope("prototype")
@Service
@Transactional
public class WarehouseServiceImpl implements WarehouseService {

	private WarehouseDao dao;


	@Override
	@Transactional(readOnly = true)
	public Warehouse findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Warehouse save(Warehouse bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Warehouse update(Warehouse bean) {
		Updater<Warehouse> updater = new Updater<Warehouse>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Warehouse deleteById(Long id) {
		Warehouse bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Warehouse[] deleteByIds(Long[] ids) {
		Warehouse[] beans = new Warehouse[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(WarehouseDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Warehouse> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Warehouse> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Warehouse> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}