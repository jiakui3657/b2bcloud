package com.haoxuer.b2bcloud.finance.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.finance.data.dao.InvoiceDao;
import com.haoxuer.b2bcloud.finance.data.entity.Invoice;
import com.haoxuer.b2bcloud.finance.data.service.InvoiceService;

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
* Created by imake on 2020年05月15日17:23:36.
*/


@Scope("prototype")
@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

	private InvoiceDao dao;


	@Override
	@Transactional(readOnly = true)
	public Invoice findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Invoice save(Invoice bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Invoice update(Invoice bean) {
		Updater<Invoice> updater = new Updater<Invoice>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Invoice deleteById(Long id) {
		Invoice bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Invoice[] deleteByIds(Long[] ids) {
		Invoice[] beans = new Invoice[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(InvoiceDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Invoice> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Invoice> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Invoice> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public Invoice findById(Long tenant, Long id) {
        return dao.findById(tenant, id);
    }

    @Override
    public Invoice deleteById(Long tenant, Long id) {
        return dao.deleteById(tenant, id);
    }
}