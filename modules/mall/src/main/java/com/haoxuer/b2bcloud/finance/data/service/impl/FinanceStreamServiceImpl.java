package com.haoxuer.b2bcloud.finance.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.finance.data.dao.FinanceStreamDao;
import com.haoxuer.b2bcloud.finance.data.entity.FinanceStream;
import com.haoxuer.b2bcloud.finance.data.service.FinanceStreamService;

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
* Created by imake on 2020年04月13日17:53:59.
*/


@Scope("prototype")
@Service
@Transactional
public class FinanceStreamServiceImpl implements FinanceStreamService {

	private FinanceStreamDao dao;


	@Override
	@Transactional(readOnly = true)
	public FinanceStream findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public FinanceStream save(FinanceStream bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public FinanceStream update(FinanceStream bean) {
		Updater<FinanceStream> updater = new Updater<FinanceStream>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public FinanceStream deleteById(Long id) {
		FinanceStream bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public FinanceStream[] deleteByIds(Long[] ids) {
		FinanceStream[] beans = new FinanceStream[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(FinanceStreamDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<FinanceStream> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<FinanceStream> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<FinanceStream> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}