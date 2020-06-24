package com.haoxuer.b2bcloud.customer.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.customer.data.dao.CustomerTagDao;
import com.haoxuer.b2bcloud.customer.data.entity.CustomerTag;
import com.haoxuer.b2bcloud.customer.data.service.CustomerTagService;

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
* Created by imake on 2020年05月09日15:47:39.
*/


@Scope("prototype")
@Service
@Transactional
public class CustomerTagServiceImpl implements CustomerTagService {

	private CustomerTagDao dao;


	@Override
	@Transactional(readOnly = true)
	public CustomerTag findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public CustomerTag save(CustomerTag bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public CustomerTag update(CustomerTag bean) {
		Updater<CustomerTag> updater = new Updater<CustomerTag>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public CustomerTag deleteById(Long id) {
		CustomerTag bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public CustomerTag[] deleteByIds(Long[] ids) {
		CustomerTag[] beans = new CustomerTag[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(CustomerTagDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<CustomerTag> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<CustomerTag> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<CustomerTag> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public CustomerTag findById(Long tenant, Long id) {
        return dao.findById(tenant, id);
    }

    @Override
    public CustomerTag deleteById(Long tenant, Long id) {
        return dao.deleteById(tenant, id);
    }
}