package com.haoxuer.b2bcloud.product.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.product.data.dao.ProductLabelDao;
import com.haoxuer.b2bcloud.product.data.entity.ProductLabel;
import com.haoxuer.b2bcloud.product.data.service.ProductLabelService;

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
* Created by imake on 2020年05月06日22:17:46.
*/


@Scope("prototype")
@Service
@Transactional
public class ProductLabelServiceImpl implements ProductLabelService {

	private ProductLabelDao dao;


	@Override
	@Transactional(readOnly = true)
	public ProductLabel findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public ProductLabel save(ProductLabel bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public ProductLabel update(ProductLabel bean) {
		Updater<ProductLabel> updater = new Updater<ProductLabel>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public ProductLabel deleteById(Long id) {
		ProductLabel bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public ProductLabel[] deleteByIds(Long[] ids) {
		ProductLabel[] beans = new ProductLabel[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ProductLabelDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<ProductLabel> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<ProductLabel> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<ProductLabel> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

    @Override
    public ProductLabel findById(Long tenant, Long id) {
        return dao.findById(tenant, id);
    }

    @Override
    public ProductLabel deleteById(Long tenant, Long id) {
        return dao.deleteById(tenant, id);
    }
}