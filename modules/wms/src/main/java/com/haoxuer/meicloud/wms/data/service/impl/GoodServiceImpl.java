package com.haoxuer.meicloud.wms.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.meicloud.wms.data.dao.GoodDao;
import com.haoxuer.meicloud.wms.data.entity.Good;
import com.haoxuer.meicloud.wms.data.service.GoodService;

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
* Created by imake on 2019年11月20日12:11:02.
*/


@Scope("prototype")
@Service
@Transactional
public class GoodServiceImpl implements GoodService {

	private GoodDao dao;


	@Override
	@Transactional(readOnly = true)
	public Good findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Good save(Good bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Good update(Good bean) {
		Updater<Good> updater = new Updater<Good>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Good deleteById(Long id) {
		Good bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Good[] deleteByIds(Long[] ids) {
		Good[] beans = new Good[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(GoodDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Good> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Good> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Good> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}