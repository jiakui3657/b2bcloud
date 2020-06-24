package com.haoxuer.b2bcloud.mall.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.mall.data.dao.SpuNameDao;
import com.haoxuer.b2bcloud.mall.data.entity.SpuName;
import com.haoxuer.b2bcloud.mall.data.service.SpuNameService;

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
* Created by imake on 2019年12月31日15:41:42.
*/


@Scope("prototype")
@Service
@Transactional
public class SpuNameServiceImpl implements SpuNameService {

	private SpuNameDao dao;


	@Override
	@Transactional(readOnly = true)
	public SpuName findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public SpuName save(SpuName bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public SpuName update(SpuName bean) {
		Updater<SpuName> updater = new Updater<SpuName>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public SpuName deleteById(Long id) {
		SpuName bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public SpuName[] deleteByIds(Long[] ids) {
		SpuName[] beans = new SpuName[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(SpuNameDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<SpuName> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<SpuName> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<SpuName> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}