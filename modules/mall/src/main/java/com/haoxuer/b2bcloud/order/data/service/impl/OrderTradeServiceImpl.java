package com.haoxuer.b2bcloud.order.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.order.data.dao.OrderTradeDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderTrade;
import com.haoxuer.b2bcloud.order.data.service.OrderTradeService;

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
* Created by imake on 2020年05月18日19:57:06.
*/


@Scope("prototype")
@Service
@Transactional
public class OrderTradeServiceImpl implements OrderTradeService {

	private OrderTradeDao dao;


	@Override
	@Transactional(readOnly = true)
	public OrderTrade findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public OrderTrade save(OrderTrade bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public OrderTrade update(OrderTrade bean) {
		Updater<OrderTrade> updater = new Updater<OrderTrade>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public OrderTrade deleteById(Long id) {
		OrderTrade bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public OrderTrade[] deleteByIds(Long[] ids) {
		OrderTrade[] beans = new OrderTrade[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(OrderTradeDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<OrderTrade> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<OrderTrade> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<OrderTrade> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public OrderTrade findById(Long tenant, Long id) {
        return dao.findById(tenant, id);
    }

    @Override
    public OrderTrade deleteById(Long tenant, Long id) {
        return dao.deleteById(tenant, id);
    }
}