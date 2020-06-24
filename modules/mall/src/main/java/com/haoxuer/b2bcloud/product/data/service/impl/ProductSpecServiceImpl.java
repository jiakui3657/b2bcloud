package com.haoxuer.b2bcloud.product.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.product.data.dao.ProductSpecDao;
import com.haoxuer.b2bcloud.product.data.entity.ProductSpec;
import com.haoxuer.b2bcloud.product.data.service.ProductSpecService;

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
* Created by imake on 2020年04月15日19:22:54.
*/


@Scope("prototype")
@Service
@Transactional
public class ProductSpecServiceImpl implements ProductSpecService {

	private ProductSpecDao dao;


	@Override
	@Transactional(readOnly = true)
	public ProductSpec findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public ProductSpec save(ProductSpec bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public ProductSpec update(ProductSpec bean) {
		Updater<ProductSpec> updater = new Updater<ProductSpec>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public ProductSpec deleteById(Long id) {
		ProductSpec bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public ProductSpec[] deleteByIds(Long[] ids) {
		ProductSpec[] beans = new ProductSpec[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ProductSpecDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<ProductSpec> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<ProductSpec> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<ProductSpec> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}