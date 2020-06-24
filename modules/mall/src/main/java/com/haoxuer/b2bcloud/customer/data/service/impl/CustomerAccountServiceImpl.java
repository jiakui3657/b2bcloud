package com.haoxuer.b2bcloud.customer.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerAccountDao;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerAccount;
import com.haoxuer.b2bcloud.customer.data.service.CustomerAccountService;

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
* Created by imake on 2020年03月27日21:05:33.
*/


@Scope("prototype")
@Service
@Transactional
public class CustomerAccountServiceImpl implements CustomerAccountService {

	private CustomerAccountDao dao;


	@Override
	@Transactional(readOnly = true)
	public CustomerAccount findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public CustomerAccount save(CustomerAccount bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public CustomerAccount update(CustomerAccount bean) {
		Updater<CustomerAccount> updater = new Updater<CustomerAccount>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public CustomerAccount deleteById(Long id) {
		CustomerAccount bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public CustomerAccount[] deleteByIds(Long[] ids) {
		CustomerAccount[] beans = new CustomerAccount[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(CustomerAccountDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<CustomerAccount> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<CustomerAccount> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<CustomerAccount> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}