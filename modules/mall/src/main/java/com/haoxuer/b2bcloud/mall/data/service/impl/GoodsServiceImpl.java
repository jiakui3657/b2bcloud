package com.haoxuer.b2bcloud.mall.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.mall.data.dao.GoodsDao;
import com.haoxuer.b2bcloud.mall.data.entity.Goods;
import com.haoxuer.b2bcloud.mall.data.service.GoodsService;

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
* Created by imake on 2019年12月29日13:46:48.
*/


@Scope("prototype")
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

	private GoodsDao dao;


	@Override
	@Transactional(readOnly = true)
	public Goods findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Goods save(Goods bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Goods update(Goods bean) {
		Updater<Goods> updater = new Updater<Goods>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Goods deleteById(Long id) {
		Goods bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Goods[] deleteByIds(Long[] ids) {
		Goods[] beans = new Goods[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Goods> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Goods> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Goods> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}