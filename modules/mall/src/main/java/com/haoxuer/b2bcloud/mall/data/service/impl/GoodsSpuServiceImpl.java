package com.haoxuer.b2bcloud.mall.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.mall.data.dao.GoodsSpuDao;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsSpu;
import com.haoxuer.b2bcloud.mall.data.service.GoodsSpuService;

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
* Created by imake on 2019年12月29日13:42:02.
*/


@Scope("prototype")
@Service
@Transactional
public class GoodsSpuServiceImpl implements GoodsSpuService {

	private GoodsSpuDao dao;


	@Override
	@Transactional(readOnly = true)
	public GoodsSpu findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public GoodsSpu save(GoodsSpu bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public GoodsSpu update(GoodsSpu bean) {
		Updater<GoodsSpu> updater = new Updater<GoodsSpu>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public GoodsSpu deleteById(Long id) {
		GoodsSpu bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public GoodsSpu[] deleteByIds(Long[] ids) {
		GoodsSpu[] beans = new GoodsSpu[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(GoodsSpuDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<GoodsSpu> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<GoodsSpu> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<GoodsSpu> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}