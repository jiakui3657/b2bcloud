package com.haoxuer.b2bcloud.finance.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.finance.data.dao.BillDao;
import com.haoxuer.b2bcloud.finance.data.entity.Bill;
import com.haoxuer.b2bcloud.finance.data.service.BillService;

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
* Created by imake on 2020年04月13日17:52:50.
*/


@Scope("prototype")
@Service
@Transactional
public class BillServiceImpl implements BillService {

	private BillDao dao;


	@Override
	@Transactional(readOnly = true)
	public Bill findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Bill save(Bill bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Bill update(Bill bean) {
		Updater<Bill> updater = new Updater<Bill>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Bill deleteById(Long id) {
		Bill bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Bill[] deleteByIds(Long[] ids) {
		Bill[] beans = new Bill[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(BillDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Bill> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Bill> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Bill> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}