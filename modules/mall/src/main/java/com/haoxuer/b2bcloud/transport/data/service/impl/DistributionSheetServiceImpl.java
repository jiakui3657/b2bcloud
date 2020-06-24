package com.haoxuer.b2bcloud.transport.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.b2bcloud.transport.data.dao.DistributionSheetDao;
import com.haoxuer.b2bcloud.transport.data.entity.DistributionSheet;
import com.haoxuer.b2bcloud.transport.data.service.DistributionSheetService;

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
* Created by imake on 2020年03月21日16:55:54.
*/


@Scope("prototype")
@Service
@Transactional
public class DistributionSheetServiceImpl implements DistributionSheetService {

	private DistributionSheetDao dao;


	@Override
	@Transactional(readOnly = true)
	public DistributionSheet findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public DistributionSheet save(DistributionSheet bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public DistributionSheet update(DistributionSheet bean) {
		Updater<DistributionSheet> updater = new Updater<DistributionSheet>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public DistributionSheet deleteById(Long id) {
		DistributionSheet bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public DistributionSheet[] deleteByIds(Long[] ids) {
		DistributionSheet[] beans = new DistributionSheet[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(DistributionSheetDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<DistributionSheet> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<DistributionSheet> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<DistributionSheet> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}