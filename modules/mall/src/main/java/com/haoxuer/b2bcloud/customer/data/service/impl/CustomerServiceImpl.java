package com.haoxuer.b2bcloud.customer.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerDao;
import com.haoxuer.b2bcloud.customer.data.entity.Customer;
import com.haoxuer.b2bcloud.customer.data.service.CustomerService;

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
* Created by imake on 2020年01月13日13:03:05.
*/


@Scope("prototype")
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao dao;


	@Override
	@Transactional(readOnly = true)
	public Customer findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Customer save(Customer bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Customer update(Customer bean) {
		Updater<Customer> updater = new Updater<Customer>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Customer deleteById(Long id) {
		Customer bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Customer[] deleteByIds(Long[] ids) {
		Customer[] beans = new Customer[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Customer> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Customer> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Customer> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}