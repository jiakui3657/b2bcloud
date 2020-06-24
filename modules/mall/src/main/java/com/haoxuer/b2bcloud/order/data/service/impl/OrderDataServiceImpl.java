package com.haoxuer.b2bcloud.order.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.order.data.dao.OrderDataDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderData;
import com.haoxuer.b2bcloud.order.data.service.OrderDataService;

import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import com.haoxuer.discover.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2020年05月08日10:28:40.
*/


@Scope("prototype")
@Service
@Transactional
public class OrderDataServiceImpl implements OrderDataService {

	private OrderDataDao dao;


	@Override
	@Transactional(readOnly = true)
	public OrderData findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public OrderData save(OrderData bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public OrderData update(OrderData bean) {
		Updater<OrderData> updater = new Updater<OrderData>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public OrderData deleteById(Long id) {
		OrderData bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public OrderData[] deleteByIds(Long[] ids) {
		OrderData[] beans = new OrderData[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(OrderDataDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<OrderData> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<OrderData> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<OrderData> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public OrderData findById(Long tenant, Long id) {
        return dao.findById(tenant, id);
    }

    @Override
    public OrderData deleteById(Long tenant, Long id) {
        return dao.deleteById(tenant, id);
    }

	@Override
	public BigDecimal sum(List<Filter> filters) {
		return dao.sum(filters);
	}
}