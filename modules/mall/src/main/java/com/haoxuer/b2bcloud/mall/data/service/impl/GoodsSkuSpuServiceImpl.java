package com.haoxuer.b2bcloud.mall.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.mall.data.dao.GoodsSkuSpuDao;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsSkuSpu;
import com.haoxuer.b2bcloud.mall.data.service.GoodsSkuSpuService;

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
* Created by imake on 2020年01月17日14:09:33.
*/


@Scope("prototype")
@Service
@Transactional
public class GoodsSkuSpuServiceImpl implements GoodsSkuSpuService {

	private GoodsSkuSpuDao dao;


	@Override
	@Transactional(readOnly = true)
	public GoodsSkuSpu findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public GoodsSkuSpu save(GoodsSkuSpu bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public GoodsSkuSpu update(GoodsSkuSpu bean) {
		Updater<GoodsSkuSpu> updater = new Updater<GoodsSkuSpu>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public GoodsSkuSpu deleteById(Long id) {
		GoodsSkuSpu bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public GoodsSkuSpu[] deleteByIds(Long[] ids) {
		GoodsSkuSpu[] beans = new GoodsSkuSpu[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(GoodsSkuSpuDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<GoodsSkuSpu> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<GoodsSkuSpu> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<GoodsSkuSpu> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}