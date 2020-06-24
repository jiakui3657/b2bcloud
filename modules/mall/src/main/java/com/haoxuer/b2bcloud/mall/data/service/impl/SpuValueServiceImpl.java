package com.haoxuer.b2bcloud.mall.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.mall.data.dao.SpuValueDao;
import com.haoxuer.b2bcloud.mall.data.entity.SpuValue;
import com.haoxuer.b2bcloud.mall.data.service.SpuValueService;

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
* Created by imake on 2019年12月29日13:42:35.
*/


@Scope("prototype")
@Service
@Transactional
public class SpuValueServiceImpl implements SpuValueService {

	private SpuValueDao dao;


	@Override
	@Transactional(readOnly = true)
	public SpuValue findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public SpuValue save(SpuValue bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public SpuValue update(SpuValue bean) {
		Updater<SpuValue> updater = new Updater<SpuValue>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public SpuValue deleteById(Long id) {
		SpuValue bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public SpuValue[] deleteByIds(Long[] ids) {
		SpuValue[] beans = new SpuValue[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(SpuValueDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<SpuValue> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<SpuValue> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<SpuValue> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);
	}

	@Override
	public List<SpuValue> findlist(int first, Integer size, List<Filter> filters, List<Order> orders) {
		return dao.findlist(first,size,filters,orders);
	}
}