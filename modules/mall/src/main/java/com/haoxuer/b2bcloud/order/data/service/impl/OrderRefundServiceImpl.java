package com.haoxuer.b2bcloud.order.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.order.data.dao.OrderRefundDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderRefund;
import com.haoxuer.b2bcloud.order.data.service.OrderRefundService;

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
* Created by imake on 2020年05月09日23:00:47.
*/


@Scope("prototype")
@Service
@Transactional
public class OrderRefundServiceImpl implements OrderRefundService {

	private OrderRefundDao dao;


	@Override
	@Transactional(readOnly = true)
	public OrderRefund findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public OrderRefund save(OrderRefund bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public OrderRefund update(OrderRefund bean) {
		Updater<OrderRefund> updater = new Updater<OrderRefund>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public OrderRefund deleteById(Long id) {
		OrderRefund bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public OrderRefund[] deleteByIds(Long[] ids) {
		OrderRefund[] beans = new OrderRefund[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(OrderRefundDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<OrderRefund> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<OrderRefund> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<OrderRefund> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public OrderRefund findById(Long tenant, Long id) {
        return dao.findById(tenant, id);
    }

    @Override
    public OrderRefund deleteById(Long tenant, Long id) {
        return dao.deleteById(tenant, id);
    }
}