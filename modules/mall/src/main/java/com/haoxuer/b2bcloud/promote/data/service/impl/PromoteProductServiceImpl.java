package com.haoxuer.b2bcloud.promote.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.promote.data.dao.PromoteProductDao;
import com.haoxuer.b2bcloud.promote.data.entity.PromoteProduct;
import com.haoxuer.b2bcloud.promote.data.service.PromoteProductService;

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
* Created by imake on 2020年05月11日14:14:40.
*/


@Scope("prototype")
@Service
@Transactional
public class PromoteProductServiceImpl implements PromoteProductService {

	private PromoteProductDao dao;


	@Override
	@Transactional(readOnly = true)
	public PromoteProduct findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public PromoteProduct save(PromoteProduct bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public PromoteProduct update(PromoteProduct bean) {
		Updater<PromoteProduct> updater = new Updater<PromoteProduct>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public PromoteProduct deleteById(Long id) {
		PromoteProduct bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public PromoteProduct[] deleteByIds(Long[] ids) {
		PromoteProduct[] beans = new PromoteProduct[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(PromoteProductDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<PromoteProduct> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<PromoteProduct> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<PromoteProduct> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public PromoteProduct findById(Long tenant, Long id) {
        return dao.findById(tenant, id);
    }

    @Override
    public PromoteProduct deleteById(Long tenant, Long id) {
        return dao.deleteById(tenant, id);
    }
}