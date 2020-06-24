package com.haoxuer.b2bcloud.finance.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.finance.data.dao.FinanceAccountDao;
import com.haoxuer.b2bcloud.finance.data.entity.FinanceAccount;
import com.haoxuer.b2bcloud.finance.data.service.FinanceAccountService;

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
* Created by imake on 2020年04月13日17:52:21.
*/


@Scope("prototype")
@Service
@Transactional
public class FinanceAccountServiceImpl implements FinanceAccountService {

	private FinanceAccountDao dao;


	@Override
	@Transactional(readOnly = true)
	public FinanceAccount findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public FinanceAccount save(FinanceAccount bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public FinanceAccount update(FinanceAccount bean) {
		Updater<FinanceAccount> updater = new Updater<FinanceAccount>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public FinanceAccount deleteById(Long id) {
		FinanceAccount bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public FinanceAccount[] deleteByIds(Long[] ids) {
		FinanceAccount[] beans = new FinanceAccount[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(FinanceAccountDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<FinanceAccount> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<FinanceAccount> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<FinanceAccount> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}