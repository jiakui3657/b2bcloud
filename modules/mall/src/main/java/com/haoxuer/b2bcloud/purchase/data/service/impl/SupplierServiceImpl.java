package com.haoxuer.b2bcloud.purchase.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.purchase.data.dao.SupplierDao;
import com.haoxuer.b2bcloud.purchase.data.entity.Supplier;
import com.haoxuer.b2bcloud.purchase.data.service.SupplierService;

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
* Created by imake on 2020年05月12日19:55:07.
*/


@Scope("prototype")
@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

	private SupplierDao dao;


	@Override
	@Transactional(readOnly = true)
	public Supplier findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Supplier save(Supplier bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Supplier update(Supplier bean) {
		Updater<Supplier> updater = new Updater<Supplier>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Supplier deleteById(Long id) {
		Supplier bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Supplier[] deleteByIds(Long[] ids) {
		Supplier[] beans = new Supplier[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(SupplierDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Supplier> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Supplier> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Supplier> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public Supplier findById(Long tenant, Long id) {
        return dao.findById(tenant, id);
    }

    @Override
    public Supplier deleteById(Long tenant, Long id) {
        return dao.deleteById(tenant, id);
    }
}