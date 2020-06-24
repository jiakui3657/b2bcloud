package com.haoxuer.b2bcloud.product.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.product.data.dao.ProductSpecValueDao;
import com.haoxuer.b2bcloud.product.data.entity.ProductSpecValue;
import com.haoxuer.b2bcloud.product.data.service.ProductSpecValueService;

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
* Created by imake on 2020年04月15日19:43:49.
*/


@Scope("prototype")
@Service
@Transactional
public class ProductSpecValueServiceImpl implements ProductSpecValueService {

	private ProductSpecValueDao dao;


	@Override
	@Transactional(readOnly = true)
	public ProductSpecValue findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public ProductSpecValue save(ProductSpecValue bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public ProductSpecValue update(ProductSpecValue bean) {
		Updater<ProductSpecValue> updater = new Updater<ProductSpecValue>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public ProductSpecValue deleteById(Long id) {
		ProductSpecValue bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public ProductSpecValue[] deleteByIds(Long[] ids) {
		ProductSpecValue[] beans = new ProductSpecValue[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ProductSpecValueDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<ProductSpecValue> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<ProductSpecValue> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<ProductSpecValue> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}