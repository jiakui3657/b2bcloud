package com.haoxuer.meicloud.wms.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.meicloud.wms.data.dao.WarehouseCatalogDao;
import com.haoxuer.meicloud.wms.data.entity.WarehouseCatalog;
import com.haoxuer.meicloud.wms.data.service.WarehouseCatalogService;

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
* Created by imake on 2019年11月20日17:46:43.
*/


@Scope("prototype")
@Service
@Transactional
public class WarehouseCatalogServiceImpl implements WarehouseCatalogService {

	private WarehouseCatalogDao dao;


	@Override
	@Transactional(readOnly = true)
	public WarehouseCatalog findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<WarehouseCatalog> findByTops(Integer pid) {
		LinkedList<WarehouseCatalog> result = new LinkedList<WarehouseCatalog>();
		WarehouseCatalog catalog = dao.findById(pid);
	    if(catalog != null){
			while ( catalog != null && catalog.getParent() != null ) {
				result.addFirst(catalog);
				catalog = dao.findById(catalog.getParentId());
			}
			result.addFirst(catalog);
	    }
		return result;
	}


    @Override
    public List<WarehouseCatalog> child(Integer id,Integer max) {
        List<Order> orders=new ArrayList<Order>();
        orders.add(Order.asc("code"));
        List<Filter> list=new ArrayList<Filter>();
        list.add(Filter.eq("parent.id",id));
        return dao.list(0,max,list,orders);
	}

	@Override
    @Transactional
	public WarehouseCatalog save(WarehouseCatalog bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public WarehouseCatalog update(WarehouseCatalog bean) {
		Updater<WarehouseCatalog> updater = new Updater<WarehouseCatalog>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public WarehouseCatalog deleteById(Integer id) {
		WarehouseCatalog bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public WarehouseCatalog[] deleteByIds(Integer[] ids) {
		WarehouseCatalog[] beans = new WarehouseCatalog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(WarehouseCatalogDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<WarehouseCatalog> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<WarehouseCatalog> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<WarehouseCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}