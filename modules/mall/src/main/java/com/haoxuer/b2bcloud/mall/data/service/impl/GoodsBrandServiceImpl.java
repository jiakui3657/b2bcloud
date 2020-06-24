package com.haoxuer.b2bcloud.mall.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.mall.data.dao.GoodsBrandDao;
import com.haoxuer.b2bcloud.mall.data.entity.GoodsBrand;
import com.haoxuer.b2bcloud.mall.data.service.GoodsBrandService;

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
* Created by imake on 2019年12月29日14:17:43.
*/


@Scope("prototype")
@Service
@Transactional
public class GoodsBrandServiceImpl implements GoodsBrandService {

	private GoodsBrandDao dao;


	@Override
	@Transactional(readOnly = true)
	public GoodsBrand findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public GoodsBrand save(GoodsBrand bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public GoodsBrand update(GoodsBrand bean) {
		Updater<GoodsBrand> updater = new Updater<GoodsBrand>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public GoodsBrand deleteById(Long id) {
		GoodsBrand bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public GoodsBrand[] deleteByIds(Long[] ids) {
		GoodsBrand[] beans = new GoodsBrand[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(GoodsBrandDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<GoodsBrand> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<GoodsBrand> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<GoodsBrand> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}