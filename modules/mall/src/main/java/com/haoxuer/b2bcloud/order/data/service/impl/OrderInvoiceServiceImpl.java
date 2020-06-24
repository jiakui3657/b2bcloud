package com.haoxuer.b2bcloud.order.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.order.data.dao.OrderInvoiceDao;
import com.haoxuer.b2bcloud.order.data.entity.OrderInvoice;
import com.haoxuer.b2bcloud.order.data.service.OrderInvoiceService;

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
* Created by imake on 2020年05月07日11:11:37.
*/


@Scope("prototype")
@Service
@Transactional
public class OrderInvoiceServiceImpl implements OrderInvoiceService {

	private OrderInvoiceDao dao;


	@Override
	@Transactional(readOnly = true)
	public OrderInvoice findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public OrderInvoice save(OrderInvoice bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public OrderInvoice update(OrderInvoice bean) {
		Updater<OrderInvoice> updater = new Updater<OrderInvoice>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public OrderInvoice deleteById(Long id) {
		OrderInvoice bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public OrderInvoice[] deleteByIds(Long[] ids) {
		OrderInvoice[] beans = new OrderInvoice[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(OrderInvoiceDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<OrderInvoice> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<OrderInvoice> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<OrderInvoice> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public OrderInvoice findById(Long tenant, Long id) {
        return dao.findById(tenant, id);
    }

    @Override
    public OrderInvoice deleteById(Long tenant, Long id) {
        return dao.deleteById(tenant, id);
    }
}