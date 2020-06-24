package com.haoxuer.b2bcloud.promote.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.promote.data.dao.CouponDao;
import com.haoxuer.b2bcloud.promote.data.entity.Coupon;
import com.haoxuer.b2bcloud.promote.data.service.CouponService;

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
* Created by imake on 2020年05月06日21:50:05.
*/


@Scope("prototype")
@Service
@Transactional
public class CouponServiceImpl implements CouponService {

	private CouponDao dao;


	@Override
	@Transactional(readOnly = true)
	public Coupon findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Coupon save(Coupon bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Coupon update(Coupon bean) {
		Updater<Coupon> updater = new Updater<Coupon>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Coupon deleteById(Long id) {
		Coupon bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Coupon[] deleteByIds(Long[] ids) {
		Coupon[] beans = new Coupon[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(CouponDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Coupon> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Coupon> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Coupon> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public Coupon findById(Long tenant, Long id) {
        return dao.findById(tenant, id);
    }

    @Override
    public Coupon deleteById(Long tenant, Long id) {
        return dao.deleteById(tenant, id);
    }
}